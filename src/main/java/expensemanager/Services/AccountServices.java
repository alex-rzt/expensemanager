package expensemanager.Services;

import expensemanager.POJO.AccountPojo;

/**
 * Created by alex on 8/5/17.
 */
public interface AccountServices
{
    public String saveAccount(AccountPojo accountPojo);
    public String getAccountBalance(AccountPojo accountPojo);
    public String getAccountExpenditure(AccountPojo accountPojo);
    public String deleteAccount(AccountPojo accountPojo);
}
