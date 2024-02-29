package org.example.dao;

import org.example.dao.impl.FileProductDao;


public final class DaoProvider {
    private final static DaoProvider instance = new DaoProvider();

    private FileProductDao productFileDao = new FileProductDao();


    public FileProductDao getFileProductDao() {
        return productFileDao;
    }

    public static DaoProvider getInstance() {
        return instance;
    }


}
