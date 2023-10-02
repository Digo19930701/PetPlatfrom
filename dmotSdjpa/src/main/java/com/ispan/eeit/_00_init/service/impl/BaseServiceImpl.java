package com.ispan.eeit._00_init.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._00_init.dao.BaseRepository;
import com.ispan.eeit._00_init.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl implements BaseService {

	private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	BaseRepository  baseRepository;
//    @Autowired
	public BaseServiceImpl(BaseRepository  baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Override
	public void initData() {
		log.info("BaseServiceImpl#initData()開始執行");
		baseRepository.rebuildTableAndIndex();
		baseRepository.loadInitData();
	}
}
