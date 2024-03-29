package servlets.controlejee.service;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import servlets.controlejee.dao.EmployeDao;
import servlets.controlejee.dao.EmployeDaoImpl;
import servlets.controlejee.model.Employe;

import java.io.IOException;
import java.util.List;

public class EmplyeService {
    private static EmployeDao employeDao;

    public EmplyeService() {
        employeDao = new EmployeDaoImpl();
    }

    public static void deleteEmploye(int id) {
    }

    public void StudentService(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    public boolean addStudent(Employe std) throws IOException {

        boolean added = employeDao.addLine(std);
        if (added){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"la ligne a ete supprimer avec succees",""));
        }else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"la ligne a ete supprimer avec succees",""));
        }

        redirectToHomePage();

        return added;
    }

    public List<Employe> selectEmployes(){
        return employeDao.selectAll();
    }

    public static void addStudents(Employe empl1, Employe empl2){
        employeDao.addLines(empl1, empl2);

    }



    public static void deleteEmploye(long id){
        boolean deleted = employeDao.delete(id);
        if (deleted){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"la ligne a ete supprimer avec succees",""));
        }else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"la ligne n'a pas ete supprimer avec succees",""));
        }

    }

    public List<Employe> selectEmploye(String cond){
        List<Employe> slt = employeDao.selectOne(cond);
        return slt;
    }

    public void closeEm(){
        employeDao.close();
    }

    public Employe findStudent(long id){
        return employeDao.find(id);

    }

    public void redirectToHomePage() throws IOException {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("firstpage.xhtml");
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'exception de redirection
        }
    }

    public static void addStudents(Employe empl1, Employe empl2) {
    }

    public static void updateStudent(int id) {
    }

    public static void deleteStudent(int id) {
    }

    public List<Employe> selectEmployes() {
    }
}
