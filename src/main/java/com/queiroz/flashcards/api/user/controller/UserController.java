package com.queiroz.flashcards.api.user.controller;

import com.queiroz.flashcards.api.user.request.UserSignUpRequest;
import com.queiroz.flashcards.api.user.response.UserSignUpResponse;
import com.queiroz.flashcards.model.exception.UserAlreadyExistsException;
import com.queiroz.flashcards.service.user.UserSignUpService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

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

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleUserAlreadyExistsException(final UserAlreadyExistsException e) {
        return Collections.singletonMap("error", e.getMessage());
    }
}
