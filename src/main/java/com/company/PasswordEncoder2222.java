package com.company;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder2222 {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String rawPassword="1234567";
        String encodedPassword=encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }

}