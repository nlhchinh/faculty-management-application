/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.falcuty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.chinh.utils.DBUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class FacultyDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<FacultyDTO> getAllFaculty() {
        String query = "select facultyID, facultyName, location, cellphone\n"
                + "from TblFaculty";
        try {
            List<FacultyDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FacultyDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public void addNewFaculty(String facultyID, String facultyName, String location, String cellphone) throws NoSuchAlgorithmException {
        String sql = " insert into TblFaculty\n"
                + "values(?, ?, ?, ?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            ps.setString(2, facultyName);
            ps.setString(3, location);
            ps.setString(4, cellphone);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public FacultyDTO existFacultyID(String facultyID) {

        String sql = " select facultyID, facultyName, location, cellphone\n"
                + "from TblFaculty\n"
                + "where facultyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String facultyName = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String cellphone = rs.getString(4).trim();

                return new FacultyDTO(id, facultyName, location, cellphone);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public boolean saveUpdateFaculty(String facultyName, String location, String cellphone, String facultyID) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " update TblFaculty\n"
                        + "set facultyName = ?, location = ?, cellphone = ?\n"
                        + "where facultyID= ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, facultyName);
                ps.setString(2, location);
                ps.setString(3, cellphone);
                ps.setString(4, facultyID.trim());

                int row = ps.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public void deleteFacultyByID(String facultyID) {

        String sql = " delete from TblFaculty\n"
                + "where facultyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public FacultyDTO checkFacultyHaveLecturer(String facultyID) {

        String sql = " select f.facultyID, f.facultyName, f.location, f.cellphone\n"
                + "from (TblFaculty f inner join TblLecturer l on l.facultyID = f.facultyID)\n"
                + "where f.facultyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String facultyName = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String cellphone = rs.getString(4).trim();

                return new FacultyDTO(id, facultyName, location, cellphone);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public FacultyDTO getFacultyByID(String facultyID) {

        String sql = " select facultyID, facultyName, location, cellphone\n"
                + "from TblFaculty\n"
                + "where facultyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String facultyName = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String cellphone = rs.getString(4).trim();

                return new FacultyDTO(id, facultyName, location, cellphone);
            }
        } catch (Exception e) {
        }

        return null;
    }
    
    public FacultyDTO existPhoneNumber(String cellphone) {

        String sql = " select facultyID, facultyName, location, cellphone\n"
                + "from TblFaculty\n"
                + "where cellphone = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cellphone);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String facultyName = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String phone = rs.getString(4).trim();

                return new FacultyDTO(id, facultyName, location, phone);
            }
        } catch (Exception e) {
        }

        return null;
    }
    
    public String getPhoneNumberByFacultyID(String facultyID) {

        String sql = " select cellphone\n"
                + "from TblFaculty\n"
                + "where facultyID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, facultyID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cellphone = rs.getString(1).trim();

                return cellphone;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public String getFacultyNameByID(String facultyName) {
        String query = "select facultyID\n"
                + "from TblFaculty\n"
                + "where facultyName = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, facultyName.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                String facultyID = rs.getString(1);
                return facultyID;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        try {
            FacultyDAO fdao = new FacultyDAO();
//            fdao.addNewFaculty("a","b","c","d");
            System.out.println(fdao.getFacultyNameByID("Finance and Banking"));
        } catch (Exception e) {
        }
    }
}
