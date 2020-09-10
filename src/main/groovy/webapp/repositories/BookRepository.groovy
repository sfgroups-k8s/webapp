package webapp.repositories

import webapp.domain.Book
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@JdbcRepository(dialect = Dialect.MYSQL)
interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll()

    Optional<Book> findByTitle(String title)

    void deleteById(@NotNull Long id);
}