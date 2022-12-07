package com.queiroz.flashcards.service.user;

import com.queiroz.flashcards.api.user.request.UserSignUpRequest;
import com.queiroz.flashcards.model.user.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSignUpService {

    private final AppUserService appUserService;

    public AppUser signUpUser(UserSignUpRequest request) {
        return appUserService.signUpUser(UserSignUpRequest.createAppUser(request));
    }

}
