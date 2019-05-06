package xuanc;

/**
 * ClassName    Chapter15-Teacher
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午7:10
 * @version     1.0
 */ 
public class Teacher implements java.io.Serializable {

    private String name;
    private Person student;

    public Teacher(String name, Person student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
}
