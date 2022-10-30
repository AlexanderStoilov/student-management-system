## 1. Info

Като цяло много ме е яд, защото с html-ите ги бях докарал нещата, но се наложи да ги отстраня от работата, за да се тества през Postman, както разбрах, че се изисквало, при което сега имам някои проблеми с login-а - той ми работеше през html-а и оттам си получавах token-ите. А сега през постман има неточности при връзката с JwtUsernameAndPasswordAuthenticationFilter.

За целта, ако ти искаш да тестваш, ето ти този Bearer Token с админски права, който изтича на 6-ти август, за да не се занимаваш да си правиш такъв ръчно:

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiY291cnNlOnNlZV9hdmVyYWdlX2dyYWRlIn0seyJhdXRob3JpdHkiOiJ1c2VyOmNoYW5nZV9yb2xlIn0seyJhdXRob3JpdHkiOiJzdHVkZW50OmFkZF9ncmFkZSJ9LHsiYXV0aG9yaXR5Ijoic3R1ZGVudDpzZWVfYXZlcmFnZV9ncmFkZSJ9LHsiYXV0aG9yaXR5IjoiY291cnNlOnNlZV9hbGxfaW5mbyJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiY291cnNlOmFkZF9zdHVkZW50In0seyJhdXRob3JpdHkiOiJjb3Vyc2U6YWRkX3RlYWNoZXIifV0sImlhdCI6MTY1ODU5NjM4MywiZXhwIjoxNjU5NzMzMjAwfQ.OfQdy1f-jqqF4g7tCgXeXEBSSoYj9jeAGDeLFjA-9zEE8k_M3GT4o_M_2FIqyJNB503z4cKzI6wpM66iQJjDJA

Копваш това, отиваш на Postman, 
избираш Bearer Token от менюто за Authorization, вкарваш това (със Bearer префикса и спейса) и това е.

---

## 2. Instructions

The following commands are supported:

---
#### USERS

1. "localhost:8080/users/all" [GET] - shows all users in a JSON

2. "localhost:8080/registration" [POST] - receives a User body and registers the user

3. localhost:8080/login [POST]

---
#### STUDENTS

1. "localhost:8080/api/v1/students/add_student" => receives a Student obj as a body and adds it to the database.

2. "localhost:8080/api/v1/students/{studentId}/{courseId}/add_grade/{grade}" => adds a grade with a value 'grade' to the
   student with '
   studentId' in the course with 'CourseId'

3. "localhost:8080/api/v1/students/{studentId}/avg_grade"

4. "localhost:8080/api/v1/students/all"

5. "localhost:8080/api/v1/students/{studentId}"

6. "localhost:8080/api/v1/students/{studentSeqId}/uuid"

---
#### COURSES

1. "localhost:8080/api/v1/courses/add_course"

2. "localhost:8080/api/v1/courses/add_course"

3. "localhost:8080/api/v1/courses/{courseId}/add_teacher/{teacherId}"

4. "localhost:8080/api/v1/courses/{courseId}/add_student/{studentId}"

5. "localhost:8080/api/v1/courses/{courseId}/students"

6. "localhost:8080/api/v1/courses/{courseId}/students/ord"

7. "localhost:8080/api/v1/courses/{courseId}/avg_grades"

8. "localhost:8080/api/v1/courses/all"

9. "localhost:8080/api/v1/courses/{courseId}"

10. "localhost:8080/api/v1/courses/{courseId}/teacher"

11. "localhost:8080/api/v1/courses/{courseId}/uuid"

---
#### TEACHERS

1. "localhost:8080/api/v1/teachers/add_teacher"

2. "localhost:8080/api/v1/teachers/all"

3. "localhost:8080/api/v1/teachers/{teacherId}"

4. "localhost:8080/api/v1/teachers/{teacherId}/uuid"

---

