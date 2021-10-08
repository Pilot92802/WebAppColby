package spring5guru.webappcolby.BootStrap;

import spring5guru.webappcolby.Domain.Author;
import spring5guru.webappcolby.Domain.Book;
import spring5guru.webappcolby.Repositories.AuthorRepository;
import spring5guru.webappcolby.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

        private final AuthorRepository authorRepository;
        private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author doug = new Author("Douglas","Adams");
        Book hitchhiker = new Book("Hitchhiker's Guide to the Galaxy","121212");
        doug.getBooks().add(hitchhiker);
        hitchhiker.getAuthors().add(doug);

        authorRepository.save(doug);
        bookRepository.save(hitchhiker);

        Author ray = new Author("Ray","Bradbury");
        Book fahrenheit = new Book("Fahrenheit 451","2434343");
        ray.getBooks().add(fahrenheit);
        fahrenheit.getAuthors().add(ray);

        authorRepository.save(ray);
        bookRepository.save(fahrenheit);

        System.out.println("Started in spring5guru.webappcolby.BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}