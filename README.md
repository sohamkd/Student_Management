# Student_Management

* Not able to do the Jwt role based authentication but we performed the authentication by providing hardcoded useername and password. 

Instructions to run the project:-

1.After importing the file in any IDE we have to run the main springboot class "StudentManagementApplication".

    Api Endpoints  
    
    Authentication = POST /auth/login
             We have to pass username and password in JSON format.After sending the request for authentication it will generate a JWT token.
             Using this token we can access all the apis.
 
    Student API  : 
            For creating student =  POST /students
            For getting all students  = GET /students
            For assigning subjects to student  = POST /students/studentId}/subjects/{subjectId}

     Subject API   :
            For creating subject  =  POST /subject
            For getting all subjects = GET /subject

  
