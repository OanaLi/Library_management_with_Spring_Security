# HOW TO SET UP THE APP

1. Create the database locally.
2. Update the `url`, `username`, and `password` inside `src/main/resources/application.properties` with the corresponding values.
3. Run the Java app to populate the database with the required tables.
4. Execute the following SQL statements to insert initial data:

    ```sql
    INSERT INTO roles(id, role) VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'DEVELOPER');
    
    INSERT INTO users(username, email_address, first_name, last_name, password) VALUES 
    ('Admin', 'admin@admin.com', 'Admin', 'Admin', '$2a$10$FVvZNPIIP3taMKdQqwwWsejbiH1DpT/0/PbBS933b73JewnHag6hK');
    
    INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1);
    ```

5. Run the app again and access `http://localhost:8080` in your browser. Now you're ready to go!


# HOW THE APP WORKS

There are two types of users: **Administrator** and **User**.

As a **User**, you can:
  - View the existing book collection.
  - See your personal data.
  - Create a user account by registering.

As an **Administrator**, you can:
  - Perform all actions a User can do.
  - Add new books.
  - Delete books.
  - See all user accounts.

**Admin login credentials**: Username = `Admin`, Password = `Admin!1234`

This project uses **Spring Boot** for the backend and **Thymeleaf** for the frontend (web interface).


# TECHNOLOGIES

- Java 17
- Spring Boot
- Thymeleaf
- Bootstrap
- MySQL Database
