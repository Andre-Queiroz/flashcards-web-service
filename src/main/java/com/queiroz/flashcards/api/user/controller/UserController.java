package com.queiroz.flashcards.api.user.controller;

import com.queiroz.flashcards.api.user.request.UserSignUpRequest;
import com.queiroz.flashcards.api.user.response.UserSignUpResponse;
import com.queiroz.flashcards.service.user.UserSignUpService;
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

    private final UserSignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponse> signUp(@RequestBody @Valid final UserSignUpRequest signUpRequest) {
        return ResponseEntity.ok(
                UserSignUpResponse.toUserSignUpResponse(
                        signUpService.signUpUser(signUpRequest)));
    }
}
