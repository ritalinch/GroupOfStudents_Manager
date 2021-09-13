import java.util.Objects;

public class Student extends Person implements CSVConverter{
    private long idNumber;
    public Student(long idNumber, String firstName,
                   String lastName, int age, Gender gender){
        super(firstName, lastName, age, gender);
        this.idNumber = idNumber;
    }

    public Student(){
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) ||
                (getClass() != o.getClass())) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return idNumber == student.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idNumber);
    }

    @Override
    public String toString(){
        return "Information about this student: " +
                "idNumber - " + getIdNumber() +
                ", firstName - " + getFirstName() +
                ", lastName - " + getLastName() +
                ", age - " + getAge() +
                ", gender - " + getGender() + '.';
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toCSVString() {
        return getIdNumber() + ", " + getFirstName() + ", " +
                getLastName() + ", " + getAge() + ", " + getGender();
    }

    @Override
    public Student fromCSVString(String str) {
        String[] values = str.split(", ");
        Student res = new Student();

        res.setIdNumber(Long.parseLong(values[0]));
        res.setFirstName(values[1]);
        res.setLastName(values[2]);
        res.setAge(Integer.parseInt(values[3]));

        if (values[3].equals("MALE")) {
            res.setGender(Gender.MALE);
        }
        else {
            res.setGender(Gender.FEMALE);
        }
        return res;
    }
}
