# Student Academic Management System

An advanced **in-memory** academic management system built with the Java Collections Framework. This project demonstrates efficient data management, sorting, filtering, and reporting without relying on a traditional database.

## Project Overview

This system was developed as part of a Software Engineering module to manage student registrations, course enrollments, and academic analytics entirely in memory. The focus was on selecting the right data structures for performance, ensuring data integrity, and implementing clean, modular Java code.

## Tech Stack

- **Language:** Java  
- **Data Structures:** Java Collections Framework (`HashMap`, `ArrayList`, `TreeSet`, `HashSet`)  
- **Sorting:** Custom `Comparator` implementations  
- **IDE:** NetBeans  

## Key Features

- **Student Registration** – Add new students with unique IDs  
- **Course Enrollment** – Enroll students into available courses  
- **Duplicate Prevention** – Prevent duplicate student records and enrollments  
- **Fast Retrieval** – O(1) student lookup by ID using `HashMap`  
- **Sorting & Filtering** – Sort students by name, ID, or course using custom Comparators  
- **Report Generation**:
  - Students per course
  - Courses per student
  - Sorted student lists

## Engineering Highlights

- Used `HashMap` for constant-time student lookup by ID
- Used `TreeSet` and custom `Comparator` implementations for ordered data
- Implemented validation logic to maintain data integrity
- Demonstrated complex data management entirely in-memory

## What I Learned

- How to choose the right collection for a specific problem
- Implementing custom Comparators for flexible sorting
- Designing a clean and modular Java application
- Applying OOP principles (encapsulation, inheritance, polymorphism)
- Managing data integrity without a database

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/GRJuniorselemela-se/student-academic-management-system.git
