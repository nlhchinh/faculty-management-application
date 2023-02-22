/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.lecturer;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class LecturerDTO {

    private String lecturerID;
    private String lecturerName;
    private Date birthday;
    private boolean gender;
    private String image;
    private String ethnic;
    private String religion;
    private String nationality;
    private String address;
    private String subject;
    private String facultyID;
    private byte[] imageByte;
    private String cmbName;

    public LecturerDTO() {
    }

    public LecturerDTO(String lecturerID, String lecturerName, Date birthday, boolean gender, String image, String ethnic, String religion, String nationality, String address, String subject, String facultyID) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturerName;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
        this.ethnic = ethnic;
        this.religion = religion;
        this.nationality = nationality;
        this.address = address;
        this.subject = subject;
        this.facultyID = facultyID;
    }

    public LecturerDTO(String lecturerID, String lecturerName, Date birthday, boolean gender, String ethnic, String religion, String nationality, String address, String subject, String facultyID, byte[] imageByte) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturerName;
        this.birthday = birthday;
        this.gender = gender;
        this.ethnic = ethnic;
        this.religion = religion;
        this.nationality = nationality;
        this.address = address;
        this.subject = subject;
        this.facultyID = facultyID;
        this.imageByte = imageByte;
    }

    public LecturerDTO(String cmbName) {
        this.cmbName = cmbName;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    public String getCmbName() {
        return cmbName;
    }

    public void setCmbName(String cmbName) {
        this.cmbName = cmbName;
    }

    @Override
    public String toString() {
        return "LecturerDTO{" + "lecturerID=" + lecturerID + ", lecturerName=" + lecturerName + ", birthday=" + birthday + ", gender=" + gender + ", image=" + image + ", ethnic=" + ethnic + ", religion=" + religion + ", nationality=" + nationality + ", address=" + address + ", subject=" + subject + ", facultyID=" + facultyID + ", imageByte=" + imageByte + ", cmbName=" + cmbName + '}' + "\n";
    }
}
