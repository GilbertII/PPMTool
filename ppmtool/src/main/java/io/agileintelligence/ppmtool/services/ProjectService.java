package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Project;

import java.util.List;


public interface ProjectService {

    public Project saveOrUpdateProject(Project project);

    public Project findByProjectIdentifierService(String projectIdentifier);

    public Iterable<Project> findAllProjectService();

    public void deleteProjectByIdentifierService(String projectIdentifier);

    public void deleteProjectsByIndentifiersService(List<String> projectIndentifiers);

}
