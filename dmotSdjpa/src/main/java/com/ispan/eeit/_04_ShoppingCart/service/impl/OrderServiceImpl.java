package com.ispan.eeit._04_ShoppingCart.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._00_common.GlobalService;
import com.ispan.eeit._01_register.dao.MemberRepository;
import com.ispan.eeit._03_listBooks.dao.BookRepository;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._04_ShoppingCart.dao.OrderItemRepository;
import com.ispan.eeit._04_ShoppingCart.dao.OrderRepository;
import com.ispan.eeit._04_ShoppingCart.model.OrderBean;
import com.ispan.eeit._04_ShoppingCart.model.OrderItemBean;
import com.ispan.eeit._04_ShoppingCart.model.ShoppingCart;
import com.ispan.eeit._04_ShoppingCart.service.OrderService;
import com.ispan.eeit._04_ShoppingCart.ude.ProductStockException;
import com.ispan.eeit._04_ShoppingCart.ude.UnpaidOrderAmountExceedingException;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private BookRepository bookRepository;
	private OrderItemRepository orderItemRepository;
	private OrderRepository orderRepository;
	private MemberRepository memberRepository;

//	@Autowired
	public OrderServiceImpl(BookRepository bookRepository, 
			                OrderItemRepository orderItemRepository, 
			                OrderRepository orderRepository, 
			                MemberRepository memberRepository) {
		this.bookRepository = bookRepository;
		this.orderItemRepository = orderItemRepository;
		this.orderRepository = orderRepository;
		this.memberRepository = memberRepository;
	}

	@Override
	// 這是一個交易
	public void save(OrderBean orderBean) {
			log.info("處理訂單之Service:交易開始");
			// 交易開始
			// 檢查未付款餘額是否超過限額，並更新未付款餘額
			log.info("處理訂單之Service: 1. 準備處理會員之未付款餘額");
			//memberService.checkUnpaidAmount(ob); // ***
			double currentAmount = orderBean.getTotalAmount(); // 取出該訂單的總金額
			double unpaidAmount = memberRepository.findByMemberId(orderBean.getMemberId()).getUnpaid_amount();
			if (currentAmount + unpaidAmount > GlobalService.ORDER_AMOUNT_LIMIT) {
				log.info("處理訂單之Repository: 未付款金額超過限額: " + (currentAmount + unpaidAmount));
				throw new UnpaidOrderAmountExceedingException("未付款金額超過限額: " 
							+ (currentAmount + unpaidAmount));
			} 			
			memberRepository.updateUnpaidAmount(orderBean.getTotalAmount(), orderBean.getMemberId());
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
			// 檢查所有訂單明細所訂購之商品的庫存數量是否足夠
			checkStock(orderBean);
			// 儲存訂單
			log.info("處理訂單之Service: 3. 準備儲存訂單");
			orderRepository.save(orderBean);
	}

	public void checkStock(OrderBean orderBean) {
		Set<OrderItemBean> items = orderBean.getItems();
		
		log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
		for (OrderItemBean orderItemBean : items) {
			long bookId = orderItemBean.getBookId();
			Optional<Book> optional = bookRepository.findById(bookId);
			Book book = null;
			if (optional.isPresent()) {
				book = optional.get();
			} else {
				throw new RuntimeException("發生異常: 書籍不存在, 主鍵值=" + bookId);
			}
			int stock = book.getStock(); // getStock(); 
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + orderItemBean.getBookId());
			if (stock < orderItemBean.getQuantity()) {
				log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + orderItemBean.getBookId() + " 庫存不足");
				throw new ProductStockException(
						"庫存數量不足: BookId: " + orderItemBean.getBookId() + ", 在庫量: " + stock + ", 訂購量: " + orderItemBean.getQuantity());
			} else {
				log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + orderItemBean.getBookId() + " 庫存足夠");
				orderItemRepository.updateProductStock(orderItemBean.getQuantity(), orderItemBean.getId());
			}
		}
	}
	
	public void preCheckStock(ShoppingCart shoppingCart) {
		log.info("訂單前期檢查之Service, 開始"); 
		Set<Long> set = shoppingCart.getContent().keySet();
		
			for (Long i : set) {
				OrderItemBean oib = shoppingCart.getContent().get(i);
//				int stock = bookRepository.findById(oib.getBookId()).getStock();
				int stock = 0;
				if (stock < oib.getQuantity()) {
					log.info("訂單前期檢查之Service preCheckStock(): 庫存數量不足, " +
							oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
					throw new ProductStockException("庫存數量不足: 商品: " 
							+ oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
				} 
			}
			log.info("訂單前期檢查之Service preCheckStock(): 未發現任何商品數量不足");
	}

	@Override
	public  Optional<OrderBean> findById(Long orderNo) {
		log.info("依照orderNo編號讀取特定一筆訂單的所有資料之Service, orderNo=" + orderNo);
//        Session session = factory.getCurrentSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
            Optional<OrderBean> optional = orderRepository.findById(orderNo);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException(e);
//        } 
		return optional;
	}

	@Override
	public List<OrderBean> findByMemberId(String memberId) {
		log.info("依照memberId編號讀取某位會員所有訂單之Service: memberId=" + memberId);
		List<OrderBean> orderBeanList = orderRepository.findByMemberId(memberId);
        return orderBeanList;
		
	}

	

}
