package com.example.testsBack.services;

import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.RoleRepository;
import com.example.testsBack.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User addObject(User user) throws BadRequest {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequest("Object already exist");
        }
        user.setPasswordSalt(BCrypt.gensalt());
        return userRepository.save(user);
    }

    public User getObject(Long id) throws BadRequest {
        if (userRepository.findById(id).isEmpty()) {
            throw new BadRequest("Object not found");
        }
        return userRepository.findById(id).get();
    }

    public Iterable<User> getAllObjects() { return userRepository.findAll(); }

    public User editObject(User user, Long id) throws BadRequest {
        if (userRepository.findById(id).isEmpty()) {
            throw new BadRequest("Object not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (userRepository.findById(id).isEmpty()) {
            throw new BadRequest("Object not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user '%s' not found", email)));
        Set roleName = roleRepository.findByRoleName(user.getRoleID().getRoleName()).stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                roleName
        );
    }
}
