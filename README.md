# Java Backend Test
By Wesarut Khumwilai (wesarut.khm@gmail.com)

## Objective
For recruitment test.


## Project Arrangement

    git clone --branch=backend-test-for-job-interview git@github.com:anubissmile/SpringBootUserRegistration.git
    
## Database MySQL
You can see file docker-compose.yml

    docker-compose up -d

## API Documentation
Import ***Postman*** shared collection link below.
[https://www.getpostman.com/collections/9a78d5cbc3210031f45b](https://www.getpostman.com/collections/9a78d5cbc3210031f45b)

## ***Authentication***

Authenticate as super user. 
	
***Endpoint***
[http://127.0.0.1:2534/registration/api/authenticate](http://127.0.0.1:2534/registration/api/authenticate)

***Method***
POST

***Body Request***

    {"username":  "tempuser","password":  "1234"}

***Body Response***

    {"jwt":  "JWT_TOKEN"}


## Create User

***Endpoint***
[http://127.0.0.1:2534/registration/api/user/v1](http://127.0.0.1:2534/registration/api/user/v1)

***Method***
POST

***Header***
**Authorization** : Bearer JWT_TOKEN

***Body Request***

    {"username":  "Wesarut","telephone":  "0831601307","address":  "Samutsakon","salary":  50001,"password":  "Temp1234"}

***Body Response***

    {"status":{"message":"Create user success!","status":201},"data":{"username":"Wesarut","telephone":"0831601307","address":"Samutsakon","salary":50001.0,"memberType":"PLATINUM","registrationCode":"202108111307","createdAt":"2021-08-10T21:32:57.184+00:00","updateAt":"2021-08-10T21:32:57.184+00:00"}}
