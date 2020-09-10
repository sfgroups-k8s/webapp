package webapp.repositories

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import webapp.domain.Owner

@JdbcRepository(dialect = Dialect.MYSQL)
interface OwnerRepository extends CrudRepository<Owner, Long> {
/*
    @Override
    List<Owner> findAll()*/

    Optional<Owner> findByName(String name)
}