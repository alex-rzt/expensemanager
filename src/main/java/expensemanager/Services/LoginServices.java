package expensemanager.Services;

import expensemanager.POJO.UserPojo;

/**
 * Created by alex on 8/5/17.
 */
public interface LoginServices
{
    public String login(UserPojo userPojo);
    public String logout();
}
