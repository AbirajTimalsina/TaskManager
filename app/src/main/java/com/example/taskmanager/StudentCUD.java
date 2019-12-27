package com.example.taskmanager;

public class StudentCUD {


    private String Fname;
    private String Lname;
    private String Uname;
    private String Password;
    private String ConPasssword;

    public StudentCUD(String fname,String lname,String uname,String password,String conPasssword){

        this.Fname = fname;
        this.Lname = lname;
        this.Uname = uname;
        this.Password = password;
        this.ConPasssword = conPasssword;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConPasssword() {
        return ConPasssword;
    }

    public void setConPasssword(String conPasssword) {
        ConPasssword = conPasssword;
    }
}
