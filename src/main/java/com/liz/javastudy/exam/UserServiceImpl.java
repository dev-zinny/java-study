package com.liz.javastudy.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User add(UserDTO userDTO) {
        User user = new User();
        translate(userDTO, user);
        return dao.save(user);
    }

    @Override
    public boolean deleteById(int id) {
        //1.요청한 ID가 있는지 확인
        // -> 삭제 처리
        //2.요청한 ID가 없는 경우
        return dao.deleteById(id);
    }

    @Override
    public User update(UserDTO userDTO) {
//        translate();
        return null;
    }

    @Override
    public User getOneById(int id) {
        Optional<User> userOptional = dao.findById(id);
        return userOptional.get();
    }

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public List<User> getAllByLikeName(String name) {
        return dao.findLikeName(name);
    }

    @Override
    public List<User> getAll(int page, int pageSize) {
        return dao.findUsers(page, pageSize);
    }


    /* 2번째 과제 리플렉션을 이용해서 구현하시요. */
    public static <T,R> void translate(T userDTO, R user) {

        Class<?> clazz = userDTO.getClass();  // Article의 Class를 가져온다.
        Field[] fields = clazz.getDeclaredFields(); // Article의 모든 필드를 가져온다.


        Class<?> clazz2 = user.getClass();  // Article의 Class를 가져온다.
        Field[] fields2 = clazz2.getDeclaredFields(); // Article의 모든 필드를 가져온다.

        List<Object> aaa = new ArrayList<>();

        PropertyDescriptor pd;
        try {
            for (Field field : fields) { // field의 type, name 출력
                pd = new PropertyDescriptor(field.getName(), clazz);
                Method getter = pd.getReadMethod();
                getter.invoke(userDTO);
                aaa.add(getter.invoke(userDTO));
            }

            int i = 0;
            for (Field field2 : fields) { // field의 type, name 출력
                pd = new PropertyDescriptor(field2.getName(), clazz2);
                Method setter = pd.getWriteMethod();
                setter.invoke(user, aaa.get(i));
                i++;
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        UserDTO dto = new UserDTO();
        User user = new User();
        dto.setId(66);
        dto.setName("hc");
        dto.setEmail("email");
        dto.setPassword("123455");
        dto.setJoinDate(LocalDateTime.now());

        translate(dto, user);

        System.out.println(user);
    }


}
