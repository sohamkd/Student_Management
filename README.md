# Student_Management

* Not able to do the Jwt role based authentication but we performed the authentication by providing hardcoded username and password.
* So the username and password is not coming from databse. 

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

  ![http___localhost_8080_auth_login - My Workspace 7_31_2024 9_35_57 PM](https://github.com/user-attachments/assets/e443e778-8c6d-484c-8253-e612d465f5fa)
