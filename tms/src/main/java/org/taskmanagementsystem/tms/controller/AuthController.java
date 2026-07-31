package org.taskmanagementsystem.tms.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taskmanagementsystem.tms.dto.LoginRequestDTO;
import org.taskmanagementsystem.tms.dto.UserDTO;
import org.taskmanagementsystem.tms.service.AuthService;

import static org.taskmanagementsystem.tms.dto.UserDTO.userDTOMapper;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO ){
        UserDTO response= userDTOMapper(authService.CreatUser(UserDTO.userMapper(userDTO)));
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody @Valid LoginRequestDTO loginRequestDTO){

        String token = authService.logIn(loginRequestDTO);
        return ResponseEntity.ok(token);
    }

}

