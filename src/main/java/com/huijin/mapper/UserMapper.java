package com.huijin.mapper;

import com.huijin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getAllUser();

    User findUserById(@Param("id") String id);

    void save(@Param("user") User user);

    void edit(@Param("user") User user);

    void delete(@Param("id") String id);

    User findUserByNameAndPassword(@Param("user") User user);
}
