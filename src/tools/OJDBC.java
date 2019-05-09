/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

//import controllers.RegionController;
//import daos.RegionDAO;
//import icontrollers.IRegionController;
//import idaos.IRegionDAO;
//import daos.EmployeeDAO;
import controllers.EmployeeController;
import controllers.SessLoginController;
import controllers.UserManagementController;
import daos.UserManagementDAO;
import icontrollers.IEmployeeController;
import icontrollers.ISessLoginController;
import icontrollers.IUserManagementController;
import idaos.IUserManagementDAO;
//import idaos.IEmployeeDAO;
//import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.Employee;
import models.UserManagement;
import views.LoginView;
//import models.Employee;
import views.MainFrame;

/**
 *
 * @author Okala
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        // TODO code application logic here
        DBConnection connection = new DBConnection();
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        IEmployeeDAO iedao = new EmployeeDAO(connection.getConnection());
//        IRegionController irc = new RegionController(connection.getConnection());
//
//        System.out.println(islc.getById("okalanang13@gmail.com", "admin"));
//        System.out.println(islc.login("okalanang13@gmail.com", "admin"));
        
//        IUserManagementController iumc = new UserManagementController(connection.getConnection());
//        System.out.println(iumc.register("okalanang", "admin"));
//        System.out.println(iumc.register("okalanang", "admssss"));
//        System.out.println(iumc.login("okalanang", "admin"));
//        System.out.println(iumc.login("okalanang", "admssss"));
        
//        IUserManagementDAO iumdao = new UserManagementDAO(connection.getConnection());
//        System.out.println((iumdao.getData(new UserManagement("Remi", ""))).get(0).getPassword());
//        
//        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Check Connection
//        System.out.println(connection.getConnection());
        
//        Pattern p = Pattern.compile("-");
//        Matcher m = p.matcher("a123b - test");
//        System.out.println(m.find());
//        System.out.println(m.matches());
//        String myString = "GDSHKG - db";
//        String newString = myString.substring(0, myString.indexOf("-"));
//        System.out.println(myString);
//        System.out.println(newString);
//        System.out.println(newString.length());

//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
        LoginView view = new LoginView();
        view.setVisible(true);

        
        //DAO
        //Insert
//        Region region = new Region(111, "NamaSaya");
//        System.out.println(irdao.insert(region));
//        String myDate = "15/02/2019";
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = df.parse(myDate);
//        System.out.println(date);
//        System.out.println(date.getTime());
//        System.out.println(new java.sql.Date(date.getTime()));
        
//        
//        Employee employee = new Employee(208, "Fredi", "Margianto", "fredi@gmail.com", "08272", new Date(date.getTime()), "PR_REP", 9000, 0.01, 101, 110);
//        System.out.println(iedao.insert(employee));

        //View
//        for (Region region : irdao.getAll()) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
//        
//        for (Region region : irdao.getById(1)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }

        //Update
//        Region region = new Region(111, "Oka Lanang Akbar");
//        System.out.println(irdao.update(region));

        //Delete
//        System.out.println(icr.delete("111"));
        
        //Search
//        System.out.println(irdao.search("eu"));
    }
}
