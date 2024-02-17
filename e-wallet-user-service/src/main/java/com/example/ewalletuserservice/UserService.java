package com.example.ewalletuserservice;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String USER_CREATE = "user_create";//topic name in kafka

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper mapper;

    @Transactional
    public User create(User user) throws JsonProcessingException {
    	 System.out.println(user.getName());
    	user = userRepository.save(user);//save the user in the database of user repository
        System.out.println(user.getId()+" "+user.getName());
        //TODO: Add code for wallet addition
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", user.getId());
        jsonObject.put("userEmail", user.getEmail());
        jsonObject.put("userContact", user.getContact());
        System.out.println("after json obj creation");
        kafkaTemplate.send(USER_CREATE, jsonObject.toJSONString());//tojsonstring to convert from json object to json string representation

        return user;
    }

    public User get(int id){

        /*
            If id is present in redis, then fetch from there, else get from db and insert in redis
         */

        return userRepository.findById(id).orElse(null);
    }
}