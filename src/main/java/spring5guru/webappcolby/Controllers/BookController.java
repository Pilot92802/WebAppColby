package spring5guru.webappcolby.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring5guru.webappcolby.Repositories.BookRepository;

/** *************************************************************************************
 *   The @Controller annotation indicates to Spring that this class will be used as
 *   a controller in the Spring MVC framework.
 * *************************************************************************************
 */
@Controller
public class BookController {

    /**********************************************************************************
     * Spring will use dependency injection???? to include elements for the book repository
     * ********************************************************************************
     */
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * This annotation identifies the path in our application for which we want to access this controller
     * and when we do... access this controller we should execute getBooks.  getBooks should then access
     * the model and provide a string return "books" that should then identify the view... which developing
     * that view is the next step in the development.
     * @param model
     * @return
     */
    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books",bookRepository.findAll());

        return "books/list";
    }
}
