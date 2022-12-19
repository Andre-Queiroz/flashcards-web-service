package com.queiroz.flashcards.service.flashcard;

import com.queiroz.flashcards.model.flashcard.Flashcard;
import com.queiroz.flashcards.repository.flashcard.FlashcardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FlashcardServiceImpl implements FlashcardService {

    private final FlashcardRepository flashcardRepository;

    @Override
    public Optional<Flashcard> create(final Flashcard flashcard) {
        return Optional.of(flashcardRepository.save(flashcard));
    }

    @Override
    public Optional<Flashcard> find(final String id) {
        return flashcardRepository.findById(id);
    }
}
