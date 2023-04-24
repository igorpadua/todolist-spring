package com.zgacelera.todolistspring.controller

import com.zgacelera.todolistspring.model.entity.Task
import com.zgacelera.todolistspring.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/tasks")
class TaskController {

    private final TaskService taskService

    TaskController(TaskService taskService) {
        this.taskService = taskService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Task save(@RequestBody Task task) {
        return taskService.save(task)
    }

    @GetMapping("{id}")
    Task findById(@PathVariable Long id) {
        return taskService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Candidato Não existente com id " + id)
        )
    }

    @GetMapping
    List<Task> findAll() {
        return taskService.findAll()
    }

    @PutMapping("{id}")
    Task update(@PathVariable Long id, @RequestBody Task task) {
        taskService.findById(id).map { taskExistente ->
            task.id = taskExistente.id
            taskService.save(task)
            return task
        }.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Candidato Não existente com id " + id)
        )
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        taskService.findById(id).map {task ->
            taskService.delete(task)
            return Void.TYPE
        }.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Candidato Não existente com id " + id)
        )
    }


}
