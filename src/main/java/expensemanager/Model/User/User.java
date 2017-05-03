package expensemanager.Model.User;

import expensemanager.Model.Account.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_Id;


    private String user_Name;


    private String email;


    private String password;


    private long balance;

    /*@NotNull
    private Boolean is_user_active;*/

    /*@ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private Collection<Account> account=new ArrayList<Account>();

    public Collection<Account> getAccount() {
        return account;
    }

    public void setAccount(Collection<Account> account) {
        this.account = account;
    }*/
     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<Account> account=new ArrayList<Account>();

    public Collection<Account> getAccount() {
        return account;
    }

    public void setAccount(Collection<Account> account) {
        this.account = account;
    }
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_account", joinColumns = @JoinColumn(name = "user_Id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Collection<Account> accounts = new ArrayList<>();

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }*/

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

   /* public Boolean getIs_user_active() {
        return is_user_active;
    }

    public void setIs_user_active(Boolean is_user_active) {
        this.is_user_active = is_user_active;
    }*/

    public User(String user_Name, String email, String password, long balance/*, Boolean is_user_active*//*, Account account*/) {
        this.user_Name = user_Name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        /*this.is_user_active = is_user_active;*/
        /*this.account = account;*/
    }

    public User(){}
}
