package expensemanager.Services.Impl;

import expensemanager.Model.Account.Account;
import expensemanager.Model.Account.AccountDao;
import expensemanager.Model.Transaction.Transaction;
import expensemanager.Model.Transaction.TransactionDao;
import expensemanager.Model.User.User;
import expensemanager.Model.User.UserDao;
import expensemanager.POJO.UserPojo;
import expensemanager.Services.UserServices;
import expensemanager.utils.MurmurHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static expensemanager.Constants.Constant.id;

/**
 * Created by alex on 8/5/17.
 */
@Service
public class UserServicesImpl implements UserServices
{
    @Autowired
    UserDao userDao;

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    AccountDao accountDao;

    @Override
    public String saveUser(UserPojo userPojo)
    {
        List<User> users=userDao.getByName(userPojo.getName());
        if(users.size()==0)
       {
         if (userPojo.getPassword().length()<6)
         {
             return "Password should be atleast 6 character long!!Try again";
         }
         else
         {
             long password1= MurmurHash.hash32(userPojo.getPassword());
             long user_balance=0;
             User user1 = new User(userPojo.getName(),userPojo.getEmail(), password1, user_balance,true);
             userDao.save(user1);
             return "User set";
         }

       }
       else
       {
         return "User already present";
       }
    }

    @Override
    public String getBalance()
    {
        if (id==0)
        {
            return "Login first";
        }
        else
        {
            long balance;
            List<User> user=userDao.getById(id);
            balance=user.get(0).getBalance();
            return "Total user balance : "+ balance;
        }
    }

    @Override
    public String getExpenditure() {
        if(id==0)
        {
            return "Login first!!";
        }
        else
        {
            long expenditure = 0;
            List<Transaction> transactions=transactionDao.getByUserId(id);
            for (int i=0;i<transactions.size();i++)
            {
                expenditure=expenditure+transactions.get(i).getTransactionAmount();
            }
            return "Total expenditure : "+expenditure;
        }

    }

    @Override
    public String deleteUser()
    {
        if(id==0)
        {
            return "Login first!";
        }
        else
        {
            List<User> user=userDao.getById(id);
            System.out.println(user.size());
            user.get(0).setIsUserActive(false);
            userDao.update(user.get(0));
            List<Account> accounts=accountDao.getAccountsByUserId(id);
            for (int i=0;i<accounts.size();i++)
            {
                accounts.get(i).setIsAccountActive(false);
                accountDao.update(accounts.get(i));
            }
            id=0;
            return "User deleted";
        }
    }
}
