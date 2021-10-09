package spring5guru.webappcolby.Repositories;

import org.springframework.data.repository.CrudRepository;
import spring5guru.webappcolby.Domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
