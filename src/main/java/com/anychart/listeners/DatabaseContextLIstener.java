package com.anychart.listeners;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseContextLIstener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        MysqlDataSource ds = new MysqlDataSource();
        ds.setDatabaseName("anychart_db");
        ds.setUser("anychart_user");
        ds.setPassword("anychart_pass");
        context.setAttribute("DBDataSource", ds);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
