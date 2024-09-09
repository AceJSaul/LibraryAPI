package com.acejsaul.ApiLibrary.controllers;

import com.acejsaul.ApiLibrary.entities.User;
import com.acejsaul.ApiLibrary.entities.records.AuthenticationDTO;
import com.acejsaul.ApiLibrary.entities.records.LoginResponseDTO;
import com.acejsaul.ApiLibrary.entities.records.RegisteredDTO;
import com.acejsaul.ApiLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acejsaul.ApiLibrary.infra.security.TokenService;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO userData){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userData.login(), userData.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Validated RegisteredDTO registeredDTO){
        if(this.userRepository.findByLogin(registeredDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        else{
            String encryptedPassword = new BCryptPasswordEncoder().encode(registeredDTO.password());
            User user = new User(registeredDTO.first_name(), registeredDTO.last_name(), registeredDTO.login(), encryptedPassword, registeredDTO.role());

            this.userRepository.save(user);

            return ResponseEntity.ok().build();
        }
    }
}
