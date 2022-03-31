package kiennc.dattingapp.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kiennc.dattingapp.entity.AddressEntity;
import kiennc.dattingapp.model.ResponseObject;
import kiennc.dattingapp.repository.AddressRepository;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address/list")
    public  Iterable<AddressEntity> getCustomers(){
        return addressRepository.findAll();
    }
    //Get id with Get
    @GetMapping("/address/id")
    public ResponseEntity<ResponseObject> findById(@PathVariable Integer id)
    {
       Optional<AddressEntity> foundAddress= addressRepository.findByAddress_id(id);
       return foundAddress.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Success",foundAddress)):
             ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false","Không tồn tại id"+id,"")
            );
        
    }

    //insert with Post
    @GetMapping("/address/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody AddressEntity newaddress)
    {
        List<AddressEntity> foundAddress= addressRepository.findByAddress(newaddress.getAddress().trim());
        if(foundAddress.size()>0){
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("false","Đã tồn tại adđres",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Insert thành công",addressRepository.save(newaddress))
            );
    }

    // update
    @PutMapping("/address/id")
    public ResponseEntity<ResponseObject> update(@RequestBody AddressEntity newaddress, @PathVariable Integer id)
    {
        Date date= new Date();
       AddressEntity foundAddress= addressRepository.findById(id)
                        .map(address->{
                            address.setAddress(newaddress.getAddress());
                            address.setAddress2(newaddress.getAddress2());
                            address.setDistrict(newaddress.getDistrict());
                            address.setCity_id(newaddress.getCity_id());
                            address.setPostal_code(newaddress.getPostal_code());
                            address.setPhone(newaddress.getPhone());
                            address.setLast_update(date);
                            return addressRepository.save(address);
                        }).orElseGet(()->{
                            return addressRepository.save(newaddress);
                        });

                        return  ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Update thành công",foundAddress)
                    );
    }

     // delete
     @DeleteMapping("/address/id")
     public ResponseEntity<ResponseObject> update(@PathVariable Integer id)
     {
        boolean exists = addressRepository.existsById(id);
        if(exists){
            addressRepository.deleteById(id);
            return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Delete thành công",""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("false","Không tồn tại id"+id,"")
        );
     }
    
}
    


