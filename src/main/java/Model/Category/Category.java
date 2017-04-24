package Model.Category;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;

    @NotNull
    private String category_name;

    @NotNull
    private Boolean is_category_active;

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

    public Boolean getIs_category_active() {
        return is_category_active;
    }

    public void setIs_category_active(Boolean is_category_active) {
        this.is_category_active = is_category_active;
    }

    public Category(String category_name, Boolean is_category_active) {
        this.category_name = category_name;
        this.is_category_active = is_category_active;
    }
    public Category(){}
}
