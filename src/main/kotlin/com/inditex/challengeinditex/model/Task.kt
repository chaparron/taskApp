package com.inditex.challengeinditex.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Task (
    @Id
    val id: String,
    val title: String,
    val description: String,
    val done: Boolean = false,
)