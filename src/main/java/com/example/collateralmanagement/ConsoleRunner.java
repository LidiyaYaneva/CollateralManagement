package com.example.collateralmanagement;

import com.example.collateralmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

//    private final UserService userService;
//
//    private  final PasswordEncoder encoder;

    public ConsoleRunner( SeedService seedService) {
        this.seedService = seedService;
//        this.userService = userService;
//        this.encoder = encoder;
    }

    @Override
    public void run(String... args)  {

        this.seedService.seedAllExamples();


//
//        RegisterUserDTO registerUserDTO = new RegisterUserDTO("Ivan", "Dimitrov",
//                "ivan.dimitrov@bank.com","IvanDimitrov", "encodertest", "MANAGEMENT");
//        this.userService.registerUser(registerUserDTO);

    }
}
