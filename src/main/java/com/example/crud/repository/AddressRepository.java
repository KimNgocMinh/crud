package com.example.crud.repository;

import com.example.crud.model.Address;
import com.example.crud.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCityAndBuildingNumberOrderByStreet(String city, int buildingNumber);

    List<Address> findByCityContaining(String keyword);

    List<Projection.AddressSumary> getByBuildingNumber(int number);


    List<Projection.AddressDTO> getAddressByBuildingNumber(int number);

}
