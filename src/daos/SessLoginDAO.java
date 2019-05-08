/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import idaos.ISessLoginDAO;
import models.SessLogin;

/**
 *
 * @author Relion31
 */
public class SessLoginDAO implements ISessLoginDAO {

    private Connection connection;

    public SessLoginDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public int getData(String email, String password) {

        int result = -1;
        String query = "SELECT e.employee_id FROM employees e JOIN role r ON e.employee_id=r.employee_id WHERE e.email=(?) AND r.password=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean login(String email, String password) {

        boolean result = false;
        String query = "SELECT e.employee_id FROM employees e JOIN role r ON e.employee_id=r.employee_id WHERE email=(?) AND password=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

}
