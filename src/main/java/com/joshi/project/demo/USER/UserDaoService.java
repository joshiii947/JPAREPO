package com.joshi.project.demo.USER;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<>();

    private static int usersCount=1;

    static {
        users.add(new User(1,"Adam",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        System.out.println("Hello world");
        if(user.getId()==null) {
            user.setId(++usersCount);
        }
        System.out.println(user);

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user:users){
            if(user.getId()!=null){
                return user;
            }
        }
        return null;
    }

}
