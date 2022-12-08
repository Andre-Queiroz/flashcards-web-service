package com.queiroz.flashcards.service.user;

import com.queiroz.flashcards.model.exception.UserAlreadyExistsException;
import com.queiroz.flashcards.model.user.User;
import com.queiroz.flashcards.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with email %s not found.", email)));
    }

    public User signUpUser(User user) {
        appUserRepository.findByEmail(user.getEmail()).ifPresent(retrievedUser -> {
            throw new UserAlreadyExistsException("Email already taken.");
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

}
