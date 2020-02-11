package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model,
                                    @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
         //   model.addAttribute("employer", employerRepository.findById(employerId));
         //   model.addAttribute("skills", skillRepository.findById(employerId));
            return "add";
        }
        Optional<Employer> result = employerRepository.findById(employerId);
        //return "redirect:";
        if(result.isEmpty()){
            model.addAttribute("title", "Add Job");
            return "add";
        }
        Employer employer=(Employer)result.get();
        newJob.setEmployer(employer);
        model.addAttribute("employer",employer.getName());

//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);
        return "index";
    }

    @GetMapping("view/{anId}")
    public String displayViewEntity(Model model, @PathVariable int anId) {
        Optional optEmployer = employerRepository.findById(anId);
        Optional optSkill = skillRepository.findById(anId);
        Optional optJob = jobRepository.findById(anId);

        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employers", employer);
            return "employers/view";
        } else if (optSkill.isPresent()){
            Skill skill = (Skill) optSkill.get();
            model.addAttribute( "skills", skill );
            return "skills/view";
        } else if (optJob.isPresent()){
            Job job = (Job) optJob.get();
            model.addAttribute( "jobs", job );
            return "jobs/view";
        }
        return "redirect:";
    };



}
