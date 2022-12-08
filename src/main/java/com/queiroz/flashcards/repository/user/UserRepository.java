package com.queiroz.flashcards.repository.user;

import com.queiroz.flashcards.model.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(final String email);

}
