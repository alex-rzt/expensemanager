package expensemanager.Services;

import expensemanager.POJO.TransactionPojo;

/**
 * Created by alex on 9/5/17.
 */
public interface TransactionServices
{
    public String saveTransaction(TransactionPojo transactionPojo);
}
