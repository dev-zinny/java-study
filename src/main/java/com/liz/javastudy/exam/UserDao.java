package com.liz.javastudy.exam;


import java.util.List;
import java.util.Optional;

/**
 * 과제 01
 * interface 구현체를 만드시요.
 * User 인원 : 95명
 */
public interface UserDao {

    List<User> findAll();

    Optional<User> findById(int id);

    User save(User user);

    boolean deleteById(int id);

    List<User> findLikeName(String name);

    List<User> findUsers(int page, int pageSize);

    //User findByPredicate(Predicate predicate);

}
