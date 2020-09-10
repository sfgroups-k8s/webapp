package webapp.domain

import io.micronaut.core.annotation.Introspected

@Introspected
class BookDTO {
    String title
    int pages
}
