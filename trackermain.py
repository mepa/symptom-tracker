from sys import argv
import time
import datetime

outputfile1 = open('userinfo.sql','w')
outputfile2 = open('eventinfo.sql','w')

outputfile1.write("BEGIN TRANSACTION;\n")
outputfile1.write(" ")
outputfile2.write("BEGIN TRANSACTION;\n")
outputfile2.write(" ")

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
print "How does it hurt? ache, fever, chills "
extrinsicsymptom = raw_input() 

if extrinsicsymptom == 'fever':
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

print "has this ended yet?"
ended = raw_input()
if ended == "yes":
    duration = time.time()-starttimecomputer
    endtime = datetime.datetime.now().time()
#print duration," s"

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

#print "INSERT INTO user (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"')"

#print "INSERT INTO abundance (user_id, date, start_time, end_time, body_part, symptom, severity, temperature) WHERE user.firstname = '"+username+"' SELECT user_id, "+today+","+starttime+","+endtime+","+extrinsicbodypart+","+extrinsicsymptom+","+extrinsicintensity+","+extrinsictemperature

#print type(starttime)
#print type(endtime)
#print type(today)
#print type(extrinsicintensity)
#print type(extrinsictemperature)
#print type(starttime)



outputfile1.write("INSERT INTO userx (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"');")

outputfile2.write("INSERT INTO event (user_id, start_date, start_time, end_date, end_time, duration, body_part, symptom, intensity, temperature)  SELECT user_id, "+startdate+",'"+starttime+"',"+enddate+",'"+endtime+"',"+duration+",'"+extrinsicbodypart+"','"+extrinsicsymptom+"',"+extrinsicintensity+","+extrinsictemperature+" FROM userx WHERE userx.firstname = '"+username+"';")

outputfile1.write("\nCOMMIT TRANSACTION;")
outputfile1.write(" ")
outputfile2.write("\nCOMMIT TRANSACTION;")
outputfile2.write(" ")

#outputfile1 = close('userinfo.sql','w')
#outputfile2 = close('eventinfo.sql','w')
