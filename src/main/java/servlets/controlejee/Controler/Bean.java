package servlets.controlejee.Controler;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.view.ViewScoped;
import servlets.controlejee.model.Employe;
import servlets.controlejee.model.Project;
import servlets.controlejee.service.EmplyeService;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class Bean {
    private Employe employe;
    private EmplyeService employeService;
    private List<Employe> employes ;

    public Bean() {
        employe = new ArrayList<>();
        employeService = new EmplyeService();
        employes = employeService.selectEmployes();
        this.employe = new Employe();

    }


    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public EmplyeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmplyeService employeService) {
        this.employeService = employeService;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void addemployes(Employe empl1, Employe empl2){
        EmplyeService.addStudents(empl1, empl2);

    }



    public  void beanDeleteStudent(long id ){
        employeService.deleteEmploye(id);
    }

    public void beanSelectStudent(String cond){
        employeService.selectEmploye(cond);
    }

    public void beanFindStudent(long id){
        employeService.findStudent(id);

    }

}
