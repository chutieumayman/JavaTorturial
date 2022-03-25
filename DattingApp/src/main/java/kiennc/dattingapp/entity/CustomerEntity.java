package kiennc.dattingapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer store_id;
    private Integer address_id;
    private Boolean activebool;
    private Date create_date;
    private Date last_update;
    private Integer active;
    public Integer getId() {
        return customer_id;
    }

    public void setId(Integer id) {
        this.customer_id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddressId(Integer addressId) {
        this.address_id = addressId;
    }
    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
}
