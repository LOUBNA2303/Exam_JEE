package servlets.controlejee.model;

import jakarta.persistence.*;
import jdk.internal.event.Event;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue
    private long id ;
    private String name;
    @ManyToMany(mappedBy = "employee")
    private Set<Project> students = new HashSet<>();

    public Employe(long id, String name, String email) {

    }
    }





    public List<Affectation> getAffectation() {
        return affectation;
    }

    public void setAffectation(List<Affectation> affectation) {
        this.affectation = affectation;
    }

    @OneToMany(mappedBy = "employe" , cascade = CascadeType.PERSIST)
    private List<Affectation> affectation;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    private String email;
    private List<String> skills;
    @ManyToMany(mappedBy = "employe")
    private Set<Project> project = new HashSet<>();



