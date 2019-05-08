/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.SessLogin;

/**
 *
 * @author Okala
 */
public interface ISessLoginController  {
    
    public int getById(String email, String password);
    
    public boolean login(String email, String password);
    
}
