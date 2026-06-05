//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Security.demo.Controller;

import com.Security.demo.Dto.LoginRequest;
import com.Security.demo.Utility.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping({"/login"})
    public String login(@RequestBody LoginRequest request) {
        return "ranjith".equals(request.getUsername()) && "1234".equals(request.getPassword()) ? JwtUtil.generateToken(request.getUsername()) : "invalid credentials";
    }

    @GetMapping({"/hello"})
    public String hello(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.validateToken(token.replace("Bearer", ""));
        return "hello" + username;
    }
}
