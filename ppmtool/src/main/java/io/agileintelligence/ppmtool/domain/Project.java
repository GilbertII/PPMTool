package io.agileintelligence.ppmtool.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotBlank(message = "Project name is required!")
    private String projectName;

    @NotBlank(message = "Project Identifier is required!")
    @Size(min = 4, max = 5, message = "Please input 4 to 5 characters!")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project description is required!")
    @Size(min = 4, message = "Please input more than 3 characters!")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateStart;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateEnd;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateCreated;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateUpdated;

    @Column(length = 1)
    private Boolean isActive;

    public Project() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectid(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @PrePersist
    protected void onCreate() {
        this.dateCreated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dateUpdated = new Date();
    }

    @PostPersist
    protected void afterCreate() {
        this.isActive = Boolean.TRUE;
    }

}