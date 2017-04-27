package expensemanager.Model.Category;

import expensemanager.Model.Account.Account;
import expensemanager.Model.Payee.Payee;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;

    @NotNull
    private String category_name;


    /*@NotNull
    private Boolean is_category_active;*/

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_payee", referencedColumnName = "payee_id")
    private Payee payee ;*/
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Collection<Payee> payees=new ArrayList<Payee>();

    public Collection<Payee> getPayees() {
        return payees;
    }

    public void setPayees(Collection<Payee> payees) {
        this.payees = payees;
    }



    /*public Boolean getIs_category_active() {
        return is_category_active;
    }

    public void setIs_category_active(Boolean is_category_active) {
        this.is_category_active = is_category_active;
    }*/

    /*public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }*/

    public Category(String category_name/*, Boolean is_category_active*//*, Payee payee*/) {
        this.category_name = category_name;
        /*this.is_category_active = is_category_active;*/
       /* this.payee = payee;*/
    }

    public Category(){}
}
