/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.SessLogin;


/**
 *
 * @author Relion31
 */
public interface ISessLoginDAO {
    
    public int getData(String email, String password);
    
    public boolean login(String email, String password);
    
}
