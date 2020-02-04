package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @Size(min = 3, max = 50, message = "Please keep description between 3 and 50 characters long.")
    private String description;

    public Skill() {}

    public Skill(String newDescription) {
        super();
        this.description = newDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
