CREATE TABLE user(user_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, firstname VARCHAR, dob DATE);
CREATE TABLE event(event_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, user_id INTEGER, date DATE, start_time TIME, end_time TIME, body_part VARCHAR, symptom VARCHAR, severity INTEGER, temperature FLOAT);
