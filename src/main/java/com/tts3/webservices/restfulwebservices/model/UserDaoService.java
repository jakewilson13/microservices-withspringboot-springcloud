package com.tts3.webservices.restfulwebservices.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 4;

    //static block is used for initializing static variables.
    //used for pre-defined values for a List of some sort.
    //wouldn't be possible to initialize List object with all the initial values along with declaration;
    // that's why we have utilized a static block
    static {
        users.add(new User(1, "Jake", new Date(), "Hello"));
        users.add(new User(2, "Jeff", new Date(), "Whats Up"));
        users.add(new User(3, "Will", new Date(), "How are you"));
        users.add(new User(4, "Keefe", new Date(), "When are we going"));
    }

    public List<User> findAll() {
        return users;
    }

    //if the user ID is null
    //it increments the user ID by one upon creation
    public User save(User user) {
        if(user.getId()==null) {
            user.setId(++usersCount);
        }
        //adding the new created user to the list
        //passing in the (user) is the input
        users.add(user);
        return user;
    }

    //allowing us to access one user at time
    //looping through our users list, if a user ID matches
    //one from the list it returns that given user
    public User findOne(int id) {
        for(User user : users) {
            if(user.getId()==id) {
                return user;
            }
        }
        //if the ID doesn't match it returns a null value for it
        return null;
    }


    public String findPosts(String post) {
        for(User user:users) {
            post = user.getPost();
            if(post==null) {
                return null;
            }
        }
        return post;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}

