package io.agileintelligence.ppmtool.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date dateStart;
    private Date dateEnd;

    private Date dateCreated;
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
    protected void afterCreate(){
        this.isActive = Boolean.TRUE;
    }

}