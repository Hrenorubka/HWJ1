package hometasks;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int  salary;

    public Employee(){
        firstName = "";
        lastName = "";
    }

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName()
    {
        return firstName + ' ' + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        return (int) (salary * (1.0f + ((float) percent / 100.0f)));
    }

    @Override
    public String toString() {
        return "Employee[id = " + ((Integer) id).toString() + ", name = " + getName() + ", salary = " + ((Integer)salary).toString() + ']';
    }
}
