package expensemanager.Model.User;

import expensemanager.Model.Account.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_Id;

    @NotNull
    private String user_Name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private long balance;

    @NotNull
    private Boolean is_user_active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account",referencedColumnName = "account_id")
    private Account account;


    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Boolean getIs_user_active() {
        return is_user_active;
    }

    public void setIs_user_active(Boolean is_user_active) {
        this.is_user_active = is_user_active;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User(String user_Name, String email, String password, long balance, Boolean is_user_active, Account account) {
        this.user_Name = user_Name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.is_user_active = is_user_active;
        this.account = account;
    }

    public User(){}
}
