package epicode.esercizio3.services;

import epicode.esercizio3.entities.Author;
import epicode.esercizio3.exceptions.BadRequest;
import epicode.esercizio3.exceptions.NotFoundException;
import epicode.esercizio3.repositories.AuthorsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsService {

    @Autowired
    AuthorsDAO authorsDAO;
    private final List<Author> authors = new ArrayList<>();

    public Author save(Author author) {
    authorsDAO.findByEmail(author.getEmail()).ifPresent(authoR -> {throw new BadRequest("L'email" + author.getEmail() +" è già in uso");
    });
    author.setAvatar("https://ui-avatars.com/api/?name"+ author.getName()+"+"+ author.getSurname());
    return authorsDAO.save(author);
    }

    public Page<Author> getAuthors(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber,size);
        return  authorsDAO.findAll(pageable);
    }

    public Author findById(int id) {
       return authorsDAO.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        Author found = this.findById(id);
     authorsDAO.delete(found);
    }

    public Author findByIdAndUpdate(int id, Author author) {
        Author found = this.findById(id);
        found.setSurname(author.getSurname());
        found.setName(author.getName());
        found.setEmail(author.getEmail());
        found.setDateOfBirth(author.getDateOfBirth());
        return authorsDAO.save(found);
    }
}

