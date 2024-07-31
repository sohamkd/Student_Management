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

 * JWT Token Generation           

  ![http___localhost_8080_auth_login - My Workspace 7_31_2024 9_35_57 PM](https://github.com/user-attachments/assets/e443e778-8c6d-484c-8253-e612d465f5fa)

  * Passing the token to get access of apis
    
   ![http___localhost_8080_auth_login - My Workspace 7_31_2024 9_56_50 PM](https://github.com/user-attachments/assets/373ca1b4-da07-450d-9cbb-32c2dbe8ba70)

 * Creating Student
   
    ![http___localhost_8080_students - My Workspace 7_31_2024 10_00_13 PM](https://github.com/user-attachments/assets/68d08a44-4bad-44b7-892d-fbc10e80e717)

* Creating subject

    ![http___localhost_8080_subject - My Workspace 7_31_2024 10_02_05 PM](https://github.com/user-attachments/assets/6701a659-6118-4898-9700-9ed2d524cb11)

 * Retrieving all students

   ![http___localhost_8080_students - My Workspace 7_31_2024 10_04_14 PM](https://github.com/user-attachments/assets/4ed6fc53-4318-4f56-9c97-796bd453ce60)

 *  Retrieving all subjects

    ![http___localhost_8080_subject - My Workspace 7_31_2024 10_06_02 PM](https://github.com/user-attachments/assets/03283b05-df7f-4d79-8f13-eafc12ab30ae)

* assigning subjects to student

  ![http___localhost_8080_students_2ff74df2-e120-4b96-b198-ea3c12f18a3e_subjects_8d0d8c72-3796-44d0-bdc2-b497af914eed - My Workspace 7_31_2024 10_08_19 PM](https://github.com/user-attachments/assets/cbeb309d-b2ee-490b-8812-8d748c8dfd40)
