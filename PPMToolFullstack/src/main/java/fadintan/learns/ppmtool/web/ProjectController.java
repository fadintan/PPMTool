package fadintan.learns.ppmtool.web;

import fadintan.learns.ppmtool.Project.Project;
import fadintan.learns.ppmtool.services.MapValidationErrorService;
import fadintan.learns.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapErrorService;

    // ResponseEntity controls json object yg mau dipass ke client.
    // BindingResult validator dr si objek. Ada error apa ngga
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        // Validasi
        ResponseEntity errorMap = mapErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        // ProjectService utk save ke db
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectByID(@PathVariable String projectId){

        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
}
