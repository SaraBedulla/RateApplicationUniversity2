package com.example.rateuniversity.repository;
import java.util.List;
import com.example.rateuniversity.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    List<User> findByEmail(String Email);
    List<User>findByUsername(String username);
}
