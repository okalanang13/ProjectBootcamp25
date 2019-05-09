/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.UserManagement;

/**
 *
 * @author Okala
 */
public interface IUserManagementDAO {
    
    public List<UserManagement> getData(UserManagement um, boolean isGetByUsername);
    
    public boolean save(UserManagement um);
    
    public boolean delete(int id);
    
}
