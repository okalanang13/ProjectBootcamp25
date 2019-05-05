/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employee;


/**
 *
 * @author Relion31
 */
public interface IEmployeeDAO {
    
    public List<Employee> getAll();

    public List<Employee> getById(int id);

    public List<Employee> search(String key);

    public boolean insert(Employee E);

    public boolean update(Employee E);

    public boolean delete(int id);
}
