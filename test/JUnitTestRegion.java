/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import org.junit.Test;
import tools.DBConnection;
import models.Region;
import org.junit.Assert;

/**
 *
 * @author Okala
 */
public class JUnitTestRegion {
    
    DBConnection connection = new DBConnection();
    IRegionController irc = new RegionController(connection.getConnection());
    
    public JUnitTestRegion() {
    }

     @Test
     public void testGetAll(){
         List<Region> act1 = irc.getAll();
         System.out.println(act1);
         Assert.assertNotNull(act1);
     }
     
     @Test
     public void testGetById() {
         List<Region> act2 = irc.getById("1");
         System.out.println(act2);
         Assert.assertNotNull(act2);
     }
     
     @Test
     public void testSearch() {
         List<Region> act3 = irc.search("1");
         System.out.println(act3);
         Assert.assertNotNull(act3);
     }
     
     @Test
     public void testInsert(){
         irc.insert("111", "NamaSaya");
         List<Region> region = irc.getById("111");
         Assert.assertEquals(111, region.get(0).getId());
         Assert.assertEquals("NamaSaya", region.get(0).getName());
     }

     @Test
     public void testUpdate(){
         irc.insert("111", "NamaSayaIni");
         List<Region> region = irc.getById("111");
         Assert.assertEquals(111, region.get(0).getId());
         Assert.assertEquals("NamaSaya", region.get(0).getName());
     }
     
     @Test
     public void testDelete(){
         irc.delete("111");
         Assert.assertNotNull(irc.getById("111"));
     }
}
