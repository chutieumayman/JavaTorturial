package kiennc.dattingapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address")

public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Integer id;
    private String address;
    private String address2;

    private String district;
    private Integer cityId;
    private String postalCode;
    private String phone;
    private Date lastUpdate;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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

    public void AddaddressEntity( String address, String address2, String district, Integer cityId,
            String postalCode, String phone, Date lastUpdate) {
        this.address = address;
        this.setAddress2(address2);
        this.setDistrict(district);
        this.setCityId(cityId);
        this.setPostalCode(postalCode);
        this.setPhone(phone);
        this.setLastUpdate(lastUpdate);
    }

}
