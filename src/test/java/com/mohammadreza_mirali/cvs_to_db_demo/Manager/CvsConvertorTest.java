package com.mohammadreza_mirali.cvs_to_db_demo.Manager;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by mmirali on 30/07/2018.
 */

public class CvsConvertorTest {

    CvsConvertor cvsConvertor = new CvsConvertor();
    @Test
    public void convertToDb() throws Exception {
    }

    @Test
    public void createBankListFromFile() throws Exception {

        cvsConvertor.createBankListFromFile("com/mohammadreza_mirali/cvs_to_db_demo/Manager/test.csv") ;
    }

}