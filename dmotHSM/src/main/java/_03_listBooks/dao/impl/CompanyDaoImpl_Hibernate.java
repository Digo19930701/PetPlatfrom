package _03_listBooks.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _03_listBooks.dao.CompanyDao;
import _03_listBooks.model.CompanyBean;

// 本類別負責讀取資料庫內BookCompany表格內的紀錄
// 
@Repository
public class CompanyDaoImpl_Hibernate implements Serializable, CompanyDao {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CompanyDaoImpl_Hibernate.class);
	
	SessionFactory factory;
	
	@Autowired
	public CompanyDaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public CompanyBean findById(Integer id) {
		Session session = factory.getCurrentSession();
		CompanyBean companyBean = session.get(CompanyBean.class, id);
		log.info("CompanyDaoImpl_Hibernate#findById(), CompanyBean=" + companyBean);
		return companyBean;
	}

	@Override
	public List<CompanyBean> findAll() {
		List<CompanyBean> list = new ArrayList<>();
		String hql = "FROM CompanyBean";
		
		Session session = factory.getCurrentSession();
		
		list = session.createQuery(hql, CompanyBean.class)
				      .getResultList();
		
		log.info("新增與更新書籍之前置作業之Dao#findAll(), List<CompanyBean>=" + list); 
		return list;
	}
}