package com.queiroz.flashcards.api.user.json;

import com.queiroz.flashcards.model.user.User;
import com.queiroz.flashcards.model.user.UserRole;
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

    public static User toUser(UserSignUpRequest request) {
        return new User(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER);
    }

}
