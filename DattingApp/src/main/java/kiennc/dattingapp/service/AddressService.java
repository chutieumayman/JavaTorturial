package kiennc.dattingapp.service;
import kiennc.dattingapp.entity.AddressEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    public List<AddressEntity> findAll();

    public AddressEntity getById(Integer integer);

    public <S extends AddressEntity> S save(S entity);

    public Optional<AddressEntity> findById(Integer integer) ;

    public boolean existsById(Integer integer);

    public void deleteById(Integer integer);

    public void updateProduct(AddressEntity addressEntity);
    public List<AddressEntity> findByAddress(String address);

}
