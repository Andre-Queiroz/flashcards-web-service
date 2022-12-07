package com.queiroz.flashcards.service.user;

import com.queiroz.flashcards.model.exception.UserAlreadyExistsException;
import com.queiroz.flashcards.model.user.AppUser;
import com.queiroz.flashcards.repository.user.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with email %s not found.", email)));
    }

    public AppUser signUpUser(AppUser appUser) {
        appUserRepository.findByEmail(appUser.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistsException("Email already taken.");
        });

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        return appUserRepository.save(appUser);
    }
}
