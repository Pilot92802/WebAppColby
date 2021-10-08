package spring5guru.webappcolby.Repositories;

import spring5guru.webappcolby.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
