package servlets.controlejee.dao;

import jakarta.faces.context.FacesContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import servlets.controlejee.model.Employe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeDaoImpl implements EmployeDao{
    private EntityManagerFactory emf;
    private EntityManager em ;
    private List<Employe> employes;
    public EmployeDaoImpl() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    private Employe employe;
    public List<Employe> selectAll(){
        Query query = em.createQuery("SELECT e FROM Employe e", Employe.class);
        List<Employe> students;
        students = query.getResultList();
        System.out.println("Employe List");
        for (Employe e : employes) {
            System.out.println(e);
        }
        return employes;
    }

    public boolean addLine(Employe em){
        if(true){
            Employe newstudent = new Employe();
            newstudent.setId(em.getId());
            newstudent.setName(em.getName());
            newstudent.setEmail(em.getEmail());
            // Démarrez une transaction
            em.getTransaction().begin();


            em.persist(newstudent);

            // Validez et finalisez la transaction
            em.getTransaction().commit();
            return true;
        }else {return false;}
    }

    public void addLines(Employe std1,Employe std2 ){
        List<Employe> newStudents = new ArrayList<>();
        newStudents.add((Employe) new Employe(std1.getId(),std1.getName(),std1.getEmail()));
        newStudents.add((Employe) new Employe("2","Hajar","hajar@gmail.com"));

        em.getTransaction().begin();

        for(Student student : newStudents){
            em.persist(student);
        }

        em.getTransaction().commit();
    }

    public void update(int id){
        // Récupérer l'entité étudiant que vous souhaitez mettre à jour (par exemple, en utilisant son ID)

        Student studentToUpdate = em.find(Student.class, id);  // Remplacez 5 par l'ID de l'étudiant que vous souhaitez mettre à jour
        if(studentToUpdate != null) {
            studentToUpdate.setPrenom("abderrahim ");

            em.getTransaction().begin();
            em.merge(studentToUpdate);
            em.getTransaction().commit();
        }else{
            System.out.println("Etudiant non trouve");
        }
    }

    public boolean delete(int id){
        Student studentToDelete = em.find(Student.class, id);
        if(studentToDelete != null){
            em.getTransaction().begin();
            em.remove(studentToDelete);
            em.getTransaction().commit();
            return true;
        }else{
            return false;
        }
    }

    public List<Student> selectOne(String condition){
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.nom >= :naaaame", Student.class);
        query.setParameter("naaaame", condition);
        List<Student> students = query.getResultList();
        return students;
    }


    public void close(){
        em.close();
        emf.close();
    }

    public Student find(Long id ){
        return em.find(Student.class, id);
    }

//    public Student addCarteEtudiant(Long id , CarteEtudiant carteEtudiant){
//        em.getTransaction().begin();
//        Student student = find(id);
//        student.setCarteEtudiant(carteEtudiant);
//        em.getTransaction().commit();
//        return student;
//    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public void Afficher(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Afficher.xhtml");
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'exception de redirection
        }
    }
}
