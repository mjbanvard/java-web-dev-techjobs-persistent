package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters long.")
    private String location;

    public Employer() { }

    public Employer(String newLocation) {
        super();
        this.location = newLocation;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "employer")
//    @JoinColumn
    public List<Job> jobs = new ArrayList<>();
}
