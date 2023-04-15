package co.ufps.edu.projectservice.infrastructure.entry_points;

import co.ufps.edu.projectservice.domain.model.Project;
import co.ufps.edu.projectservice.domain.useCase.ProjectUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectUseCase projectUseCase;

    public ProjectController(ProjectUseCase projectUseCase) {
        this.projectUseCase = projectUseCase;
    }

    @RequestMapping(path = "/registerNewProject",method = RequestMethod.PUT)
    public ResponseEntity<Object>registerNewProject(@RequestBody Project project){
        if (project==null){
            String message="The project submit is empty or has incomplete fields";
            return new ResponseEntity<>(message,HttpStatus.CREATED);

        }
        return new ResponseEntity<>(projectUseCase.saveProject(project),HttpStatus.CREATED);
    }

    @RequestMapping(path = "/getAllProjects",method = RequestMethod.GET)
    public ResponseEntity<Object> findAllProjects(){
        var projects=projectUseCase.findAllProjects();
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @RequestMapping(path = "/getProjectById/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> findAllProjects(@PathVariable Long id){
        var projects=projectUseCase.findAllProjects();
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @RequestMapping(path = "/getAllProjectsById",method = RequestMethod.POST)
    public ResponseEntity<Object> findAllProjectsById(@RequestBody List<Long>projectsId){
        var projects=projectUseCase.findAllProjectsById(projectsId);
        if (projects==null){
            String message="The requested resource was not found";
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

}