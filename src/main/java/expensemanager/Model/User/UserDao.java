package expensemanager.Model.User;

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
public class UserDao
{
    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    public void save(User user)
    {
        getSession().save(user);
    }
    public void saveOrUpdate(User user){getSession().saveOrUpdate(user);}

    public void delete(User user)
    {
        getSession().delete(user);
    }
    public void update(User user)
    {
        getSession().update(user);
    }
    public List<User> getById(int id)
    {
            Criteria criteria=getSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("userId",id))
                    .add(Restrictions.eq("isUserActive",true));
            List <User> users=(List<User>)criteria.list();
            return  users;
    }
    public List<User> getByNameAndPassword(String name,long password)
    {
        Criteria criteria=getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName",name))
                .add(Restrictions.eq("password",password))
                .add(Restrictions.eq("isUserActive",true));
        List <User> users=(List<User>)criteria.list();
        return  users;
    }

    public List<User> getByName(String name)
    {
        Criteria criteria=getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName",name))
                .add(Restrictions.eq("isUserActive",true));
        List <User> users=(List<User>)criteria.list();
        return  users;
    }
}
