package webapp

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.event.annotation.EventListener
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import webapp.domain.Book

import webapp.domain.Owner
import webapp.domain.Pet
import webapp.domain.PetType
import webapp.repositories.BookRepository
import webapp.repositories.OwnerRepository
import webapp.repositories.PetRepository

import javax.inject.Inject
import javax.inject.Singleton
@OpenAPIDefinition(
        info = @Info(
                title = "WebApp",
                version = "0.0",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "http://sfgroups.com"),
                contact = @Contact(url = "http://sfgroups.com", name = "admin", email = "noreply@sfgroups.com")
        )
)
@CompileStatic
@Slf4j
@Singleton

class Application {
    @Inject BookRepository bookRepository  
    @Inject OwnerRepository ownerRepository
    @Inject PetRepository petRepository

    @EventListener
    void init(StartupEvent event) {
        log.info("Starting the application")

        log.info("Populating data")


        Book b = new Book("Docker",100)
        Book b1 = new Book("Java",100)
        bookRepository.saveAll(Arrays.asList(b,b1))
        bookRepository.saveAll(Arrays.asList(
                new Book("The Stand", 1000),
                new Book("The Shining", 600),
                new Book("The Power of the Dog", 500),
                new Book("The Border", 700),
                new Book("Along Came a Spider", 300),
                new Book("Pet Cemetery", 400),
                new Book("A Game of Thrones", 900),
                new Book("A Clash of Kings", 1100)
        ))

        Owner fred = new Owner("Fred")
        fred.setAge(45)
        Owner barney = new Owner("Barney")
        barney.setAge(40)
        ownerRepository.saveAll(Arrays.asList(fred, barney))

        Pet dino = new Pet("Dino", fred)
        Pet bp = new Pet("Baby Puss", fred)
        bp.setType(PetType.CAT)
        Pet hoppy = new Pet("Hoppy", barney)

        petRepository.saveAll(Arrays.asList(dino, bp, hoppy))

    }

    static void main( args) {
        Micronaut.run(Application)
    }
}