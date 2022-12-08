package com.queiroz.flashcards.api.user;

import com.queiroz.flashcards.api.user.json.UserSignUpRequest;
import com.queiroz.flashcards.api.user.json.UserSignUpResponse;
import com.queiroz.flashcards.service.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponse> signUp(@RequestBody @Valid final UserSignUpRequest signUpRequest) {
        return ResponseEntity.ok(
                UserSignUpResponse.toUserSignUpResponse(
                        userService.signUpUser(UserSignUpRequest.toUser(signUpRequest))));
    }
}
