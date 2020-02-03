package com.supero.tasklist.controllers;

import com.supero.tasklist.models.Task;
import com.supero.tasklist.repositories.TaskRepository;
import com.supero.tasklist.services.TaskSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskSevice taskSevice;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<Task> listarTarefas() {
        return taskRepository.findAllByDataRemocaoIsNullOrderByStatus();
    }

    @CrossOrigin
    @PostMapping(value = "/task")
    public Task adicionaTask(@RequestBody Task task) {
        task = taskSevice.adicionaDataCriacao(task);
        return taskRepository.save(task);
    }
    @CrossOrigin
    @PutMapping(value = "/task/edita")
    public Task editaTask(@RequestBody Task task) {
        task = taskSevice.adicionaDataEdicao(task);
        return taskRepository.save(task);
    }

    @CrossOrigin
    @PutMapping("/task/remove")
    public Task removeTask(@RequestBody Task task) {
        task = taskSevice.adicionaDataRemocao(task);
        return taskRepository.save(task);
    }

    @CrossOrigin
    @PutMapping("/task/conclui")
    public Task concluiTask(@RequestBody Task task) {
        task = taskSevice.concluiTask(task);
        return taskRepository.save(task);
    }
    @CrossOrigin
    @PutMapping("/task/remove-conclusao")
    public Task removecCnclusaoTask(@RequestBody Task task) {
        task = taskSevice.removeConclusao(task);
        return taskRepository.save(task);
    }



}
