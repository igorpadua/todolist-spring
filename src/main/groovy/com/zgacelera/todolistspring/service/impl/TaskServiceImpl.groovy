package com.zgacelera.todolistspring.service.impl

import com.zgacelera.todolistspring.model.entity.Task
import com.zgacelera.todolistspring.model.repository.TaskRepository
import com.zgacelera.todolistspring.service.TaskService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository

    TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository
    }

    @Override
    @Transactional
    Task save(Task task) {
        return taskRepository.save(task)
    }

    @Override
    Optional<Task> findById(Long id) {
        return taskRepository.findById(id)
    }

    @Override
    List<Task> findAll() {
        return taskRepository.findAll()
    }

    @Override
    void delete(Task task) {
        taskRepository.delete(task)
    }
}
