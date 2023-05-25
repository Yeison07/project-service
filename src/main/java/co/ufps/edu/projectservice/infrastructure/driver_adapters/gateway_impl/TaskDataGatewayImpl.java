package co.ufps.edu.projectservice.infrastructure.driver_adapters.gateway_impl;

import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.domain.model.gateways.TaskGateway;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.TaskData;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository.TaskDataJpaRepository;
import co.ufps.edu.projectservice.infrastructure.mapper.MapperTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDataGatewayImpl implements TaskGateway {

    private final TaskDataJpaRepository repository;
    private final MapperTask mapperTask;

    public TaskDataGatewayImpl(TaskDataJpaRepository repository, MapperTask mapperTask) {
        this.repository = repository;
        this.mapperTask = mapperTask;
    }

    @Override
    public Task save(Task task) {
        if (task == null) return null;
        TaskData taskData=mapperTask.toTaskData(task);
        return mapperTask.toTask(repository.save(taskData));
    }

    @Override
    public void deleteByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return mapperTask.toTask(repository.findById(id).orElse(null));
    }

    @Override
    public List<Task> findAllTasks() {
        return mapperTask.toListTask(repository.findAll());
    }

    @Override
    public List<Task> findAllTasksById(Long taskId) {
        return mapperTask.toListTask(repository.findAllById(taskId));
    }
}
