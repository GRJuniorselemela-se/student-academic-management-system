/**
FXML Controller class
@author Junior
 */
package QUESTION_1_UI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import QUESTION_1.AcademicManager;
import QUESTION_1.Student;

import java.net.URL;
import java.util.*;
import javafx.fxml.Initializable;

public class StudentManagerUIController implements Initializable {

    @FXML private TextField txtStudentID;
    @FXML private TextField txtName;
    @FXML private Button btnAdd;
    @FXML private Button btnView;
    @FXML private Button btnSearch;
    @FXML private Button btnDelete;
    @FXML private ListView<String> listViewStudents;

    private AcademicManager manager;
    private ObservableList<String> studentListItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        manager = new AcademicManager();
        studentListItems = FXCollections.observableArrayList();
        listViewStudents.setItems(studentListItems);

        manager.addStudent(new Student(101, "Junior"));
        manager.addStudent(new Student(102, "Tokologo"));
        manager.addStudent(new Student(103, "Matsobane"));

        refreshStudentList();
    }

    @FXML
    private void addStudent() {
        String idText = txtStudentID.getText().trim();
        String name = txtName.getText().trim();

        if (idText.isEmpty() || name.isEmpty()) {
            showAlert("Error", "ID and Name are required.");
            return;
        }
        try {
            int id = Integer.parseInt(idText);
            Student student = new Student(id, name);
            manager.addStudent(student);
            clearFields();
            refreshStudentList();
            showAlert("Success", "Student added.");
        } catch (NumberFormatException e) {
            showAlert("Error", "ID must be a number.");
        }
    }

    @FXML
    private void viewAllStudents() {
        Collection<Student> students = manager.getStudents().values();
        if (students.isEmpty()) {
            showAlert("Student List", "No students found.");
        } else {
            StringBuilder sb = new StringBuilder("All Students:\n");
            for (Student s : students) {
                sb.append(s).append("\n");
            }
            showAlert("Student List", sb.toString());
        }
    }

    @FXML
    private void searchStudent() {
        String idText = txtStudentID.getText().trim();
        if (idText.isEmpty()) {
            showAlert("Error", "Please enter an ID to search.");
            return;
        }
        try {
            int id = Integer.parseInt(idText);
            Student s = manager.getStudents().get(id);
            if (s != null) {
                showAlert("Student Found", s.toString());
                txtName.setText(s.getName());
            } else {
                showAlert("Not Found", "No student with ID " + id);
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "ID must be a number.");
        }
    }

    @FXML
    private void deleteStudent() {
        String idText = txtStudentID.getText().trim();
        if (idText.isEmpty()) {
            showAlert("Error", "Please enter an ID to delete.");
            return;
        }
        try {
            int id = Integer.parseInt(idText);
            Student removed = manager.getStudents().remove(id);
            if (removed != null) {
                clearFields();
                refreshStudentList();
                showAlert("Deleted", "Student " + removed.getName() + " removed.");
            } else {
                showAlert("Not Found", "No student with ID " + id);
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "ID must be a number.");
        }
    }

    private void refreshStudentList() {
        studentListItems.clear();
        List<Student> sorted = new ArrayList<>(manager.getStudents().values());
        sorted.sort(Comparator.comparing(Student::getName));
        for (Student s : sorted) {
            studentListItems.add(s.toString());
        }
    }

    private void clearFields() {
        txtStudentID.clear();
        txtName.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
