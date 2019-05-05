/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import java.util.Date;

/**
 *
 * @author Relion31
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> listEmployee = new ArrayList<Employee>();
        String query = "SELECT * FROM EMPLOYEES ORDER BY employee_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee e = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                e.setId(resultSet.getInt(1));
                e.setFirstName(resultSet.getString(2));
                e.setLastName(resultSet.getString(3));
                e.setEmail(resultSet.getString(4));
                e.setPhoneNumber(resultSet.getString(5));
                e.setHireDate(resultSet.getDate(6));
                e.setJob(resultSet.getString(7));
                e.setSalary(resultSet.getInt(8));
                e.setCommissionPct(resultSet.getDouble(9));
                e.setManager(resultSet.getInt(10));
                e.setDepartment(resultSet.getInt(11));
                listEmployee.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public List<Employee> getById(int id) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        String query = "SELECT * FROM EMPLOYEES WHERE employee_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee E = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                E.setId(resultSet.getInt(1));
                E.setFirstName(resultSet.getString(2));
                E.setLastName(resultSet.getString(3));
                E.setEmail(resultSet.getString(4));
                E.setPhoneNumber(resultSet.getString(5));
                E.setHireDate(resultSet.getDate(6));
                E.setJob(resultSet.getString(7));
                E.setSalary(resultSet.getInt(8));
                E.setCommissionPct(resultSet.getDouble(9));
                E.setManager(resultSet.getInt(10));
                E.setDepartment(resultSet.getInt(11));
                listEmployee.add(E);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public List<Employee> search(String key) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        String query = "SELECT * FROM EMPLOYEES WHERE employee_id LIKE (?) OR first_name LIKE (?) OR last_name LIKE (?) OR email LIKE (?) OR phone_number LIKE (?) OR hire_date LIKE (?) job_id LIKE (?) OR salary LIKE (?) OR commission_pct LIKE (?) OR manager_id LIKE (?) OR department_id LIKE (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            preparedStatement.setString(2, "%"+key+"%");
            preparedStatement.setString(3, "%"+key+"%");
            preparedStatement.setString(4, "%"+key+"%");
            preparedStatement.setString(5, "%"+key+"%");
            preparedStatement.setString(6, "%"+key+"%");
            preparedStatement.setString(7, "%"+key+"%");
            preparedStatement.setString(8, "%"+key+"%");
            preparedStatement.setString(9, "%"+key+"%");
            preparedStatement.setString(10, "%"+key+"%");
            preparedStatement.setString(11, "%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee E = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                E.setId(resultSet.getInt(1));
                E.setFirstName(resultSet.getString(2));
                E.setLastName(resultSet.getString(3));
                E.setEmail(resultSet.getString(4));
                E.setPhoneNumber(resultSet.getString(5));
                E.setHireDate(resultSet.getDate(6));
                E.setJob(resultSet.getString(7));
                E.setSalary(resultSet.getInt(8));
                E.setCommissionPct(resultSet.getDouble(9));
                E.setManager(resultSet.getInt(10));
                E.setDepartment(resultSet.getInt(11));
                listEmployee.add(E);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public boolean insert(Employee E) {
        boolean result = false;
        String query = "INSERT INTO EMPLOYEES (employee_id, first_name ,last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES ((?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, E.getId());
            preparedStatement.setString(2, E.getFirstName());
            preparedStatement.setString(3, E.getLastName());
            preparedStatement.setString(4, E.getEmail());
            preparedStatement.setString(5, E.getPhoneNumber());
            preparedStatement.setDate(6, (java.sql.Date) E.getHireDate());
            preparedStatement.setString(7, E.getJob());
            preparedStatement.setInt(8, E.getSalary());
            preparedStatement.setDouble(9, E.getCommissionPct());
            preparedStatement.setInt(10, E.getManager());
            preparedStatement.setInt(11, E.getDepartment());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Employee E) {
        boolean result = false;
        String query = "UPDATE EMPLOYEES SET first_name=(?), last_name=(?), email=(?), phone_number=(?), hire_date=(?), "
                + "job_id=(?), salary=(?), commission_pct=(?), manager_id=(?), department_id=(?) WHERE employee_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, E.getFirstName());
            preparedStatement.setString(2, E.getLastName());
            preparedStatement.setString(3, E.getEmail());
            preparedStatement.setString(4, E.getPhoneNumber());
            preparedStatement.setDate(5, (java.sql.Date) E.getHireDate());
            preparedStatement.setString(6, E.getJob());
            preparedStatement.setInt(7, E.getSalary());
            preparedStatement.setDouble(8, E.getCommissionPct());
            preparedStatement.setInt(9, E.getManager());
            preparedStatement.setInt(10, E.getDepartment());
            preparedStatement.setInt(11, E.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM EMPLOYEES WHERE employee_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
