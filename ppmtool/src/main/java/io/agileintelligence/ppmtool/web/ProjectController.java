package io.agileintelligence.ppmtool.web;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService errorService;

    @PostMapping("")
    public ResponseEntity<? extends Object> createNewProject(@Valid @RequestBody Project project,
                                                             BindingResult bindingResult) {

        ResponseEntity<?> errorResponse = errorService.mapValidationService(bindingResult);
        if (errorResponse != null)
            return errorResponse;

        Project projectResult = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(projectResult, HttpStatus.CREATED);

    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIndentifier(@PathVariable String projectIdentifier) {

        Project project = projectService.findByProjectIdentifierService(projectIdentifier);

        return new ResponseEntity<Project>(project, HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjectList() {
        return projectService.findAllProjectService();

    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectIdentifier) {
        projectService.deleteProjectByIdentifierService(projectIdentifier);

        return new ResponseEntity<String>("Project with ID: '" + projectIdentifier + "' was deleted!", HttpStatus.OK);

    }

}
