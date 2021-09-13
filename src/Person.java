import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Person (String firstName, String lastName, int age, Gender gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Information about this person: " +
                "firstName - " + firstName + '\'' +
                ", lastName - " + lastName + '\'' +
                ", age - " + age +
                ", gender - " + gender +
                '.';
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
        Person person = (Person) o;
        return (firstName.equals(person.getFirstName())) &&
                (lastName.equals(person.getLastName())) &&
                (age == person.getAge()) &&
                (gender == person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
