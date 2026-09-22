/**
@author Junior
 */
package QUESTION_1;

import java.util.*;

public class AcademicManager {

    private Map<Integer, Student> students;
    private Map<String, Set<Student>> courseEnrollments;

    public AcademicManager() {

        students = new HashMap<>();
        courseEnrollments = new HashMap<>();
    }

    public void addStudent(Student student) {

        if(students.containsKey(student.getStudentID())) {
            System.out.println("Duplicate student.");
        }
        else {
            students.put(student.getStudentID(), student);
            System.out.println("Student added.");
        }
    }

    public void enrollStudent(String courseName, int studentID) {
        
        Student student = students.get(studentID);
        if(student == null) {
            System.out.println("Student not found.");
            return;
        }

        courseEnrollments.putIfAbsent(courseName, new HashSet<>());
        Set<Student> enrolledStudents = courseEnrollments.get(courseName);

        if(enrolledStudents.add(student)) {
            System.out.println(student.getName() + " enrolled in " + courseName);
        } 
        else {
            System.out.println("Duplicate enrollment.");
        }
    }

    public void displaySortedStudents() {

        List<Student> studentList = new ArrayList<>(students.values());
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted Students:");

        for(Student student : studentList) {
            System.out.println(student);
        }
    }

    public void displayCourseStatistics() {

        System.out.println("\nCourse Statistics:");

        for(Map.Entry<String, Set<Student>> entry : courseEnrollments.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size() + " students");
        }
    }
    public Map<Integer, Student> getStudents() {
        return students;
    }
}

    
    

