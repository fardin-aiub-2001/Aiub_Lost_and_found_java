package AllClass;

import Interface.*;
import Log.*;

public class student extends user implements Iuser {
    private String mail;
    private String department;
    private String pass;

    public student(String name, String id, String mail, String department, String pass) {
        super(name, id);
        this.mail = mail;
        this.department = department;
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public String getDepartment() {
        return department;
    }

    public String getPass() {
        return pass;
    }

    public void studentDisplay() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Mail: " + mail);
        System.out.println("Department: " + department);
        System.out.println("Password: " + pass);
    }
}
