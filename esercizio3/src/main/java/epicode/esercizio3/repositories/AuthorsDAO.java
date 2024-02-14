package epicode.esercizio3.repositories;

import epicode.esercizio3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsDAO extends JpaRepository<Author,Integer> {


    Optional<Author> findByEmail(String email);
}
