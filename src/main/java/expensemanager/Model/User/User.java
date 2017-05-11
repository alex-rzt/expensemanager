package expensemanager.Model.User;

import expensemanager.Model.Account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private long password;

    @Column(name = "balance")
    private long balance;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<Account> account=new ArrayList<Account>();

    @Column(name = "is_user_active")
    private boolean isUserActive;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Collection<Account> getAccount() {
        return account;
    }

    public void setAccount(Collection<Account> account) {
        this.account = account;
    }

    public boolean getIsUserActive()
    {
        return isUserActive;
    }

    public void setIsUserActive(boolean isUserActive)
    {
        this.isUserActive = isUserActive;
    }

    public User(String userName, String email, long password, long balance,boolean isUserActive)
    {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.isUserActive = isUserActive;
    }

    public User(int id)
    {
        this.userId=id;
    }
    public User(){}
}
