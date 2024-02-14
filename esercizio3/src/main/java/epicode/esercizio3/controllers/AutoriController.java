package epicode.esercizio3.controllers;

import epicode.esercizio3.entities.Author;
import epicode.esercizio3.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AutoriController {
    @Autowired
AuthorsService authorsService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Author saveAuthor(@RequestBody Author body) throws Exception {
        System.out.println(body);
        return authorsService.save(body);
    }

    @GetMapping
    public Page<Author> getAuthors(@RequestParam int page,@RequestParam int size) {
        return authorsService.getAuthors(page,size);
    }

    @GetMapping("/{authorId}")
    public Author findById(@PathVariable int authorId) throws Exception {
        return authorsService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author findAndUpdate(@PathVariable int authorId, @RequestBody Author body) throws Exception {
        return authorsService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int authorId) {
        authorsService.findByIdAndDelete(authorId);
    }

}
