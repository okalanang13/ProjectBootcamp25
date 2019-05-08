/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.EmployeeController;
import icontrollers.IEmployeeController;
import java.text.ParseException;
import java.util.List;
import models.Employee;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;

/**
 *
 * @author Okala
 */
public class JUnitTestEmployee {
    
    DBConnection connection = new DBConnection();
    IEmployeeController iec = new EmployeeController(connection.getConnection());
    
    public JUnitTestEmployee() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void testGetAll(){
//         List<Employee> act1 = iec.getAll();
//         Assert.assertNotNull(act1);
//     }
//     
//     @Test
//     public void testGetById() {
//         List<Employee> act2 = iec.getById("100");
//         Assert.assertNotNull(act2);
//     }
     
//     @Test
//     public void testSearch() {
//         List<Employee> act3 = iec.search("100");
//         Assert.assertNotNull(act3);
//     }
//     
     @Test
     public void testInsert() throws ParseException{
         iec.insert("208", "Fredi", "Margianto", "fredi@gmail.com", "08272", "2019-02-15", "PR_REP", "900000", "0.01", "101", "110");
         List<Employee> employee = iec.getById("208");
         assertEquals(208, employee.get(0).getId());
         assertEquals("Fredi", employee.get(0).getFirstName());
     }
//
//     @Test
//     public void testUpdate(){
//         iec.update(208, "Oka", "Margianto", "fredi@gmail.com", "08272", new Date(date.getTime()), "PR_REP", 9000, 0.01, 101, 110);
//         List<Employee> region = iec.getById("208");
//         Assert.assertEquals(208, region.get(0).getId());
//         Assert.assertEquals("Oka", region.get(0).getFirstName());
//     }
//     
     @Test
     public void testDelete(){
         iec.delete("208");
         assertEquals("[]", iec.getById("208")+"");
     }
}
