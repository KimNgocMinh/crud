package com.example.crud.repository;

import com.example.crud.model.Projection;
import com.example.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<Projection.UserDTO> findUserById(Long id);
}
