package fadintan.learns.ppmtool.repositories;

import fadintan.learns.ppmtool.Project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    // JPA bantu find attribute yg related ke object. in this case object = project identifier
    Project findByProjectIdentifier(String projectId);

}