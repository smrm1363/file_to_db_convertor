package com.mohammadreza_mirali.cvs_to_db_demo;

import com.mohammadreza_mirali.cvs_to_db_demo.Manager.CvsConvertor;
import com.mohammadreza_mirali.cvs_to_db_demo.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class CvsToDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvsToDbDemoApplication.class, args);
	}


@Autowired
CvsConvertor cvsConvertor;
@Autowired
BankDao bankDao;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the csv file path : ");
		String path = scanner.next();
		cvsConvertor.convertToDb(path);
		System.out.println("The selected data from PostgreSQL Database where its identifier is 10040000 : "+bankDao.getBankById(10010010).getName());

	}
}
