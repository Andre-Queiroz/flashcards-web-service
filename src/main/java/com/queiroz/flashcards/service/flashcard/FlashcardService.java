package com.queiroz.flashcards.service.flashcard;

import com.queiroz.flashcards.model.flashcard.Flashcard;

import java.util.Optional;

public interface FlashcardService {

    Optional<Flashcard> create(final Flashcard flashcard);

    Optional<Flashcard> find(final String id);
}
