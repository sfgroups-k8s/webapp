package webapp.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import webapp.domain.Book
import webapp.repositories.BookRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Slf4j
@Controller("/books")
class BookController {
    @Inject BookRepository bookRepository

    @Get("/")
    List<Book> all() {
        return bookRepository.findAll()
    }

    @Get("/{title}")
    Optional<Book> byTitle(@NotBlank String title) {
        return bookRepository.findByTitle(title)
    }

    @Delete("/{id}")
    Book delete(Long id) {
        return bookRepository.deleteById(id)
    }

    @Post("/")
    def save(@Body Object JSON) {
        ObjectMapper objectMapper = new ObjectMapper();
        //convert json string to object
 /*       def obj = objectMapper.readValue(JSON, Book.class);
        println(obj)*/

        String title = JSON?.title
        String p =JSON?.pages
        log.info(" tilte: $title, pages ; $p , ${p.class}")
        int pages = p as Integer
        log.info(" tilte: $title, pages ; $pages")
        Book b = new Book(title,pages)
        bookRepository.saveAll(Arrays.asList(b))
        return HttpResponse.created(b)
    }

    @Put("/")
    def update(@Body Book b) {
        int num =bookRepository.update(b)
    }
}