package com.liz.javastudy.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    UserService userService;

    //전체 사용자 목록
    /*@GetMapping(path = "/users")
    public List<User> findAll(){
        return userService.getAll();
    }*/

    //사용자 페이징 목록
    @GetMapping(path = "/users")
    public List<User> findUsers(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "0") int pageSize){
        if(page == 0 || pageSize == 0){
            return userService.getAll();
        }
        return userService.getAll(page, pageSize);
    }

    //사용자 조회
    @GetMapping(path = "/users/{userId}")
    public User findUser(@PathVariable int userId){
        return userService.getOneById(userId);
    }

    //사용자 등록
    @PostMapping(path = "/users")
    public User addUser(UserDTO dto){
        return userService.add(dto);
    }

    //사용자 수정
    @PutMapping(path = "/users/{userId}")
    public String updateUser(@PathVariable int userId){
        return null;
    }

    //사용자 삭제
    @DeleteMapping(path = "/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        return null;
    }

    //사용자명으로 조회
    @GetMapping(path = "/users/search")
    public User findUserByName(@RequestParam String name){
        return null;
    }

}
