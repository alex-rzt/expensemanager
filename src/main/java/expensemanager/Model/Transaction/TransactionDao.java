package expensemanager.Model.Transaction;

import expensemanager.Model.Category.Category;
import expensemanager.Model.User.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    }

