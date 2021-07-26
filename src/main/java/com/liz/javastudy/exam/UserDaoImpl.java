package com.liz.javastudy.exam;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

/* override 된 각각 메소드를 구현 해보기 */
@Repository
public class UserDaoImpl implements UserDao {

    private static List<User> users = new ArrayList<>();
    public static final int MAX_USER = 93;

    // init user list
    static {
        initUserList();
    }

    private static void initUserList() {

        for (int i = 0; i < MAX_USER; i++) {
            User user = new User();
            user.setId(i);
            user.setName(i + "name");
            user.setPassword(i + "password");
            user.setEmail(i + "@email.com");
            user.setJoinDate(LocalDateTime.now());
            users.add(user);
        }

    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                user = users.get(i);
            }
        }
        return Optional.ofNullable(user);

    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public boolean deleteById(int id) {
        User user = users.get(id);
        if (user.getId() == id) {
            users.remove(user.getId());
            return true;
        }
        return false;

    }

    @Override
    public List<User> findLikeName(String name) {
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(name)) {
                results.add(user);
            }
        }
        return results;
    }

    @Override
    public List<User> findUsers(int page, int pageSize) {
        // page : 현재 페이지 :: 2
        // pageSize : 페이지 당 갯수 :: 6 0~5 6~11
        List<User> results = new ArrayList<>();

        int startIndex = pageSize * (page - 1);
        int endIndex = page * pageSize;

        if (endIndex > MAX_USER) endIndex = MAX_USER;

        for (int i = startIndex; i < endIndex; i++) {
            results.add(users.get(i));
        }

        return results;
    }

}
