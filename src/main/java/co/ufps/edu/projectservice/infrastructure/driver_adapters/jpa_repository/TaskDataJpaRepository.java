package co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository;

import co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDataJpaRepository extends JpaRepository<TaskData,Long> {

    @Query("SELECT t from TaskData t where t.id=:id")
    List<TaskData> findAllById(@Param("id") Long taskId );
}
