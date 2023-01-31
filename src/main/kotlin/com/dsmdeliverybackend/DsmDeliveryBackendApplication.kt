package com.dsmdeliverybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class DsmDeliveryBackendApplication


    fun main(args: Array<String>) {
        runApplication<DsmDeliveryBackendApplication>(*args)
    }

