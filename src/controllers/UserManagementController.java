/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserManagementDAO;
import icontrollers.IUserManagementController;
import idaos.IUserManagementDAO;
import java.sql.Connection;
import java.util.List;
import models.UserManagement;

/**
 *
 * @author Okala
 */
public class UserManagementController implements IUserManagementController {

    private IUserManagementDAO iumdao;
    
    public UserManagementController(Connection connection){
        iumdao = new UserManagementDAO(connection);
    }
    
    public List<UserManagement> getId(UserManagement um){
        return iumdao.getId(um);
    }
    
    public String register(String username, String password){
        String result = "Data gagal simpan";
        if(iumdao.login(new UserManagement(username, password))){
            result = "Anda berhasil mendaftarkan username dan password";
        }
        return result;
    }
    
    public String login(String username, String password){
        String result = "Maaf username atau password yang anda masukan tidak sama";
        if(iumdao.login(new UserManagement(username, password))){
            result = "Anda berhasil login";
        }
        return result;
    }
}
