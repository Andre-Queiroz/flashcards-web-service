package com.queiroz.flashcards.repository.flashcard;

import com.queiroz.flashcards.model.flashcard.Flashcard;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, String> {
}
