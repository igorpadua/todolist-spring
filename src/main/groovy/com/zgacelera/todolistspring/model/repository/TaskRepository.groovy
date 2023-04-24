package com.zgacelera.todolistspring.model.repository

import com.zgacelera.todolistspring.model.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {
}
