package expensemanager.Services.Impl;

import expensemanager.Model.Category.Category;
import expensemanager.Model.Category.CategoryDao;
import expensemanager.Model.Payee.Payee;
import expensemanager.Model.Payee.PayeeDao;
import expensemanager.POJO.PayeePojo;
import expensemanager.Services.PayeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static expensemanager.Constants.Constant.id;

/**
 * Created by alex on 9/5/17.
 */
@Service
public class PayeeServicesImpl implements PayeeServices
{
    @Autowired
    PayeeDao payeeDao;

    @Autowired
    CategoryDao categoryDao;

    @Override
    public String savePayee(PayeePojo payeePojo) {
        List<Payee> paye=payeeDao.getByName(payeePojo.getPayeeName());
        if (paye.size()==0)
        {
            List<Category> categories=categoryDao.getByName(payeePojo.getCatName());
            if(categories.size()==0)
            {
                Category category=new Category(payeePojo.getCatName(),true);
                categoryDao.save(category);
                Payee payee=new Payee(payeePojo.getPayeeName(),true);
                Collection<Payee> payees=new ArrayList<>();
                payees.add(payee);
                category.setPayees(payees);
                payee.setCategory(category);
                payeeDao.save(payee);

                return "Payee set with new category";
            }
            else
            {
                Payee payee=new Payee(payeePojo.getPayeeName(),true);
                Collection<Payee> payees= new ArrayList<>();
                payees.add(payee);
                categories.get(0).setPayees(payees);
                payee.setCategory(categories.get(0));
                payeeDao.save(payee);
                return "Payee set";
            }
        }
        else
        {
            return "Payee already present";
        }
    }

    @Override
    public String deletePayee(PayeePojo payeePojo)
    {
        if (id==0)
        {
            return "Login first!!";
        }
        else
        {
            List<Payee> payees = payeeDao.getByName(payeePojo.getPayeeName());
            if(payees.size()==0)
            {
                return "No such payee is present!!";
            }
            else
            {
                payees.get(0).setPayeeActive(false);
                payeeDao.update(payees.get(0));
                return "Payee deleted";
            }
        }
    }
}
