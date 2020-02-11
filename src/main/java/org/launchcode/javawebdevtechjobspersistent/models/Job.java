package org.launchcode.javawebdevtechjobspersistent.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Job extends AbstractEntity{

    @ManyToOne
    private Employer employer;

    @ManyToMany
    public List<Skill> skills;

    public Job() { }

    public Job(Employer anEmployer, Iterable<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = (List<Skill>) someSkills;
    }

    // Getters and setters.

//    public String getName() {
//        return super.getName();
//    }

//    public void setName(String name) {
//        super.setName(name);
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
