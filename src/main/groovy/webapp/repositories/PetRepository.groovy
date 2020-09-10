package webapp.repositories

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import webapp.domain.NameDTO
import webapp.domain.Pet

@JdbcRepository(dialect = Dialect.MYSQL)
interface PetRepository extends PageableRepository<Pet, UUID> {

    List<NameDTO> list(Pageable pageable)

    @Join("owner")
    Optional<Pet> findByName(String name)
}