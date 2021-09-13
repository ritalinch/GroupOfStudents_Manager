import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(String name){
        this.name = name;
    }

    public Group(){
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        sortStudentsByLastName();
        StringBuilder output = new StringBuilder();
        for (Student s : students) {
            output.append(s).append("\n");
        }
        return output.toString();
    }

    public void delete(long idNumber){
        for (Student student : students) {
            if(student.getIdNumber() == idNumber) {
                students.remove(student);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,
                "No students with such id number, no students were deleted.");
    }

    public void add() {
        new StudentCreator(this);
    }

    public boolean containsByIdNum(Student s) {
        for (Student student : students) {
            if (student.getIdNumber() == s.getIdNumber()) {
                return true;
            }
        }
        return false;
    }

    public void sortStudentsByLastName() {
        Collections.sort(students, Comparator.nullsLast(new StudentComparatorAlphabetically()));
    }

    public Student searchByLastName (String surname){
        for(Student student : students) {
            if (student.getLastName().equals(surname)) {
                return student;
            }
        }
        return null;
    }
}