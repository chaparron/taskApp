package com.inditex.challengeinditex

import com.inditex.challengeinditex.model.Task
import com.inditex.challengeinditex.repository.TaskRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
class ChallengeInditexApplication

fun main(args: Array<String>) {
    runApplication<ChallengeInditexApplication>(*args)
}

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select().apis(
            RequestHandlerSelectors.withClassAnnotation(RestController::class.java)
        ).paths(PathSelectors.any())
            .build()
    }
}

@Configuration
class InitDataConfiguration {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var repository: TaskRepository


    @Bean
    fun initData() {
        logger.info("Clearing previous data")
        repository.deleteAll()
        logger.info("About to create some data")

        initTasksData()
        logger.info("Data saved")
    }

    private fun initTasksData() {
        val tasks = listOf(
            Task("1", "Recoger la casa", "Hay que recoger la casa", false),
            Task("2", "Sacar al perro", "Hay que pasear al perro para que cague", true),
            Task("3", "Recoger dinero Aloha", "Recoger el dinero de Aloha para hacernos ricos", true),
            Task("4", "Limpiar almacén", "Limpiar el almacén para que no de pena de ver", false)
        )
        repository.insert(tasks)
    }
}