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
//    
//    @Override
//    public List<UserManagement> getData(UserManagement um) {
//         List<UserManagement> listUserManagement = new ArrayList<UserManagement>();
//        String query = "SELECT * FROM USER_MANAGEMENT WHERE username=(?)";
//        
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, um.getUsername());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                UserManagement um1 = new UserManagement();
//                um1.setId(resultSet.getInt(1));
//                um1.setUsername(resultSet.getString(2));
//                um1.setPassword(resultSet.getString(3));
//                listUserManagement.add(um1);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return listUserManagement;
//    }
//    
//    @Override
//    public boolean register(UserManagement um) {
//        boolean result = false;
//        String query = "INSERT INTO USER_MANAGEMENT (username, password) VALUES ((?), (?))";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, um.getUsername());
//            preparedStatement.setString(2, BCrypt.hashpw(um.getPassword(), BCrypt.gensalt()));
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public boolean login(UserManagement um) {
//        boolean result = false;
//        String query = "SELECT password FROM USER_MANAGEMENT WHERE username=(?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, um.getUsername());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                UserManagement um1 = new UserManagement();
//                um1.setPassword(resultSet.getString(1));
//                result = BCrypt.checkpw(um.getPassword(), um1.getPassword());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public boolean changePassword(UserManagement um) {
//        boolean result = false;
//        String query = "UPDATE USER_MANAGEMENT SET password=(?) WHERE username=(?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, BCrypt.hashpw(um.getPassword(), BCrypt.gensalt()));
//            preparedStatement.setString(2, um.getUsername());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

    @Override
    public List<UserManagement> getData(UserManagement um, boolean IsGetByUsername) {
        List<UserManagement> listUserManagement = new ArrayList<UserManagement>();
        String query = (IsGetByUsername) 
                ?"SELECT * FROM USER_MANAGEMENT WHERE username=(?) ORDER BY 1"
                :"SELECT * FROM USER_MANAGEMENT ORDER BY 1";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if(IsGetByUsername) preparedStatement.setString(1, um.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                UserManagement um1 = new UserManagement();
                um1.setId(resultSet.getInt(1));
                um1.setUsername(resultSet.getString(2));
                um1.setPassword(resultSet.getString(3));
                listUserManagement.add(um1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listUserManagement;
    }
    
    @Override
    public boolean save(UserManagement um) {
        boolean result = false;
        String query = (getData(new UserManagement(um.getUsername(), null), true).isEmpty())
                ?"INSERT INTO USER_MANAGEMENT (id, password, username) VALUES ((?),(?),(?))"
                :"UPDATE USER_MANAGEMENT SET id=(?), password=(?) WHERE username=(?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, um.getId());
            preparedStatement.setString(2, um.getPassword());
            preparedStatement.setString(3, um.getUsername());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM USER_MANAGEMENT WHERE id=(?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
}
