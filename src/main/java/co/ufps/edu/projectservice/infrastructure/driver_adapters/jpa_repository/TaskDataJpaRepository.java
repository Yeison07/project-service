package co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDataJpaRepository extends JpaRepository<TaskData,Long> {

    List<TaskData> findAllByIdIn(Long taskId );
}
