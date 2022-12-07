package com.queiroz.flashcards.api.user.request;

import com.queiroz.flashcards.model.user.AppUser;
import com.queiroz.flashcards.model.user.AppUserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserSignUpRequest {

    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public static AppUser createAppUser(UserSignUpRequest request) {
        return new AppUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER);
    }

}
