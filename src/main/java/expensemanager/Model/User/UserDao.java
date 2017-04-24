package expensemanager.Model.User;

import expensemanager.Model.Transaction.Transaction;
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
public class UserDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    private void save(User user)
    {
        getSession().save(user);
    }

    private void delete(User user)
    {
        getSession().delete(user);
    }
    private void update(User user)
    {
        getSession().update(user);
    }
}
