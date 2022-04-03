package kiennc.dattingapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kiennc.dattingapp.entity.AddressEntity;

public interface  AddressRepository  extends JpaRepository<AddressEntity,Integer> {
    List<AddressEntity> findByAddress(String address);
}
