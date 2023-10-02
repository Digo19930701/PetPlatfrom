package com.ispan.eeit._00_init.web;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ispan.eeit._00_common.GlobalService;

@WebListener
public class SystemInitializationListener implements ServletContextListener {
    Logger log = LoggerFactory.getLogger(SystemInitializationListener.class);
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	log.info("SystemInitializationListener#contextInitialized()執行中...");
    	
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("SYSTEM", new GlobalService() );
    	log.info("已經將GlobalService 物件放入applicationScope中");
    	
    	File memberFolder = new File(GlobalService.IMAGE_FILE_FOLDER_MEMBER);
    	if (!memberFolder.exists()) {
    		memberFolder.mkdirs();
    	}
    	File bookFolder = new File(GlobalService.IMAGE_FILE_FOLDER_BOOK);
    	if (!bookFolder.exists()) {
    		bookFolder.mkdirs();
    	}
    }
	
}
