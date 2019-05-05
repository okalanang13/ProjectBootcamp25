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
import views.MainFrame;

/**
 *
 * @author Okala
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        DBConnection connection = new DBConnection();
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        IRegionController icr = new RegionController(connection.getConnection());
        
        //Check Connection
//        System.out.println(connection.getConnection());
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
        //DAO
        //Insert
//        Region region = new Region(111, "NamaSaya");
//        System.out.println(irdao.insert(region));

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
