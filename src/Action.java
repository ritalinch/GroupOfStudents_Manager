import javax.swing.*;
import java.util.InputMismatchException;

public class Action {

    Group group;
    public Action(Group group) {
        this.group = group;
        try {
            int choice = choice();
            switch (choice) {
                case 1 -> JOptionPane.showMessageDialog(null, group);
                case 2 -> group.add();
                case 3 -> delete();
                case 4 -> JOptionPane.showMessageDialog(null,
                        group.searchByLastName(JOptionPane.showInputDialog(null,
                                "Enter surname you want to search with:")));
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            System.exit(1);
        }
    }

    public int choice() {
        try {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null,
                    """
                    What do you want to do:
                    1. show info about all students in the group
                    2. add a new student
                    3. delete a student by id number
                    4. search by lastname
                    """));
            if (choice < 1 || choice > 4) {
                throw new InputMismatchException();
            }
            return choice;
        } catch (InputMismatchException ime) {
            JOptionPane.showMessageDialog(null,
                    "You could enter only number from 1 to 4 inclusively! Try one more time.");
            return choice();
        }
    }

    public void delete() {
        try {
            group.delete(Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Enter the index of the student you want to delete: ")));
        } catch (InputMismatchException | NumberFormatException | NullPointerException ime) {
            JOptionPane.showMessageDialog(null,
                    "You could enter only number from 0 to 9 inclusively! Try one more time.");
        } catch (IndexOutOfBoundsException ioobe) {
            JOptionPane.showMessageDialog(null,
                    "Illegal value for array index. Try one more time.");
        }
    }
}
