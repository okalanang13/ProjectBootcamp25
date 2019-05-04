/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.RegionController;
import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
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
         List<Region> act = irc.getAll();
         Assert.assertNotNull(act);
     }
     
     public void testGetById() {
         List<Region> act2 = irc.getById("1");
         Assert.assertNotNull(act2);
     }
     
     public void testSearch() {
         List<Region> act3;
         act3 = irc.search("1");
         Assert.assertNotNull(act3);
     }
     
     public void testInsert(){
         irc.insert("111", "NamaSaya");
         List<Region> regions = irc.getById("111");
         Assert.assertEquals("111", regions.get(0).getId());
         Assert.assertEquals("NamaSaya", regions.get(0).getName());
     }

     public void testUpdate(){
         irc.insert("111", "NamaSayaIni");
         List<Region> regions = irc.getById("111");
         Assert.assertEquals("111", regions.get(0).getId());
         Assert.assertEquals("NamaSaya", regions.get(0).getName());
     }
     
     public void testDelete(){
         irc.delete("111");
         Assert.assertNotNull(irc.getById("111"));
     }
}
