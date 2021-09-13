import java.util.Comparator;

public class StudentComparatorAlphabetically implements Comparator<Student> {

    public StudentComparatorAlphabetically(){
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}