package com.queiroz.flashcards.api.user.response;

import com.queiroz.flashcards.model.user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserSignUpResponse {

    private String id;
    private String name;

    public static UserSignUpResponse toUserSignUpResponse(AppUser appUser) {
        return UserSignUpResponse.builder()
                .id(appUser.getId())
                .name(appUser.getName())
                .build();
    }

}
