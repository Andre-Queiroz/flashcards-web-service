package com.queiroz.flashcards.api.user.json;

import com.queiroz.flashcards.model.user.User;
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

    public static UserSignUpResponse toUserSignUpResponse(User user) {
        return UserSignUpResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

}
