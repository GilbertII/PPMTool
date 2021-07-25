package io.agileintelligence.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import io.agileintelligence.ppmtool.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectIdentifier);

}
