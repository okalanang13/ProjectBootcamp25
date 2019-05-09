/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.UserManagement;

/**
 *
 * @author Okala
 */
public interface IUserManagementController {
    
    public List<UserManagement> getAll();
    
    public List<UserManagement> getByUsername(String username);
    
    public String login(String username, String password);
    
    public String register(String username, String password, String retypePassword);
    
    public String changeUsername(String username, String password);
    
    public String changePassword(String username, String password, String newPassword, String retypePassword);
    
    public String removeAccount(String username, String password);
    
}
