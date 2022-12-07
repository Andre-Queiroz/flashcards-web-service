package com.queiroz.flashcards.model.exception;

import jakarta.persistence.EntityExistsException;

public class UserAlreadyExistsException extends EntityExistsException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
