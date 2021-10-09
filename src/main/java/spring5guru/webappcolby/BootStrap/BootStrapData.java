package spring5guru.webappcolby.BootStrap;

import spring5guru.webappcolby.Domain.Author;
import spring5guru.webappcolby.Domain.Book;
import spring5guru.webappcolby.Domain.Publisher;
import spring5guru.webappcolby.Repositories.AuthorRepository;
import spring5guru.webappcolby.Repositories.BookRepository;
import spring5guru.webappcolby.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

        private final AuthorRepository authorRepository;
        private final BookRepository bookRepository;
        private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher hill = new Publisher("Hill Publishing", "123 Main St", "Austin", "TX", "78759");
        publisherRepository.save(hill);
        Long pubID = hill.getId();

        fahrenheit.setPublisher(hill);
        hill.getBooks().add(fahrenheit);
        hitchhiker.setPublisher(hill);
        hill.getBooks().add(hitchhiker);

        publisherRepository.save(hill);

        System.out.println("Started in spring5guru.webappcolby.BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher data: " + publisherRepository.findById(pubID).toString());
        System.out.println("Number of Books from publisher: " + hill.getBooks().size());
    }
}