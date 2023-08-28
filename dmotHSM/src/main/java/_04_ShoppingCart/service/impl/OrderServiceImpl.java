package _04_ShoppingCart.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _00_init.util.GlobalService;
import _01_register.dao.MemberDao;
import _03_listBooks.dao.BookDao;
import _04_ShoppingCart.dao.OrderDao;
import _04_ShoppingCart.dao.OrderItemDao;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.OrderItemBean;
import _04_ShoppingCart.model.ShoppingCart;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.ude.ProductStockException;
import _04_ShoppingCart.ude.UnpaidOrderAmountExceedingException;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private BookDao bookDao;
	private OrderItemDao orderItemDao;
	private OrderDao orderDao;
	private MemberDao memberDao;

	@Autowired
	public OrderServiceImpl(BookDao bookDao, OrderItemDao orderItemDao, OrderDao orderDao, MemberDao memberDao) {
		this.bookDao = bookDao;
		this.orderItemDao = orderItemDao;
		this.orderDao = orderDao;
		this.memberDao = memberDao;
	}

	@Override
	// 這是一個交易
	public void persistOrder(OrderBean ob) {
//		Session session = factory.getCurrentSession();
//        Transaction tx = null;
//		try {
			log.info("處理訂單之Service:交易開始");
			// 交易開始
//			tx = session.beginTransaction();

			// 檢查未付款餘額是否超過限額，並更新未付款餘額
			log.info("處理訂單之Service: 1. 準備處理會員之未付款餘額");
			//memberService.checkUnpaidAmount(ob); // ***
			double currentAmount = ob.getTotalAmount(); // 取出該訂單的總金額
			double unpaidAmount = memberDao.findByMemberId(ob.getMemberId()).getUnpaid_amount();
			if (currentAmount + unpaidAmount > GlobalService.ORDER_AMOUNT_LIMIT) {
				log.info("處理訂單之Dao: 未付款金額超過限額: " + (currentAmount + unpaidAmount));
				throw new UnpaidOrderAmountExceedingException("未付款金額超過限額: " 
							+ (currentAmount + unpaidAmount));
			} 			
			memberDao.updateUnpaidAmount(ob);
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
			// 檢查所有訂單明細所訂購之商品的庫存數量是否足夠
			checkStock(ob);
			
			// 儲存訂單
			log.info("處理訂單之Service: 3. 準備儲存訂單");
			orderDao.save(ob);
//            tx.commit();
//		} catch (Exception e) {
//            if (tx != null)  tx.rollback();
//            log.info("發生異常，交易回滾.....,原因: " + e.getMessage());
//            throw new RuntimeException(e);
//        } 
	}

	public void checkStock(OrderBean ob) {
		Set<OrderItemBean> items = ob.getItems();
		
		log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
		for (OrderItemBean oib : items) {
			int stock = bookDao.findById(oib.getBookId()).getStock(); 
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + oib.getBookId());
			if (stock < oib.getQuantity()) {
				log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + oib.getBookId() + " 庫存不足");
				throw new ProductStockException(
						"庫存數量不足: BookId: " + oib.getBookId() + ", 在庫量: " + stock + ", 訂購量: " + oib.getQuantity());
			} else {
				log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + oib.getBookId() + " 庫存足夠");
				orderItemDao.updateProductStock(oib);
			}
		}
	}
	
	public void preCheckStock(ShoppingCart shoppingCart) {
		log.info("訂單前期檢查之Service, 開始"); 
		Set<Integer> set = shoppingCart.getContent().keySet();
		
//		Session session = factory.getCurrentSession();
//        Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			for (Integer i : set) {
				OrderItemBean oib = shoppingCart.getContent().get(i);
				int stock = bookDao.findById(oib.getBookId()).getStock();
				if (stock < oib.getQuantity()) {
					log.info("訂單前期檢查之Service preCheckStock(): 庫存數量不足, " +
							oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
					throw new ProductStockException("庫存數量不足: 商品: " 
							+ oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
				} 
			}
			log.info("訂單前期檢查之Service preCheckStock(): 未發現任何商品數量不足");
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)  tx.rollback();
//            log.info("發生異常，交易回滾.....,原因: " + e.getMessage());
//            throw new RuntimeException(e);
//		}
	}

	@Override
	public OrderBean findById(int orderNo) {
		log.info("依照orderNo編號讀取特定一筆訂單的所有資料之Service, orderNo=" + orderNo);
		OrderBean  bean = null;
//        Session session = factory.getCurrentSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
            bean = orderDao.findById(orderNo);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException(e);
//        } 
		return bean;
	}

	@Override
	public List<OrderBean> findByMemberId(String memberId) {
		log.info("依照memberId編號讀取某位會員所有訂單之Service: memberId=" + memberId);
//		Session session = factory.getCurrentSession();
		List<OrderBean> list = null;
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
            list = orderDao.findByMemberId(memberId);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException(e);
//        } 
        return list;
		
	}

}
