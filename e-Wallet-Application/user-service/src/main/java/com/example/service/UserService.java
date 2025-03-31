package com.example.service;


import com.example.models.User;
import com.example.repo.UserCacheRepo;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserCacheRepo userCacheRepo;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String USER_CREATE_TOPIC = "user_created";

    public void create(User user) throws JsonProcessingException {
        userRepo.save(user);

        //producing an event in kafka as soon as user is created.
        //json object is used to convert object to string so that kafka can read it..
        JSONObject userObject = new JSONObject();
        userObject.put("phone", user.getPhone());
        userObject.put("userId", user.getId());
        userObject.put("email", user.getEmail());

        //converting json object to string using object mapper and sending to topic USER_CREATE_TOPIC in kafka
        kafkaTemplate.send(USER_CREATE_TOPIC, this.objectMapper.writeValueAsString(userObject));
    }

    public User getUser(Integer userId) throws Exception {

       User user = userCacheRepo.get(userId);
        if(user!=null){
            return user;
        }

        user = userRepo.findById(userId).orElseThrow(() -> new Exception());
        userCacheRepo.set(user);
        return user;

    }

    public User getByPhone(String phone) {

        return userRepo.findByPhone(phone);
    }
}
