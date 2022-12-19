package com.queiroz.flashcards.api.flashcard;

import com.queiroz.flashcards.api.flashcard.json.FlashcardRequest;
import com.queiroz.flashcards.model.flashcard.Flashcard;
import com.queiroz.flashcards.service.flashcard.FlashcardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flashcard")
@CrossOrigin
@AllArgsConstructor
public class FlashcardController {

    private final FlashcardService flashcardService;

    @PostMapping
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody @Valid final FlashcardRequest flashcardRequest) {
        var response = flashcardService.create(FlashcardRequest.toFlashcard(flashcardRequest));
        return response.map(flashcard -> new ResponseEntity<>(flashcard, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> findFlashcard(@PathVariable("id") final String id) {
        var response = flashcardService.find(id);
        return response.map(flashcard -> new ResponseEntity<>(flashcard, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
