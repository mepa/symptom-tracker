CREATE TABLE user(
       user_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, 
       firstname VARCHAR, 
       dob DATE
);


CREATE TABLE event(
       event_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, 
       user_id INTEGER, 
       start_date DATE, 
       start_time VARCHAR,
       end_date DATE, 
       end_time TIME, 
       duration VARCHAR,
       body_part VARCHAR, 
       symptom VARCHAR, 
       intensity INTEGER, 
       temperature FLOAT);
