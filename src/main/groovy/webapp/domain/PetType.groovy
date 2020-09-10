package webapp.domain

import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.model.DataType

@TypeDef(type = DataType.INTEGER)
enum PetType {
    DOG,
    CAT
}