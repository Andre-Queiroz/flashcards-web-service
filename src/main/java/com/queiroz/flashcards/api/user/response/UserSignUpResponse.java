package com.queiroz.flashcards.api.user.response;

import com.queiroz.flashcards.model.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserSignUpResponse {

    private UUID id;
    private String name;

    public static UserSignUpResponse toUserSignUpResponse(AppUser appUser) {
        return UserSignUpResponse.builder()
                .id(appUser.getId())
                .name(appUser.getName())
                .build();
    }

}
