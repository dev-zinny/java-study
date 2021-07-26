package com.liz.javastudy.exam;

import java.util.List;

/* 과제 1번 EricUserDao를 사용해서 구현체를 만드시요 */
public interface UserService {

    User add(UserDTO userDTO);

    boolean deleteById(int id);

    User update(UserDTO userDTO);

    User getOneById(int id);

    List<User> getAll();

    List<User> getAllByLikeName(String name);

    List<User> getAll(int page, int pageSize);

}
