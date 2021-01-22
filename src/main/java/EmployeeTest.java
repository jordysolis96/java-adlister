import models.Employee;

import java.util.Date;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee fer = new Employee();

        fer.setEmpNo(1L);
        fer.setFirstName("Fernando");
        fer.setLastName("Mendoza");
        fer.setBirthDate(new Date());
        fer.setHireDate(new Date());
        fer.setGender('M');

        System.out.println("fullName = " + fer.getFirstName() + " " + fer.getLastName());
    }
}

