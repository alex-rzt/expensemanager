package Model.Payee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Payee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payee_id;

    @NotNull
    private String payee_name;

    @NotNull
    private boolean is_payee_active;

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

    public boolean isIs_payee_active() {
        return is_payee_active;
    }

    public void setIs_payee_active(boolean is_payee_active) {
        this.is_payee_active = is_payee_active;
    }

    public Payee(String payee_name, boolean is_payee_active) {
        this.payee_name = payee_name;
        this.is_payee_active = is_payee_active;
    }

    public Payee(){}
}
