package com.ladieshack.symptomtracker;

import java.util.Date;

public class Symptom {

	public int user_id;
	public Date start_date_time;
	public Date end_date_time;
	public int duration;
	public String body_part;
	public String symptom;
	public int intensity;
	public double temperature;
	
	public Symptom() {
		
	}
	
	public Symptom(int user_id, Date start_date_time, Date end_date_time, int duration, String body_part, String symptom, int intensity, double temperature) {
		this.user_id = user_id;
		this.start_date_time = start_date_time;
		this.end_date_time = end_date_time;
		this.duration = duration;
		this.body_part = body_part;
		this.symptom = symptom;
		this.intensity = intensity;
		this.temperature = temperature;
	}
}
