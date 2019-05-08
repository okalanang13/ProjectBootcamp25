/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author Okala
 */
public class Main {
    
    public static void main(String[] args){
          //put your code inside this method
          String password = "okalanang";
          String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
          System.out.println(BCrypt.hashpw(password, "$2a$10$x8R1UrMk1QEmSFHjptANhe"));
          System.out.println(BCrypt.hashpw(password, "$2a$10$x8R1UrMk1QEmSFHjptANhe"));
          System.out.println(BCrypt.hashpw(password, "$2a$10$x8R1UrMk1QEmSFHjptANhe"));
          System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
          System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
          System.out.println((BCrypt.hashpw(password, BCrypt.gensalt())).length());
          System.out.println(BCrypt.gensalt());
          System.out.println(BCrypt.checkpw(password, hashed));
          
    }
}
