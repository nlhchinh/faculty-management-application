/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.falcuty;

/**
 *
 * @author Admin
 */
public class FacultyDTO {
    private String facultyID;
    private String facultyName;
    private String location;
    private String cellphone;

    public FacultyDTO() {
    }

    public FacultyDTO(String facultyID, String facultyName, String location, String cellphone) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.location = location;
        this.cellphone = cellphone;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "FacultyDTO{" + "facultyID=" + facultyID + ", facultyName=" + facultyName + ", location=" + location + ", cellphone=" + cellphone + '}' + '\n';
    }
    
    
}
