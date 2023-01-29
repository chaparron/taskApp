package com.inditex.challengeinditex.service

import com.inditex.challengeinditex.model.Task
import com.inditex.challengeinditex.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(
    private val repository: TaskRepository
) {
    fun getTasks(): List<Task> = repository.findAll()

    fun getTask(id: String): Optional<Task> = repository.findById(id)

    fun saveTask(task: Task): Task {
        if (task.id.isNotEmpty()) return repository.save(task)
        val id = (getTasks().last().id.toInt() + 1).toString()
        return repository.save(Task(
            id,
            task.title,
            task.description
        ))

    }

    fun deleteTask(id: String) = repository.deleteById(id)
}