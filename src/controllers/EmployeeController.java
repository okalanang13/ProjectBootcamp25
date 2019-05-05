/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import idaos.IEmployeeDAO;
import java.sql.Connection;
import java.util.List;
import models.Employee;
import icontrollers.IEmployeeController;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Relion31
 */
public class EmployeeController implements IEmployeeController{

    Date d = new Date();
    private IEmployeeDAO iedao;
    
    public EmployeeController(Connection connection){
        iedao = new EmployeeDAO(connection);
    }
    
    @Override
    public List<Employee> getAll() {
        return iedao.getAll();
    }

    @Override
    public List<Employee> getById(String id) {
       return iedao.getById(Integer.parseInt(id));
    }

    @Override
    public List<Employee> search(String key) {
       return iedao.search(key);
    }

    @Override
    public String insert(String id, String first_name, String last_name, String email, String phone_number, String hire_date, String job, String salary, String commission_pct, String manager, String department) {
        String result = "Maaf data gagal disimpan";
        Employee employee = new Employee(Integer.parseInt(id), first_name, last_name, email, phone_number, d, job, Integer.parseInt(salary), Double.parseDouble(commission_pct), Integer.parseInt(manager), Integer.parseInt(department));
        if (iedao.insert(employee)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String first_name, String last_name, String email, String phone_number, String hire_date, String job, String salary, String commission_pct, String manager, String department) {
        String result = "Maaf data gagal disimpan";
        Employee employee = new Employee(Integer.parseInt(id), first_name, last_name, email, phone_number, d, job, Integer.parseInt(salary), Double.parseDouble(commission_pct), Integer.parseInt(manager), Integer.parseInt(department));
        if (iedao.update(employee)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Maaf data gagal dihapus";
        if (iedao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            
        }
        return result;
    }


  
    
}
