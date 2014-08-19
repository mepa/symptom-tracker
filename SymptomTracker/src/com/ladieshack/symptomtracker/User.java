package com.ladieshack.symptomtracker;

import java.util.Date;
 
public class User {
 
    private int user_id;
    private Date dob;
 
    // Empty constructor
    public User(){}
 
    // constructor
    public User(int user_id, Date dob) {
        super();
        this.user_id = user_id;
        this.dob = dob;
    }
 
    //getters & setters

     
    // getting user id
    public int getUserID(){
        return this.user_id;
    }
     
    // setting user id
    public void setUserID(int user_id){
        this.user_id = user_id;
    }
     
    // getting dob
    public Date getDOB(){
        return this.dob;
    }
     
    // setting dob
    public void setDOB(Date dob){
        this.dob = dob;
    }
     
 
    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", dob=" + dob + "]";
    }
}