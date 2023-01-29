package com.inditex.challengeinditex.repository

import com.inditex.challengeinditex.model.Task
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository: MongoRepository <Task, String> {

}