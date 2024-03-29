package servlets.controlejee.dao;

import servlets.controlejee.model.Employe;

import java.util.List;

public interface EmployeDao {
    boolean addLine(Employe em);
    boolean delete(int id); List<Employe> selectAll();

    void addLines(Employe empl1, Employe empl2);
}
