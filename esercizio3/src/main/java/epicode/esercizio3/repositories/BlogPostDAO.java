package epicode.esercizio3.repositories;

import epicode.esercizio3.entities.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostDAO  extends JpaRepository<Blogpost,Integer> {
}
