package expensemanager.Services;

import expensemanager.POJO.PayeePojo;

/**
 * Created by alex on 9/5/17.
 */
public interface PayeeServices
{
    public String savePayee(PayeePojo payeePojo);
    public String deletePayee(PayeePojo payeePojo);
}