package com.zgacelera.todolistspring.service

import com.zgacelera.todolistspring.model.entity.Task

interface TaskService {
    Task save(Task task)
    Optional<Task> findById(Long id)
    List<Task> findAll()
    void delete(Task task)
}
