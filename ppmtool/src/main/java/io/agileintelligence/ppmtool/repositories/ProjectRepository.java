package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>{

    Project findByProjectIdentifier(String projectIdentifier);

    @Modifying
    @Query("DELETE FROM Project p WHERE p.projectIdentifier IN (:projectIdentifiers)")
     void deleteAllByProjectIdentifier(@Param("projectIdentifiers") List<String> projectIdentifiers);

    @Override
    List<Project> findAll();

    @Modifying
    @Query("SELECT p FROM Project p WHERE p.projectIdentifier IN (:projectIdentifiers)")
    List<Project> findAllByProjectIdentifiers(@Param("projectIdentifiers") List<String> projectIdentifiers);


}
