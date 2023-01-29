package com.inditex.challengeinditex.controller

import com.inditex.challengeinditex.model.Task
import com.inditex.challengeinditex.service.TaskService
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*


@RestController
@CrossOrigin(origins = ["http://localhost:3000/"])
@RequestMapping("api/tasks")
class TaskController (
    private val service: TaskService
) {
    @GetMapping
    fun getTasks(): List<Task> = service.getTasks()

    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: String): Optional<Task> = service.getTask(taskId)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addTask(@RequestBody task: Task): Task = service.saveTask(task)

    @DeleteMapping("/delete/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTask(@PathVariable taskId: String): Unit = service.deleteTask(taskId)
}

@Configuration
internal class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }
}