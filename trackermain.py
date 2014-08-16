from sys import argv
import time

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

starttime = time.time()

print "How does it hurt? ache, fever, chills "
extrinsicsymptom = raw_input() 

if extrinsicsymptom == "fever":
    print "What is your temperature?"
    extrinsicintensity = raw_input()
    for b in range (0, 10):
        intensity = 96 + float(b) * 10 
        intrinsicintensity.append(intensity)

    
else:
    print "On a scale of 1-10 how severe is your %s ?" % extrinsicsymptom
    extrinsicintensity = raw_input()
    for b in range (0, 10):
        intensity = b
        intrinsicintensity.append(intensity)

print "has this ended yet?"
ended = raw_input()
if ended == "yes":
    duration = time.time()-starttime
print duration," s"

print "INSERT INTO user (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"')"
