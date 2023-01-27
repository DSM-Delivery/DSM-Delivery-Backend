package com.dsmdeliverybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
class DsmDeliveryBackendApplication


    fun main(args: Array<String>) {
        runApplication<DsmDeliveryBackendApplication>(*args)
    }

