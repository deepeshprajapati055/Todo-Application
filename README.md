# Todo Application

A Spring Boot-based Todo Application that helps you manage your daily tasks efficiently.

## Features

- Create new todo tasks with title, date, and time
- View all todo tasks in a clean interface
- Update existing todo tasks
- Mark tasks as complete
- Delete tasks
- Responsive web interface

## Technologies Used

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf Template Engine
- HTML/CSS
- Maven
- MySQL Database

## Prerequisites

- Java 8 or higher
- Maven
- MySQL Server

## Setup and Installation

1. Clone the repository:
```bash
git clone https://github.com/deepeshprajapati055/Todo-Application.git
```

2. Configure MySQL database:
   - Create a new database
   - Update `application.properties` with your database credentials

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start running on `http://localhost:8080`

## Usage

1. **Adding a Todo**:
   - Click on "Add Todo" button
   - Fill in the task details (title, date, time)
   - Click "Save"

2. **Updating a Todo**:
   - Click on the "Edit" button next to the todo
   - Modify the details
   - Click "Update"

3. **Completing a Todo**:
   - Click on the "Complete" button to mark a task as done

4. **Deleting a Todo**:
   - Click on the "Delete" button to remove a task

## Project Structure

- `src/main/java/com/todo/controller`: Contains the MVC controllers
- `src/main/java/com/todo/model`: Data models
- `src/main/java/com/todo/service`: Service layer implementations
- `src/main/java/com/todo/repository`: Database repositories
- `src/main/resources/templates`: Thymeleaf templates
- `src/main/resources/static`: Static resources (CSS, JS)

## Contributing

Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

