package fadintan.learns.ppmtool.services;


import fadintan.learns.ppmtool.Project.Project;
import fadintan.learns.ppmtool.exceptions.ProjectIdException;
import fadintan.learns.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already exist.");
        }

    }
}
