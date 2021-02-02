package com.registe.brick.userbrick.dao;

import com.registe.brick.userbrick.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface UserDaoJpa extends JpaRepository<User,Integer> {

    @Query(value="select * from user where id = ?1",nativeQuery = true)
    User findById(int id);

    @Query(value="select * from user where name = ?1",nativeQuery = true)
    User findByName(String name);

}
