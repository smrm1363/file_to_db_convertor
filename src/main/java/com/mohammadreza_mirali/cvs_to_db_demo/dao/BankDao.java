package com.mohammadreza_mirali.cvs_to_db_demo.dao;

import com.mohammadreza_mirali.cvs_to_db_demo.entity.Bank;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mmirali on 30/07/2018.
 */

/**
 * This is a DAO for Bank entity
 */
@Transactional
@Component("BankDao")
public class BankDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Bank getBankById(Integer id) {
        return entityManager.find(Bank.class, id);

    }

    @SuppressWarnings("unchecked")
    public List<Bank> getAllBanks() {
        String hql = "FROM Bank as b";
        return (List<Bank>) entityManager.createQuery(hql).getResultList();
    }

    public void addBank(Bank bank) {
        entityManager.persist(bank);
    }

    public void updateBank(Bank bank) {
        Bank bnk = getBankById(bank.getIdentifire());
        bnk.setName(bank.getName());
        entityManager.flush();
    }

    public void deleteBank(Integer id) {
        entityManager.remove(getBankById(id));
    }
}
