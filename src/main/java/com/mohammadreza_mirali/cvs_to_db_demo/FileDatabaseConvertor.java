package com.mohammadreza_mirali.cvs_to_db_demo;

import java.util.List;

public interface FileDatabaseConvertor {
    /**
     * will be implemented to read data from file and convert it to database
     * @param filePath
     * @return
     */
    public List convertToDb(String filePath);
}
