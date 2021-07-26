package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        } catch (Exception e) {
            throw new ProjectIdException(
                    "Project ID '" + project.getProjectIdentifier().toUpperCase() + "' is already exist!");
        }

    }

    public Project findByProjectIdentifierService(String projectIdentifier) {

        Project project = projectRepository.findByProjectIdentifier(projectIdentifier);

        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectIdentifier.toUpperCase() + "' is doesn't exist!");
        }

        return project;

    }

    public Iterable<Project> findAllProjectService() {

        Iterable<Project> iterableProject = projectRepository.findAll();

        if (!iterableProject.iterator().hasNext()) {
            throw new ProjectIdException("No data recorded");
        }

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifierService(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Can't delete project identifier '" + projectIdentifier + "' does not exist!");
        } else {
            projectRepository.delete(project);
        }

    }

    public void deleteProjectsByIndentifiersService(List<String> projectIndentifiers) {

        List<Project> projects = projectRepository.findAllByProjectIdentifiers(projectIndentifiers);

        if (projects.isEmpty()) {
            throw new ProjectIdException("Can't delete project identifier '" + projectIndentifiers.toString() + "' does not exist!");
        }

        projects
                .stream()
                .map(Project::getProjectIdentifier)
                .forEach(System.out::println);

        projectRepository.deleteAllByProjectIdentifier(projects
                .stream()
                .map(Project::getProjectIdentifier)
                .collect(Collectors.toList()));

    }

}
