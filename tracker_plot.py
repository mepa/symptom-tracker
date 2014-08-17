from sys import argv
import time
import datetime
import os
import sqlite3 as lite
import sys
import pylab as pl

script, bodypartf, symptomf = argv
txt1 = open(bodypartf)
txt2 = open(symptomf)
eachline1 = txt1.readlines()
eachline2 = txt2.readlines()
i = len(eachline1)
j = len(eachline2)


intrinsicappendage = []
intrinsicsymptom = []
intrinsicintensity = []
intrinsictemperature = []

print "What's your name?"
username = raw_input()
print "Date of birth? YYYY-MM-DD"
dateofbirth = raw_input()

for b in range (0, i):
    body = eachline1[b]
    body = body.replace("\n","")
    intrinsicappendage.append(body)

for b in range (0, j):
    symptom = eachline2[b]
    symptom = symptom.replace("\n","")
    intrinsicsymptom.append(body)

print "Where does it hurt?"
extrinsicbodypart = raw_input()



starttimecomputer = time.time()
startdate = datetime.datetime.now().date()
startdate = str(startdate)
starttime = datetime.datetime.now().time()
print starttime

print "How does it hurt? ache, chills "
extrinsicsymptom = raw_input() 


print "What is your temperature?"
extrinsictemperature = raw_input()
for b in range (0, 10):
    temperature = 96 + float(b) * 10 
    intrinsictemperature.append(temperature)


print "On a scale of 1-10 how severe is your %s ?" % extrinsicsymptom
extrinsicintensity = raw_input()
for b in range (0, 10):
    intensity = b
    intrinsicintensity.append(intensity)

print "has this ended yet? yes/no"
ended = raw_input()
if ended == "yes":
    duration = time.time()-starttimecomputer
    endtime = datetime.datetime.now().time()
else:
    duration = time.time()-starttimecomputer
    endtime = datetime.datetime.now().time()


enddate = datetime.datetime.now().date()
enddate = str(enddate)
duration = str(duration)

starttime = str(starttime)
endtime = str(endtime)
extrinsicintensity = str(extrinsicintensity)

if 'extrinsictemperature' in locals():
    extrinsictemperature = str(extrinsictemperature)
else:
    extrinsictemperature = 98.66
extrinsictemperature = str(extrinsictemperature)



#outputfile1.write("INSERT INTO userx (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"');")

#outputfile2.write("INSERT INTO event (user_id, start_date,
#start_time, end_date, end_time, duration, body_part, symptom,
#intensity, temperature) SELECT user_id,
#"+startdate+",'"+starttime+"',"+enddate+",'"+endtime+"',"+duration+",'"+extrinsicbodypart+"','"+extrinsicsymptom+"',"+extrinsicintensity+","+extrinsictemperature+"
#FROM userx WHERE userx.firstname = '"+username+"';")

#os.system("rm *.db")

checkfordb = os.system("ls sym-track.db")



con = lite.connect('sym-track.db')
with con:
    cur = con.cursor()
    if checkfordb > 0:
        print 'making a new database sym-track.db'
        cur.execute("CREATE TABLE userx(user_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, firstname VARCHAR, dob DATE)")
        cur.execute("CREATE TABLE event( event_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, user_id INTEGER, start_date DATE, start_time VARCHAR, end_date DATE, end_time VARCHAR, duration FLOAT, body_part VARCHAR, symptom VARCHAR, intensity INTEGER, temperature FLOAT)")

    cur.execute("INSERT INTO userx (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"')")
    cur.execute("INSERT INTO event (user_id, start_date, start_time, end_date, end_time, duration, body_part, symptom, intensity, temperature)  SELECT user_id, "+startdate+",'"+starttime+"',"+enddate+",'"+endtime+"',"+duration+",'"+extrinsicbodypart+"','"+extrinsicsymptom+"',"+extrinsicintensity+","+extrinsictemperature+" FROM userx WHERE userx.firstname = '"+username+"'")

    startdate_db = cur.execute("SELECT start_date from event")
    intensity_db = cur.execute("SELECT intensity from event")

startdate_db = float(startdate_db.replace("|", " "))
intensity_db = float(intensity_db.replace("|", " "))

pl.plot(startdate_db, intensity_db)
