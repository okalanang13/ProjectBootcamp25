/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.SessLoginDAO;
import idaos.IEmployeeDAO;
import java.sql.Connection;
import java.util.List;
import models.Employee;
import icontrollers.IEmployeeController;
import icontrollers.ISessLoginController;
import idaos.ISessLoginDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SessLogin;

/**
 *
 * @author Relion31
 */
public class SessLoginController implements ISessLoginController{

    private final ISessLoginDAO isldao;
    
    public SessLoginController(Connection connection){
        isldao = new SessLoginDAO(connection);
    }
    
    @Override
    public int getById(String email, String password) {
        return isldao.getData(email, password);
    }
    
    @Override
    public boolean login(String email, String password) {
        return isldao.login(email, password);
    }
}
