package co.ufps.edu.projectservice.infrastructure.mapper;

import co.ufps.edu.projectservice.domain.model.Task;
import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.TaskData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperTask {
    Task toTask(TaskData taskData);
    TaskData toTaskData(Task task);
    List<Task>toListTask(List<TaskData>taskDataList);
    List<TaskData>toListTaskData(List<Task>taskList);


}
