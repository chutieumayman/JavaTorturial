package kiennc.dattingapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    private String address;
    private String address2;

    private String district;
    private Integer city_id;
    private String postal_code;
    private String phone;
    private Date last_update;

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void AddaddressEntity( String address, String address2, String district, Integer city_id,
            String postal_code, String phone, Date last_update) {
        this.address = address;
        this.setAddress2(address2);
        this.setDistrict(district);
        this.setCity_id(city_id);
        this.setPostal_code(postal_code);
        this.setPhone(phone);
        this.setLast_update(last_update);
    }

}
