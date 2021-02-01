package com.registe.brick.userbrick.dao;

import com.registe.brick.userbrick.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value="select * from user where id = ?1",nativeQuery = true)
    User findById(int id);

    @Query(value="select * from user where name = ?1",nativeQuery = true)
    User findByName(String name);

}
