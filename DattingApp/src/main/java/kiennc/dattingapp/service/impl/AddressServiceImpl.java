package kiennc.dattingapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import kiennc.dattingapp.repository.AddressRepository;
import kiennc.dattingapp.entity.AddressEntity;
import kiennc.dattingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }
    @Override
    public AddressEntity getById(Integer integer) {
        return addressRepository.getById(integer);
    }
    @Override
    public <S extends AddressEntity> S save(S entity) {
        return addressRepository.save(entity);
    }
    @Override
    public Optional<AddressEntity> findById(Integer integer) {
        return addressRepository.findById(integer);
    }
    @Override
    public boolean existsById(Integer integer) {
        return addressRepository.existsById(integer);
    }
    @Override
    public void deleteById(Integer integer) {
        addressRepository.deleteById(integer);
    }
    @Override
    public void updateProduct(AddressEntity addressEntity) {
        addressRepository.save(addressEntity);
    }
    @Override
    public List<AddressEntity> findByAddress(String address) {
        return addressRepository.findByAddress(address);
    }
}
