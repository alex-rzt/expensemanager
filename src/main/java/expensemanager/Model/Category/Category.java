package expensemanager.Model.Category;

import expensemanager.Model.Payee.Payee;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int categoryId;

    @NotNull
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "is_category_active")
    private Boolean isCategoryActive;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Collection<Payee> payees=new ArrayList<Payee>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getCategoryActive() {
        return isCategoryActive;
    }

    public void setCategoryActive(Boolean categoryActive) {
        isCategoryActive = categoryActive;
    }

    public Collection<Payee> getPayees() {
        return payees;
    }

    public void setPayees(Collection<Payee> payees) {
        this.payees = payees;
    }

    public Category(String categoryName,Boolean isCategoryActive)
    {
        this.categoryName = categoryName;
        this.isCategoryActive=isCategoryActive;
    }

    public Category(){}
}
