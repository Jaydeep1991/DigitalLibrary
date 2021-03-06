package com.libraryManagement.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.libraryManagement.model.Role;
import com.libraryManagement.model.Users;
import com.libraryManagement.payload.SignInResponse;
import com.libraryManagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public SignInResponse signIn(String email, String password) {

        Optional<Users> user = userRepo.findByemail(email);
        if (!user.isPresent()) {
            SignInResponse response = new SignInResponse(HttpStatus.BAD_REQUEST.value(),
                    "No Such User Exists");
            return response;
        }
        Users userObj = user.get();
        if (email.equals(userObj.getEmail()) && passwordEncoder.matches(password, userObj.getPassword())) {
            Role role = roleService.getRole(userObj.getUserId());
            SignInResponse signResponse = new SignInResponse(HttpStatus.OK.value(), userObj.getName(), role.getRoleName(), "SUCCESS");
            return signResponse;
        }
        if (email.equals(userObj.getEmail()) && !passwordEncoder.matches(password, userObj.getPassword())) {
            Role role = roleService.getRole(userObj.getUserId());
            SignInResponse signResponse = new SignInResponse(HttpStatus.NOT_FOUND.value(), "Wrong Password");
            return signResponse;
        } else {
            SignInResponse signResponse1 = new SignInResponse(HttpStatus.BAD_REQUEST.value(),
                    "Something went wrong");
            return signResponse1;
        }

    }

}
