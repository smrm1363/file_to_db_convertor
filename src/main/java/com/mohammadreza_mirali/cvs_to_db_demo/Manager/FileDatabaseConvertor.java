package com.mohammadreza_mirali.cvs_to_db_demo.Manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * I use an interface duo to may be in the future we will have different kind of file and will be needed different logic
 */
public interface FileDatabaseConvertor {
    /**
     * will be implemented to read data from file and convert it to database
     * @param filePath
     * @return
     */
    public void convertToDb(String filePath) throws IOException;
}
