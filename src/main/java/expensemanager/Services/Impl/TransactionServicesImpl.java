package expensemanager.Services.Impl;

import expensemanager.Model.Account.Account;
import expensemanager.Model.Account.AccountDao;
import expensemanager.Model.Category.Category;
import expensemanager.Model.Category.CategoryDao;
import expensemanager.Model.Payee.Payee;
import expensemanager.Model.Payee.PayeeDao;
import expensemanager.Model.Transaction.Transaction;
import expensemanager.Model.Transaction.TransactionDao;
import expensemanager.POJO.TransactionPojo;
import expensemanager.Services.TransactionServices;
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
public class TransactionServicesImpl implements TransactionServices
{
    @Autowired
    AccountDao accountDao;

    @Autowired
    PayeeDao payeeDao;

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    CategoryDao categoryDao;

    @Override
    public String saveTransaction(TransactionPojo transactionPojo)
    {
        System.out.println(id);
        if(id==0)
        {
            return "Login first!";
        }
        else
        {
            List<Account> accounts = accountDao.getByNameAndId(transactionPojo.getAccount(), id);
            if (accounts.size() != 0)
            {
                List<Payee> payees = payeeDao.getByName(transactionPojo.getPayee());
                if (payees.size() == 0)
                {
                    List<Category> categories=categoryDao.getByName(transactionPojo.getCategory());
                    if (categories.size()==0)
                    {
                        Category category=new Category(transactionPojo.getCategory(),true);
                        categoryDao.save(category);
                        Payee payee=new Payee(transactionPojo.getPayee(),true);
                        Collection<Payee> payees1=new ArrayList<>();
                        payees1.add(payee);
                        category.setPayees(payees1);
                        payee.setCategory(category);
                        payeeDao.save(payee);

                        setTransaction(transactionPojo,category.getCategoryId(),payee,accounts.get(0));
                        return "Transaction set with new payee and category";

                    }
                    else
                    {
                        Payee payee=new Payee(transactionPojo.getPayee(),true);
                        Collection<Payee> payees1= new ArrayList<>();
                        payees1.add(payee);
                        categories.get(0).setPayees(payees1);
                        payee.setCategory(categories.get(0));

                        setTransaction(transactionPojo,categories.get(0).getCategoryId(),payee,accounts.get(0));
                        return "Transaction set with new payee";
                    }
                }
                else
                {
                    int id1 = payees.get(0).getCategory().getCategoryId();
                    
                    setTransaction(transactionPojo,id1,payees.get(0),accounts.get(0));
                    return "Transaction set";
                }
            }
            else
            {
                return "Account not present";
            }
        }
    }
    private void setTransaction(TransactionPojo transactionPojo,int id1,Payee payees,Account account)
    {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionPojo.getTransactionType());
        transaction.setTransactionAmount(transactionPojo.getAmount());
        transaction.setCategoryId(id1);
        Collection<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        payees.setTransactions(transactions);
        transaction.setPayee(payees);

        int user_id = account.getUser().getUserId();
        transaction.setUserId(user_id);
        account.setTransactions(transactions);
        transaction.setAccount(account);
        long user_balance=0;
        long temp_balance = account.getAccountBalance();
        if(transactionPojo.getTransactionType().equalsIgnoreCase("expense"))
        {
            user_balance= account.getUser().getBalance() - transactionPojo.getAmount();
            temp_balance = temp_balance - transactionPojo.getAmount();
        }
        else
        {
            user_balance= account.getUser().getBalance() + transactionPojo.getAmount();
            temp_balance = temp_balance + transactionPojo.getAmount();
        }

        account.getUser().setBalance(user_balance);
        account.setAccountBalance(temp_balance);

        transactionDao.save(transaction);
    }
}
