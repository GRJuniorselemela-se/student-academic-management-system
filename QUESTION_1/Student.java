/**
@author Junior
 */
package QUESTION_1;

import java.util.Objects;

public class Student {
    
    private int studentID;
    private String name;
    
    public Student(int studentID, String name){
        this.studentID = studentID;
        this.name = name;   
    }
    
    public int getStudentID(){
        return studentID;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(studentID);
    }
    
    @Override
    public String toString(){
        return "StudentID: " + studentID + " | Name: " + name ;
    }
}
