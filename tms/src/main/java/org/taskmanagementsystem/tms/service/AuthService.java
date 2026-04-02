package org.taskmanagementsystem.tms.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.taskmanagementsystem.tms.entities.User;
import org.taskmanagementsystem.tms.repository.imp.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;


    public User CreatUser(User user) {
        user.set_active(true);
        user.setRegisterDate(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deletUser(User user) {
        userRepository.delete(user);
    }

}
