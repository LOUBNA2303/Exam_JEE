package servlets.controlejee.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private long id ;
    private String name;
    private double budget;

    public Set<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(Set<Employe> employe) {
        this.employe = employe;
    }

    public List<Affectation> getAffectation() {
        return affectation;
    }

    public void setAffectation(List<Affectation> affectation) {
        this.affectation = affectation;
    }

    @JoinTable(name = "affectation",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id"))
    private Set<Employe> employe = new HashSet<>();
    @OneToMany(mappedBy = "project" , cascade = CascadeType.PERSIST)
    private List<Affectation> affectation;

    public Project(long id, String name, double budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
