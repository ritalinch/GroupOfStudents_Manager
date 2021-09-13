import javax.swing.*;
import java.util.InputMismatchException;

public class StudentCreator {
    public StudentCreator(Group gr){
        addStudent(gr);
    }

    public StudentCreator(Group gr, Student s){
        addStudent(gr, s);
    }

    public void addStudent(Group gr) {
        if (gr.getStudents().size() > 9) {
            try {
                throw new NoEmptySpaceException();
            } catch (NoEmptySpaceException e) {
                JOptionPane.showMessageDialog(null,
                        "Delete someone first, the group is full");
            }
        }
        else {
            Student s = new Student(returnIdNumber(),
                    returnName(), returnSurname(),
                    returnAge(), returnGender());
            if (gr.containsByIdNum(s)){
                JOptionPane.showMessageDialog(null,
                        "You are not able to use existing id numbers");
            }
            else if (s.getIdNumber() == -1 ||
                    s.getAge() == -1 ||
                    s.getGender() == null) {
                JOptionPane.showMessageDialog(null,
                        "Mistakes in creation");
            }
            else {
                gr.getStudents().add(s);
            }
        }
    }

    public void addStudent(Group gr, Student s) {
        if (gr.getStudents().size() > 9) {
            try {
                throw new NoEmptySpaceException();
            } catch (NoEmptySpaceException e) {
                JOptionPane.showMessageDialog(null,
                        "Delete someone first, the group is full");
            }
        }
        else if (gr.containsByIdNum(s)){
            JOptionPane.showMessageDialog(null,
                    "You are not able to use existing id numbers");
        }
        else {
            gr.getStudents().add(s);
        }
    }

    public long returnIdNumber() {
        try {
            return Long.parseLong(JOptionPane.showInputDialog(null,
                    "Enter student id of your student: "));
        } catch (NumberFormatException ime) {
            JOptionPane.showMessageDialog(null,
                    "You could enter only long integer");
            return -1;
        }
    }

    public String returnName() {
        return JOptionPane.showInputDialog(null,
                "Enter name of your student: ");
    }

    public String returnSurname() {
        return JOptionPane.showInputDialog(null,
                "Enter surname of your student: ");
    }

    public int returnAge() {
        try {
            int age = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Enter age of your student: "));
            if (age < 0) {
                throw new InputMismatchException();
            }
            return age;
        } catch (NumberFormatException ime) {
            JOptionPane.showMessageDialog(null,
                    "You could enter only integer");
            return -1;
        }
    }

    public Gender returnGender() {
        try {
            String gender = JOptionPane.showInputDialog(null,
                    "For choosing gender enter 'MALE' for male and 'FEMALE' for female: ");
            if (gender.equalsIgnoreCase("MALE")) {
                return Gender.MALE;
            }
            else if (gender.equalsIgnoreCase("FEMALE")) {
                return Gender.FEMALE;
            }
            else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ime) {
            JOptionPane.showMessageDialog(null,
                    "You could enter only 'male' or 'female");
            return null;
        }
    }
}
