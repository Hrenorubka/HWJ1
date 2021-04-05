package hometasks.task2.solutions.chapter4;


import hometasks.task1.solutions.MyPoint;

public class Workspace {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPoint a = new MyPoint(0, 0);
        MyPoint b = new MyPoint(1, 1);
        Line abc = new Line(a, b);
        Line acc = abc.clone();
        System.out.println(acc.getFrom());

    }


}
