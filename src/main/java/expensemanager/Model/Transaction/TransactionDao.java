package expensemanager.Model.Transaction;

import expensemanager.Model.Account.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alex on 24/4/17.
 */

  @Repository
    @Transactional
    public class TransactionDao
    {
        @Autowired
        private SessionFactory sessionFactory;

        private Session getSession()
        {
            return sessionFactory.getCurrentSession();
        }
        public void save(Transaction transaction)
        {
            getSession().save(transaction);
        }
        public void delete(Transaction transaction)
        {
            getSession().delete(transaction);
        }
        public void update(Transaction transaction)
        {
            getSession().update(transaction);
        }
        public List<Transaction> getByUserId(int id)
        {
            Criteria criteria=getSession().createCriteria(Transaction.class);
            criteria.add(Restrictions.eq("userId",id));
            List <Transaction> transactions=(List<Transaction>)criteria.list();
            return  transactions;
        }
        public List<Transaction> getByAccountId(int id)
        {
            Account account=new Account();
            account.setAccountId(id);
            Criteria criteria=getSession().createCriteria(Transaction.class);
            criteria.add(Restrictions.eq("account",account));
            List <Transaction> transactions=(List<Transaction>)criteria.list();
            return  transactions;
        }


    }

