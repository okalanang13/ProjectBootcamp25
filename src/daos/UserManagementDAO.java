/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IUserManagementDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.UserManagement;
import org.mindrot.jbcrypt.BCrypt;
import tools.DBConnection;

/**
 *
 * @author Okala
 */
public class UserManagementDAO implements IUserManagementDAO {

    private Connection connection;

    public UserManagementDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<UserManagement> getId(UserManagement um) {
         List<UserManagement> listUserManagement = new ArrayList<UserManagement>();
        String query = "SELECT id FROM USER_MANAGEMENT WHERE username=(?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, um.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                UserManagement um1 = new UserManagement();
                um1.setId(resultSet.getInt(0));
                um1.setUsername(resultSet.getString(1));
                um1.setPassword(resultSet.getString(2));
                listUserManagement.add(um1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listUserManagement;
    }
    
    @Override
    public boolean register(UserManagement um) {
        boolean result = false;
        String query = "INSERT INTO USER_MANAGEMENT (username, password) VALUES ((?), (?))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, um.getUsername());
            preparedStatement.setString(3, BCrypt.hashpw(um.getPassword(), BCrypt.gensalt()));
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean login(UserManagement um) {
        boolean result = false;
        String query = "SELECT password FROM USER_MANAGEMENT WHERE username=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, um.getUsername());
            preparedStatement.setString(3, BCrypt.hashpw(um.getPassword(), BCrypt.gensalt()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                UserManagement um1 = new UserManagement();
                um1.setPassword(resultSet.getString(0));
                result = BCrypt.checkpw(um.getPassword(), um1.getPassword());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
