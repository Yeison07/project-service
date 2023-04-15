package co.ufps.edu.projectservice.infrastructure.driver_adapters.jpa_repository;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "project")
public class ProjectData {

    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinished;

    public ProjectData() {
    }

    public ProjectData(Long id, String title, String description, LocalDateTime dateCreation, LocalDateTime dateFinished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateFinished = dateFinished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDateTime dateFinished) {
        this.dateFinished = dateFinished;
    }
}
