package expensemanager.Model.Payee;

import expensemanager.Model.Category.Category;
import expensemanager.Model.Transaction.Transaction;
import expensemanager.Model.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Payee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payee_id;

    @NotNull
    private String payee_name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "payee",cascade = CascadeType.ALL)
    private Collection<Transaction> transactions=new ArrayList<Transaction>();

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }
    /*@NotNull
    private boolean is_payee_active;*/

    public int getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(int payee_id) {
        this.payee_id = payee_id;
    }

    public String getPayee_name() {
        return payee_name;
    }

    public void setPayee_name(String payee_name) {
        this.payee_name = payee_name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    /* public boolean isIs_payee_active() {
            return is_payee_active;
        }

        public void setIs_payee_active(boolean is_payee_active) {
            this.is_payee_active = is_payee_active;
        }*/


    public Payee(String payee_name/*, boolean is_payee_active*/) {
        this.payee_name = payee_name;
        /*this.is_payee_active = is_payee_active;*/
    }

    public Payee(){}
}
