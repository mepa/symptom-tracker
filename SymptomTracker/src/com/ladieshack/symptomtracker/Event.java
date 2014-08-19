package com.ladieshack.symptomtracker;

import java.util.Date;

public class Event {
 
    private int event_id;
    private int user_id;
	private Date start_datetime;
	private Date end_datetime;
	private float duration;
	private String body_part;
	private String symptom;
	private int intensity;
	private float temperature;
 
    public Event(){}
 
    public Event( int event_id, 
    		int user_id, 
    		Date start_datetime, 
    		Date end_datetime, 
    		float duration, 
    		String body_part, 
    		String symptom, 
    		int intensity, 
    		float temperature) {
        super();
        this.event_id = event_id; 
		this.user_id = user_id;
		this.start_datetime = start_datetime;
		this.end_datetime = end_datetime;
		this.duration = duration;
		this.body_part = body_part;
		this.symptom = symptom;
		this.intensity = intensity;
		this.temperature = temperature;
    }
 
    //getters & setters
    
    // getting event id
    public int getEventId() {
        return this.event_id;
      }
    
    // setting event id
    public void setEventID(int event_id){
        this.event_id = event_id;
    }
    
    // getting user id
    public int getUserID() {
        return this.user_id;
      }
    
    // setting user id
    public void setUserID(int user_id){
        this.user_id = user_id;
    }
     
    // getting start_datetime
    public Date getStartDatetime(){
        return this.start_datetime;
    }
     
    // setting start_datetime
    public void setStartDatetime(Date start_datetime){
        this.start_datetime = start_datetime;
    }
    
    // getting end_datetime
    public Date getEndDatetime(){
        return this.end_datetime;
    }
     
    // setting end_datetime
    public void setEndDatetime(Date end_datetime){
        this.end_datetime = end_datetime;
    }
    
    // getting duration
    public float getDuration(){
        return this.duration;
    }
     
    // setting duration
    public void setDuration(float duration){
        this.duration = duration;
    }
    
    // getting body part
    public String getBodyPart(){
        return this.body_part;
    }
     
    // setting body part
    public void setBodyPart(String body_part){
        this.body_part = body_part;
    } 
    
    // getting symptom
    public String getSymptom(){
        return this.symptom;
    }
     
    // setting symptom
    public void setSymptom(String symptom){
        this.symptom = symptom;
    } 
    
    // getting intensity
    public int getIntensity() {
        return this.intensity;
      }
    
    // setting intensity
    public void setIntensity(int intensity){
        this.intensity = intensity;
    }
    
    // getting temperature
    public float getTemperature(){
        return this.temperature;
    }
     
    // setting temperature
    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

 
    @Override
    public String toString() {
        return "Event [event_id=" + event_id + ", " +
        		"user_id=" + user_id + ", " +
        		"start_datetime=" + start_datetime + "," +
        		"end_datetime=" + end_datetime + "," +
        		"duration=" + duration + "," +
        		"body_part=" + body_part + "," +
        		"symptom=" + symptom + "," +
        		"intensity=" + intensity + "," +
        		"temperature=" + temperature + "]";

    }
}