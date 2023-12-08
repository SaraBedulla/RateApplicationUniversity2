package com.example.rateuniversity.service;

import com.example.rateuniversity.entity.User;
import com.example.rateuniversity.repository.UserRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private Environment env;

    public List<User> getAllUsers() {
        List<User> result = repository.findAll();
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setPassword("");

        }

        return result;
    }
    public String createUser(String data){
        JSONObject obj=new JSONObject(data);
        String username=(String) obj.get("username");
        String email=(String) obj.get("email");
        String adminCode=(String) obj.get("adminCode");

        if(!repository.findByEmail(email).isEmpty()){
            return"Email is registered";
        }else if(!repository.findByUsername(username).isEmpty()){
            return "Username is already registered";
        }
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setDateCreated((String) obj.getString("dateCreated"));
        newUser.setPassword(passwordEncoder.encode((String)obj.get("password")));

    if(passwordEncoder.matches(adminCode, env.getProperty("ADMIN_CODE"))){
        newUser.setAdmin(true);
    }else if(!adminCode.isEmpty()){
        return "Invalid admin code";
    }
    return repository.save(newUser).getId();

    }
    public String loginUser(User user){
        List<User> searchResult=repository.findByUsername(user.getUsername());
        if(searchResult.isEmpty()){
            return "Username not registered";
        }
        if(!passwordEncoder.matches(user.getPassword(),searchResult.get(0).getPassword())){
            return "Password is incorrect";
        }
        if(searchResult.get(0).isBanned()){
            return "Account is banned";
        }
        return searchResult.get(0).getId();
    }
    public User handleBan(String id,String action){
        User user=repository.findById(id).orElse(null);
        if(action.equals("Ban")){
            user.setBanned(true);
        }else{
            user.setBanned(false);
        }
        repository.save(user);
        return user;
    }

}

