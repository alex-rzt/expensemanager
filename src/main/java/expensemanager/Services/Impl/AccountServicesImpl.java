package expensemanager.Services.Impl;

import expensemanager.Model.Account.Account;
import expensemanager.Model.Account.AccountDao;
import expensemanager.Model.Transaction.Transaction;
import expensemanager.Model.Transaction.TransactionDao;
import expensemanager.Model.User.User;
import expensemanager.Model.User.UserDao;
import expensemanager.POJO.AccountPojo;
import expensemanager.Services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static expensemanager.Constants.Constant.id;

/**
 * Created by alex on 8/5/17.
 */
@Service
public class AccountServicesImpl implements AccountServices
{
    @Autowired
    UserDao userDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionDao transactionDao;

    @Override
    public String saveAccount(AccountPojo accountPojo)
    {

        if(id==0)
        {
            return "Login first";
        }
        else
        {
            List<Account> account1 = accountDao.getByNameAndId(accountPojo.getAccountName(), id);
            if (account1.size()==0)
            {
                List<User> user = userDao.getById(id);
                Account account = new Account(accountPojo.getAccountName(),accountPojo.getBalance(),true);
                Collection<Account> accounts=new ArrayList<Account>();
                accounts.add(account);
                user.get(0).setAccount(accounts);
                long user_balance=user.get(0).getBalance()+accountPojo.getBalance();
                user.get(0).setBalance(user_balance);
                account.setUser(user.get(0));
                accountDao.save(account);
                return "Account set";
            }
            else
            {
                return "Account already present for this user!!";
            }
        }
    }

    @Override
    public String getAccountBalance(AccountPojo accountPojo)
    {
        if(id==0)
        {
            return "Login first!!";
        }
        else
        {
            List<Account> accounts = accountDao.getByNameAndId(accountPojo.getAccountName(), id);
            if(accounts.size()!=0)
            {
                long balance=accounts.get(0).getAccountBalance();
                return accountPojo.getAccountName()+" balance : "+balance;

            }
            else
            {
                return "No such account present for this user!!";
            }
        }
    }

    @Override
    public String getAccountExpenditure(AccountPojo accountPojo)
    {
        if(id==0)
        {
            return "Login first";
        }
        else
        {
            long expenditure=0;
            List<Account> account=accountDao.getByNameAndId(accountPojo.getAccountName(),id);
            if(account.size()!=0)
            {
                List<Transaction> transactions=transactionDao.getByAccountId(account.get(0).getAccountId());
                for (int i=0;i<transactions.size();i++)
                {
                    expenditure=expenditure+transactions.get(i).getTransactionAmount();
                }
                return "Expenditure for account "+accountPojo.getAccountName()+" : "+ expenditure;

            }
            else
            {
                return "No such account present for this user!!";
            }
        }
    }

    @Override
    public String deleteAccount(AccountPojo accountPojo)
    {

        if (id==0)
        {
            return "Login first!!";
        }
        else
        {
            List<Account> accounts = accountDao.getByNameAndId(accountPojo.getAccountName(), id);
            if(accounts.size()==0)
            {
                return "No such account present for this user!!";
            }
            else
            {
                List<User> user = userDao.getById(id);
                System.out.println(user.get(0).getBalance()+"  "+accounts.get(0).getAccountBalance());
                long balance=user.get(0).getBalance()-accounts.get(0).getAccountBalance();
                System.out.println(balance);
                accounts.get(0).setIsAccountActive(false);
                accountDao.update(accounts.get(0));
                user.get(0).setBalance(balance);
                userDao.update(user.get(0));
                return accountPojo.getAccountName() +" deleted ";
            }
        }
    }
 }

