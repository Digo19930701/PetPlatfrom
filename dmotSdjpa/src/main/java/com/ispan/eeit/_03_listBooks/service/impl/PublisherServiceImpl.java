package com.ispan.eeit._03_listBooks.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._03_listBooks.dao.PublisherRepository;
import com.ispan.eeit._03_listBooks.model.Publisher;
import com.ispan.eeit._03_listBooks.service.PublisherService;
// 本類別負責讀取資料庫內Publisher_Table表格內的紀錄
//
@Service
@Transactional
public class PublisherServiceImpl implements Serializable, PublisherService {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);

	PublisherRepository publisherRepository;
//	@Autowired
	public PublisherServiceImpl(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}

	
	@Override
	public List<Publisher> findAll() {
		List<Publisher> publisher = null;
		publisher = publisherRepository.findAll();
		log.info("新增與更新書籍之前置作業之Service#findAll() Publisher=" + publisher);
		return publisher;
	}
	
	@Override
	public Optional<Publisher> findById(Long id) {
		Optional<Publisher> optional = publisherRepository.findById(id);
		log.info("Service#findById(), Publisher=" + optional);
		return optional;
	}
	
	@Override
	public String getSelectTag(String tagName, int selected) {
		String ans = "";
		List<Publisher> cb = findAll();
		ans += "<SELECT name='" + tagName + "'>";
		for (Publisher bean : cb) {
			Long id = bean.getId();
			String name = bean.getName().substring(0, 4);
			if (id == selected) {
				ans += "<option value='" + id + "' selected>" + name + "</option>";
			} else {
				ans += "<option value='" + id + "'>" + name + "</option>";
			}
		}
		ans += "</SELECT>";
		log.info("新增與更新書籍之前置作業之Service#getSelectTag(), getSelectTag=" + ans);
		return ans;
	}

}