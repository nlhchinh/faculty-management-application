/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.lecturer;

import com.chinh.utils.DBUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LecturerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<LecturerDTO> getAllLecturer() {
        String query = "select lecturerID, lecturerName, birthday, gender, image, ethnic, religion, nationality, address, subject, facultyID\n"
                + "from TblLecturer";
        try {
            List<LecturerDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LecturerDTO(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public void addNewLecturer(String lecturerID, String lecturerName, String birthday, String gender, String image,
            String ethnic, String religion, String nationality, String address, String subject, String facultyID) throws NoSuchAlgorithmException {
        String sql = " insert into TblLecturer\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, lecturerID);
            ps.setString(2, lecturerName);
            ps.setString(3, birthday);
            ps.setString(4, gender);
            ps.setString(5, image);
            ps.setString(6, ethnic);
            ps.setString(7, religion);
            ps.setString(8, nationality);
            ps.setString(9, address);
            ps.setString(10, subject);
            ps.setString(11, facultyID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public String existLecturerID(String lecturerID) {

        String sql = " select lecturerID\n"
                + "from TblLecturer\n"
                + "where lecturerID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public String getFacultyIDBySubject(String subject) {

        String sql = " select facultyID\n"
                + "from TblLecturer\n"
                + "where subject = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, subject.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                String facultyID = rs.getString(1);
                return facultyID;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public boolean updateLecturer(String lecturerName, String birthday, String gender, String image,
            String ethnic, String religion, String nationality, String address, String subject, String facultyID, String lecturerID) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " update TblLecturer\n"
                        + "set lecturerName = ?, birthday = ?, gender = ?, image = ?, ethnic = ?, religion = ?, nationality = ?, address = ?, subject = ?, facultyID = ?\n"
                        + "where lecturerID = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, lecturerName);
                ps.setString(2, birthday);
                ps.setString(3, gender);
                ps.setString(4, image);
                ps.setString(5, ethnic);
                ps.setString(6, religion);
                ps.setString(7, nationality);
                ps.setString(8, address);
                ps.setString(9, subject);
                ps.setString(10, facultyID);
                ps.setString(11, lecturerID);

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

    public void deleteLecturerID(String lecturer) {

        String sql = " delete from TblLecturer\n"
                + "where lecturerID = ? ";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, lecturer);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public String getImageEndcodedStringByLecturerID(String lecturerID) {
        String query = "select image\n"
                + "from TblLecturer\n"
                + "where lecturerID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String imageLink = rs.getString(1);
                return imageLink;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<LecturerDTO> getEthnicName() throws SQLException {
        String sql = "select ethnicName\n"
                + "from TblEthic";
        try {
            List<LecturerDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LecturerDTO(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<LecturerDTO> getReligion() throws SQLException {
        String sql = "select religionName\n"
                + "from TblReligion";
        try {
            List<LecturerDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LecturerDTO(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<LecturerDTO> getNationality() throws SQLException {
        String sql = "select nationalityName\n"
                + "from TblNationality";
        try {
            List<LecturerDTO> list = new ArrayList<>();
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LecturerDTO(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            LecturerDAO ldao = new LecturerDAO();
            System.out.println(ldao.getEthnicName());
            System.out.println(ldao.getReligion());
            System.out.println(ldao.getNationality());
        } catch (Exception e) {
        }
    }

}
