package webapp.domain

import io.micronaut.core.annotation.Creator

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book {
    @Id
    @GeneratedValue
    Long id
    private String title
    private int pages

    @Creator
    Book(String title, int pages) {
        this.title = title
        this.pages = pages
    }

    String getTitle() {
        return title
    }

    int getPages() {
        return pages
    }
}