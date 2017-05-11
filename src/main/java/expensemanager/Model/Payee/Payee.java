package expensemanager.Model.Payee;

import expensemanager.Model.Category.Category;
import expensemanager.Model.Transaction.Transaction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Payee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payee_id")
    private int payeeId;

    @NotNull
    @Column(name = "payee_name")
    private String payeeName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(mappedBy = "payee",cascade = CascadeType.ALL)
    private Collection<Transaction> transactions=new ArrayList<Transaction>();

    @Column(name = "is_payee_active")
    private Boolean isPayeeActive;

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Boolean getPayeeActive() {
        return isPayeeActive;
    }

    public void setPayeeActive(Boolean payeeActive) {
        isPayeeActive = payeeActive;
    }

    public Payee(String payeeName,Boolean isPayeeActive)
    {
        this.payeeName = payeeName;
        this.isPayeeActive=isPayeeActive;
    }

    public Payee(){}
}
