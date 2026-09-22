# Student Academic Management System

An in-memory academic management system built with JavaFX and the Java Collections Framework. This project demonstrates efficient data management, custom object equality, sorting, and a graphical user interface (GUI) without relying on a traditional database.

## Project Overview

This system was developed as part of a Software Engineering module to manage student registrations and academic analytics entirely in memory. It features a JavaFX graphical interface that allows users to add, search, view, and delete student records. The backend is engineered using appropriate Java Collections to ensure fast retrieval, prevent duplicate entries, and maintain data integrity.

## Tech Stack

- **Language:** Java
- **GUI:** JavaFX (FXML, Controllers)
- **Data Structures:** Java Collections Framework (`HashMap`, `HashSet`, `ArrayList`)
- **Sorting:** Custom `Comparator` implementations
- **IDE:** NetBeans

## Key Features

- **Student Registration:** Add new students with unique IDs via a JavaFX GUI.
- **Search & Retrieve:** Fast O(1) student lookup by ID.
- **Delete Records:** Remove students from the system.
- **Duplicate Prevention:** Prevents duplicate student records and enrollments.
- **Live Sorting & Display:** Automatically sorts and displays the student list alphabetically in the UI.
- **Course Enrollment Logic:** Backend logic prepared to enroll students into courses and track statistics.
- **User Feedback:** GUI Alert dialogs for successful operations and error handling (e.g., invalid ID format).

## Architecture & Code Structure

The project follows the **Model-View-Controller (MVC)** architectural pattern to ensure a clean separation of concerns:

| File                                                      | Role                                                                                                              |
| --------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `Student.java`                     | **Model:** Represents the student entity. Includes encapsulated fields, overridden `equals()` and `hashCode()` based on `studentID` (crucial for preventing duplicates in collections), and a formatted `toString()`. |
| `AcademicManager.java`             | **Logic/Controller:** Manages the core data structures. Uses `HashMap` for fast student lookup and `HashMap<String, Set<Student>>` to manage course enrollments without duplicates. |
| `StudentManagerApp.java`           | **Entry Point:** The JavaFX `Application` class that launches the GUI. |
| `StudentManagerUI.fxml`            | **View:** The FXML layout file defining the UI components (TextFields, Buttons, ListView). |
| `StudentManagerUIController.java`  | **UI Controller:** Handles user interactions, binds data to the `ListView` using `ObservableList`, and manages input validation. |

## Engineering Highlights

- **Efficient Retrieval:** Used `HashMap` in `AcademicManager` for constant-time (O(1)) student lookup by ID.
- **Data Integrity:** Overrode `equals()` and `hashCode()` in the `Student` class based on `studentID`. This ensures that `HashSet` correctly prevents duplicate course enrollments.
- **JavaFX Data Binding:** Utilized `ObservableList` in the controller to automatically update the `ListView` when data changes, rather than manually refreshing the UI.
- **Robust Validation:** Implemented `NumberFormatException` handling to ensure the student ID is a valid number before processing.
- **Clean UI Logic:** Used JavaFX `Alert` dialogs to provide clear, user-friendly feedback for errors and successful operations.

## What I Learned

- Applying Object-Oriented Programming (OOP) principles to build a scalable Java application.
- Mastering the Java Collections Framework (choosing between `Map`, `Set`, and `List`).
- Understanding the importance of `equals()` and `hashCode()` when using hash-based collections.
- Building a responsive GUI with JavaFX and FXML, and using the MVC pattern.
- Implementing sorting and filtering logic using custom Comparators.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/GRJuniorselemela-se/student-academic-management-system.git
   ```
2. Open the project in NetBeans (or any Java IDE).
3. Ensure you have the JavaFX SDK configured in your IDE (NetBeans typically handles this automatically).
4. Locate and run the main class: `StudentManagerApp.java`.
5. The application will launch. Three sample students are pre-loaded for demonstration.

## Future Improvements

- Database Integration: Transition from in-memory storage to a relational database (MySQL) using JDBC for persistent data storage.
- Complete Course Enrollment UI: Expand the FXML and Controller to fully expose the `enrollStudent` and `displayCourseStatistics` methods on the GUI.
- Update Feature: Add the ability to edit and update existing student details.
- Unit Testing: Implement JUnit tests for the `AcademicManager` logic to ensure data integrity.

## Academic Context

- Developed during Programming in Java (ITJVA2) as part of a second-year Software Engineering curriculum.

## Author

**Gomolemo Reggy Junior Selemela**

Software Engineering Student | Aspiring Software Developer/ Software Engineer (Java)
- **GitHub:** [github.com/GRJuniorselemela-se](https://github.com/GRJuniorselemela-se)
- **LinkedIn:** [linkedin.com/in/grjunior-selemela](https://www.linkedin.com/in/grjunior-selemela)
- **Email:** [juniorselemela@gmail.com](mailto:juniorselemela@gmail.com)
