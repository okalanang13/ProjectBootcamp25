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
    public List<Employee> getData(Object key, boolean isGetById) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        String query =  (isGetById) 
                        ? "SELECT * FROM EMPLOYEES WHERE employee_id=(?)"
                        :"SELECT first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id " +
"FROM employees WHERE employee_id LIKE (?) OR first_name LIKE (?) OR last_name LIKE (?) OR email LIKE (?) OR phone_number LIKE (?) OR hire_date LIKE (?) OR job_id LIKE (?) " +
"OR salary LIKE (?) OR commission_pct LIKE (?) OR manager_id LIKE (?) OR department_id LIKE (?) ORDER BY 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (isGetById) {
                preparedStatement.setInt(1, (int) key);
            } else {
                preparedStatement.setString(1, "%" + key + "%");
                preparedStatement.setString(2, "%" + key + "%");
                preparedStatement.setString(3, "%" + key + "%");
                preparedStatement.setString(4, "%" + key + "%");
                preparedStatement.setString(5, "%" + key + "%");
                preparedStatement.setString(6, "%" + key + "%");
                preparedStatement.setString(7, "%" + key + "%");
                preparedStatement.setString(8, "%" + key + "%");
                preparedStatement.setString(9, "%" + key + "%");
                preparedStatement.setString(10, "%" + key + "%");
                preparedStatement.setString(11, "%" + key + "%");
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee e = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                listEmployee.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM EMPLOYEES WHERE employee_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean save(Employee e) {
        boolean result = false;
        String query;
        if (getData(e.getId(), true).isEmpty()) {
            query = "INSERT INTO EMPLOYEES (first_name ,last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id, employee_id) VALUES ((?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?))";
        } else {
            query = "UPDATE EMPLOYEES SET first_name=(?), last_name=(?), email=(?), phone_number=(?), hire_date=(?), "
                    + "job_id=(?), salary=(?), commission_pct=(?), manager_id=(?), department_id=(?) WHERE employee_id=(?)";

        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, e.getFirstName());
            preparedStatement.setString(2, e.getLastName());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setString(4, e.getPhoneNumber());
            preparedStatement.setDate(5, (java.sql.Date) e.getHireDate());
            preparedStatement.setString(6, e.getJob());
            preparedStatement.setInt(7, e.getSalary());
            preparedStatement.setDouble(8, e.getCommissionPct());
            preparedStatement.setInt(9, e.getManager());
            preparedStatement.setInt(10, e.getDepartment());
            preparedStatement.setInt(11, e.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
