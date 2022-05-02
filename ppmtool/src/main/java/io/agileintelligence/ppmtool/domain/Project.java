package io.agileintelligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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