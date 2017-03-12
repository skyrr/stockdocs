package science.mydiabetes.stockdocs.model;

/**
 * Created by sky on 10.02.2017.
 */

public class Student {
    private String lastName;
    private String firstName;
    private float age;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public float getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public Student(String firstName,String  lastName,float  age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Student(){}


}

