package hometasks.task1.tests;

import org.junit.Assert;
import hometasks.task1.solutions.Employee;
import org.junit.Test;

public class EmployeeTest extends Assert {

    @Test
    public void testGetName() {
        Employee testEmployee = new Employee(12, "Petr", "Pridonov", 100);
        assertEquals("Petr Pridonov", testEmployee.getName());
    }

    @Test
    public void testToString() {
        Employee testEmployee = new Employee(12, "Petr", "Pridonov", 100);
        assertEquals("Employee[id = 12, name = Petr Pridonov, salary = 100]", testEmployee.toString());
    }

}
