package hometasks.task2.solutions.chapter2;

public class Car {

    private double x;
    private double gas;
    private final double efficiency;


    public Car(double x, double gas, double efficiency) {
        this.x = x;
        this.gas = gas;
        this.efficiency = efficiency;
    }

    public void drive(double inpX){
        if (gas < inpX / efficiency)
            return;
        x += inpX;
        gas -= inpX / efficiency;
    }

    public void stockUp(double inpGas) {
        gas += inpGas;
    }

}
