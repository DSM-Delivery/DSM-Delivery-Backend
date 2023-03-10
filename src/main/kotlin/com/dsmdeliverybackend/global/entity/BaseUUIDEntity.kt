package com.dsmdeliverybackend.global.entity

import com.fasterxml.uuid.Generators
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseUUIDEntity(
    id: UUID?
) {
    @Id
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID = id ?: Generators.timeBasedGenerator().generate()
}