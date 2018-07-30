package com.mohammadreza_mirali.cvs_to_db_demo.Manager;

import com.mohammadreza_mirali.cvs_to_db_demo.dao.BankDao;
import com.mohammadreza_mirali.cvs_to_db_demo.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by mmirali on 30/07/2018.
 */
@Component("CvsConvertor")
public class CvsConvertor implements FileDatabaseConvertor {

    @Autowired
    BankDao bankDao;

    /**
     * This is the responsible of converting file content to database records
     * @param filePath is path of CSV file
     * @throws IOException may be happened if file does not exist or format of file is wrong
     */
    @Override
    public void convertToDb(String filePath) throws IOException {
        List<Bank> bankList;
        bankList = createBankListFromFile(filePath);
        bankList.stream().forEach((p)->
        {
            bankDao.addBank(p);
        });
        System.out.println("The data from the file has been just inserted ...");

    }

    /**
     * this is for mapping between our file extracted result and Bank entity
     */
    private Function<String, Bank> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has comma separated lines
        Bank item = new Bank();
        item.setIdentifire(Integer.valueOf(p[1]));//<-- this is the first column in the csv file
        item.setName(p[0]);

        return item;
    };

    /**
     *
     * @param filePath is path os CSV file
     * @return a list of Bank entity as extracted from CSV file
     * @throws IOException may be happened when reading file
     */
    public List<Bank> createBankListFromFile(String filePath) throws IOException {
        List<Bank> bankList = new ArrayList<Bank>();
        File inputF = new File(filePath);
        InputStream inputFS = new FileInputStream(inputF);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        // skip the header of the csv
        bankList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        br.close();
        return bankList;
    }
}
