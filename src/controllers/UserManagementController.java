/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserManagementDAO;
import icontrollers.IUserManagementController;
import idaos.IUserManagementDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import models.Session;
import models.UserManagement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Okala
 */
public class UserManagementController implements IUserManagementController {

    private final IUserManagementDAO iumdao;

    public UserManagementController(Connection connection) {
        iumdao = new UserManagementDAO(connection);
    }

    @Override
    public List<UserManagement> getAll() {
        return iumdao.getData(new UserManagement("", ""), false);
    }

    @Override
    public List<UserManagement> getByUsername(String username) {
        return iumdao.getData(new UserManagement(username, ""), true);
    }

    @Override
    public String login(String username, String password) {
        String result = "Maaf username atau password Anda salah.";
        boolean existData = false;
        List<UserManagement> lAll = getAll();
        List<UserManagement> lUser = getByUsername(username);

        if (username.isEmpty()) {
            result = "Username kosong belum terisi.";
        } else {
            if (password.isEmpty()) {
                result = "Password kosong belum terisi.";
            } else {
                for (int i = 0; i < lAll.size(); i++) {
                    if (username.equals(lAll.get(i).getUsername())) {
                        existData = true;
                    }
                }

                if (existData) {
                    if (BCrypt.checkpw(password, lUser.get(0).getPassword())) {
                        Session.setUsername(username);
                        result = "true";
                    }
                } else {
                    result = "Username tidak terdaftar";
                }
            }
        }
        return result;
    }

    @Override
    public String register(String username, String password, String retypePassword) {
        String result = "Username tidak berhasil disimpan";
        boolean existData = false;
        List<UserManagement> lAll = getAll();
        if (username.isEmpty()) {
            result = "Username kosong belum terisi.";
        } else {
            if (password.isEmpty() || retypePassword.isEmpty()) {
                result = "Password kosong belum terisi.";
            } else {
                for (int i = 0; i < lAll.size(); i++) {
                    if (username.equals(lAll.get(i).getUsername())) {
                        existData = true;
                    }
                }

                if (existData) {
                    result = "Username  tidak tersedia";
                } else {
                    if (password.matches(retypePassword)) {
                        iumdao.save(new UserManagement(username, BCrypt.hashpw(password, BCrypt.gensalt())));
                        result = "true";
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String changeUsername(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String changePassword(String username, String password, String newPassword, String retypePassword) {
        String result = "Password tidak berhasil diubah.";
        List<UserManagement> lUser = getByUsername(username);
        List<UserManagement> lAll = getAll();
        if (password.isEmpty()) {
            result = "Password lama kosong belum terisi.";
        } else {
            if (newPassword.isEmpty() || retypePassword.isEmpty()) {
                result = "Password baru atau Retype password kosong belum terisi";
            } else {
                if (BCrypt.checkpw(password, lUser.get(0).getPassword())) {
                    if (newPassword.equals(retypePassword)) {
                        iumdao.save(new UserManagement(Session.getUsername(), BCrypt.hashpw(newPassword, BCrypt.gensalt())));
                        result = "true";
                    } else {
                        result = "Password baru yang Anda masukkan tidak sama.";
                    }
                } else {
                    result = "Password lama yang Anda masukkan salah.";
                }
            }
        }
        return result;
    }

    @Override
    public String removeAccount(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
