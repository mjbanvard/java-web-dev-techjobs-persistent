package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;


@Entity
public class Skill extends AbstractEntity {

    @Size(max = 50, message = "Please keep description to 50 characters long, or less.")
    private String description;

    public Skill() {}

    public Skill(String newDescription) {
        super();
        if (newDescription.isEmpty()) {
            this.description = "";
        } else {
            this.description = newDescription;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
