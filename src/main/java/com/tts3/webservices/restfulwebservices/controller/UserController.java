package com.tts3.webservices.restfulwebservices.controller;


import com.tts3.webservices.restfulwebservices.model.User;
import com.tts3.webservices.restfulwebservices.model.UserDaoService;
import com.tts3.webservices.restfulwebservices.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    //dependency injection
    @Autowired
    private UserDaoService service;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(User user) {
        if(user ==null) {
            throw new UserNotFoundException("user-" + user);
        }
        return service.findAll();
    }

    //taking in the id as a path variable
    //passing the id as the input into the argument for findOne
    @GetMapping(value = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }


    //the input will be a User object
    //Request body will be mapped to the user parameter
    //creating the new user and passing the info to the request body
    @PostMapping(value = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        //CREATED
        // /user/5
        URI location = ServletUriComponentsBuilder
                //getting the info from the current request /users
                .fromCurrentRequest()
                //mapping it to the path /{id}
                .path("/{id}")
                //saving the user and getting the ID from our service
                .buildAndExpand(savedUser.getId())
                //then putting it into the URI
                .toUri();

        //ResponseEntity allows you to return a http status code
        //returning the created status code from the location variable
        //then building it
       return ResponseEntity.created(location).build();
    }

   @DeleteMapping(value = "/users/{id}")
   public void deleteUser(@PathVariable int id) {
       User user = service.deleteById(id);
       if(user == null) {
           throw new UserNotFoundException("id-" + id);
       }
   }
}
