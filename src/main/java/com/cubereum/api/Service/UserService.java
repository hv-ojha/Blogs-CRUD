package com.cubereum.api.Service;

import com.cubereum.api.Entity.User;
import com.cubereum.api.Repository.UserRepository;
import com.cubereum.api.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User getUserFromRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtTokenUtil.getUsernameFromToken(token);
        return userRepository.findByEmail(email);
    }

    public User addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(User user) {
        User loggedInUser = getUserFromRequest();
        if(loggedInUser != user) {
            return loggedInUser;
        }
        else {
            User user1 = getUserByEmail(user.getEmail());
            if (!user1.getName().equals(user.getName()))
                user1.setName(user.getName());
            return userRepository.save(user1);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
