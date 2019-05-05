/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;


/**
 *
 * @author Relion31
 */
public interface IEmployeeController {
    public List<Employee> getAll();

    public List<Employee> getById(String id);

    public List<Employee> search(String key);

    public String insert(String id, String first_name, String last_name, String email, String phone_number, String hire_date, String job, String salary, String commission_pct, String manager, String department);

    public String update(String id, String first_name, String last_name, String email, String phone_number, String hire_date, String job, String salary, String commission_pct, String manager, String department);

    public String delete(String id);
}
