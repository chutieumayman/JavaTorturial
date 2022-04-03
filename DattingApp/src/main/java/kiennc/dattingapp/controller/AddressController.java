package kiennc.dattingapp.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import kiennc.dattingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kiennc.dattingapp.entity.AddressEntity;
import kiennc.dattingapp.model.ResponseObject;
import kiennc.dattingapp.repository.AddressRepository;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;
    private AddressEntity newaddress;
    private Integer id;

    @GetMapping("list")
    public ResponseEntity<ResponseObject> getCustomers(){
        return  ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("Ok","Success",addressService.findAll()));
    }
    //Get id with Get
    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> findByAddressId(@PathVariable Integer id)
    {
       Optional<AddressEntity> foundAddress= addressService.findById(id);
       return foundAddress.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Success",foundAddress)):
             ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false","Không tồn tại id"+id,"")
            );
        
    }

    //insert with post
   @PostMapping("insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody AddressEntity newaddress)
    {
        try {
            Date date = new Date();
            newaddress.setLastUpdate(date);
            List<AddressEntity> foundAddress = addressService.findByAddress(newaddress.getAddress().trim());
            if (foundAddress.size() > 0) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("false", "Đã tồn tại adđres", ""));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Insert thành công", addressService.save(newaddress))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Error", e.getMessage(), newaddress)
            );
        }
    }

    // update with put
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> update(@RequestBody AddressEntity newaddress, @PathVariable Integer id)
    {        try {
        Date date= new Date();
       AddressEntity foundAddress= addressService.findById(id)
                .map(add-> {
                    add.setAddress(newaddress.getAddress());
                    add.setAddress2(newaddress.getAddress2());
                    add.setDistrict(newaddress.getDistrict());
                    add.setCityId(newaddress.getCityId());
                    add.setPostalCode(newaddress.getPostalCode());
                    add.setPhone(newaddress.getPhone());
                    add.setLastUpdate(date);
                    return addressService.save(add);
                }).orElseGet(()->{
                    return addressService.save(newaddress);
                });

        return  ResponseEntity.status(HttpStatus.OK).body(
                 new ResponseObject("Ok","Update thành công",foundAddress));
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Error", e.getMessage(), newaddress)
        );
    }
    }

     // delete with id
     @DeleteMapping("delete/{id}")
     public ResponseEntity<ResponseObject> delete(@PathVariable Integer id)
     {
         try {
             boolean ckFoundAddress = addressService.existsById(id);
             if (ckFoundAddress) {
                 addressService.deleteById(id);
                 return ResponseEntity.status(HttpStatus.OK).body(
                         new ResponseObject("Ok", "Delete thành công", ""));
             }
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                     new ResponseObject("false", "Không tồn tại id" + id, "")
             );
         }
           catch (Exception e){
         return ResponseEntity.status(HttpStatus.OK).body(
                 new ResponseObject("Error", e.getMessage(), newaddress)
         );
     }
    }
}
    


