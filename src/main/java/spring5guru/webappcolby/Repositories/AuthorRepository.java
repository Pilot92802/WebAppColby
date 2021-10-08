package spring5guru.webappcolby.Repositories;

import spring5guru.webappcolby.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
