package hometasks.task2.solutions.chapter3;

public class Workspace {

    public static void main(String[] args) {
        Measurable obj1 = new Employee(1);
        Measurable obj3 = new Employee(2);
        Measurable obj2 = new Employee(3);
        Measurable objs[] = new Employee[3];
        objs[0] = obj1;
        objs[1] = obj2;
        objs[2] = obj3;
        System.out.println(Employee.average(objs));
        System.out.println(Employee.largest(objs).getMeasure());
    }
}
