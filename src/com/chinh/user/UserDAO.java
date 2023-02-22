/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.user;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.chinh.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDTO login(String userID, String password) throws NoSuchAlgorithmException {
        String sql = " select userID, fullName, password, status\n"
                + " from TblUsers\n"
                + " where userID = ? and password = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1).trim();
                String fullName = rs.getString(2).trim();
                String pass = rs.getString(3).trim();
                boolean status = rs.getBoolean(4);
                return new UserDTO(id, fullName, pass, status);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            UserDAO udao = new UserDAO();
            System.out.println(udao.login("SE140506", "123456"));
        } catch (Exception e) {
        }
    }
}
