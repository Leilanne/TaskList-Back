package com.supero.tasklist.services;

import com.supero.tasklist.models.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskSevice {

    public LocalDate defineData(){
        LocalDate data = LocalDate.now();

        return data;
    }

    public Task adicionaDataCriacao(Task task){
        task.setDataCriacao(defineData());
        return task;
    }

    public Task adicionaDataEdicao(Task task){
        task.setDataEdicao(defineData());
        return task;
    }

    public Task adicionaDataRemocao(Task task){
        task.setDataRemocao(defineData());
        return task;
    }

    public Task concluiTask(Task task){
        task.setStatus(true);
        task.setDataConclusao(defineData());
        return task;
    }

    public Task removeConclusao(Task task){
        task.setStatus(false);
        task.setDataConclusao(null);
        return task;
    }

}
