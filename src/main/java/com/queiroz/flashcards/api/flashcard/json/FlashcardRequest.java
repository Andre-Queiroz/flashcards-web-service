package com.queiroz.flashcards.api.flashcard.json;

import com.queiroz.flashcards.model.flashcard.Flashcard;
import com.queiroz.flashcards.model.flashcard.Proficiency;
import com.queiroz.flashcards.model.user.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Getter
public class FlashcardRequest {
    @NotBlank
    private String front;
    @NotBlank
    private String back;

    public static Flashcard toFlashcard(final FlashcardRequest request) {
        return new Flashcard(getAuthenticatedUser(),
                request.getFront(),
                request.getBack(),
                LocalDateTime.parse("1970-01-01T01:00:00"),
                Proficiency.BEGINNER,
                0);
    }

    private static User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
