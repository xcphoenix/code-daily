package xuanc;

class Name {
    private String firstName;
    private String lastName;
    public Name() {}
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}

/**
 * ClassName    Chapter6-Person
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午3:52
 */
public class PersonSix {

    private final Name name;
    public PersonSix(Name name) {
        this.name =new Name(name.getFirstName(), name.getLastName());
    }
    public Name getName() {
        return new Name(name.getFirstName(), name.getLastName());
    }
    public static void main(String[] args) {
        Name n = new Name("悟空", "孙");
        PersonSix p = new PersonSix(n);
        System.out.println(p.getName().getFirstName());
        n.setFirstName("八戒");
        System.out.println(p.getName().getFirstName());
    }
}
