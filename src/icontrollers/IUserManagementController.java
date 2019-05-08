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
    
    public List<UserManagement> getId(UserManagement um);
    
    public String register(String username, String password);
    
    public String login(String username, String password);
    
}
