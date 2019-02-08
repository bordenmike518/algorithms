/*
Author  : Micahel Borden
Date    : Feb 7, 2019
Update  : Feb 7, 2019

Purpose : Implement a class 'Car' with the following properties. A car has a certain fuel efficiency (measured in miles/gallon) and a certain amount of fuel in the gas tank. The efficiency is specified in the constructor, and the initial fuel level is 0. Supply a method 'drive' that simulates driving the car for a certain distance, reducing the fuel level in the gas tank, and methods 'getGas', to return the current fuel level, and 'addGas' to tank up.
*/
package lib;

class Car {
    double fuelEfficiency, tankSize, fuelLevel = 0;
    public Car(double fuelEfficiency, int tankSize) {
        this.fuelEfficiency = fuelEfficiency;
        this.tankSize = tankSize;
    }
    
    public void drive(double miles) {
        this.fuelLevel -= miles / fuelEfficiency;
    }
    
    public double getGas() {
        return this.fuelLevel;
    }
    
    public void addGas() {
        this.fuelLevel = this.tankSize;
    }
    
    public static void main(String[] args) {
        int milesToTravel = 2802;   // Coast to coast distance of USA
        double fuelCost = 2.281;    // Average gas price as of 2/7/19
        double fuelIndicatorLevel = 5;
        double cost = 0.00;
        Car car = new Car(11, 20);
        int period = 1;             // Must be less than this.tankSize - 1
        for(int i = 0; i < milesToTravel; i+=period) {
            if (car.fuelLevel < fuelIndicatorLevel) {
                System.out.println("addGas()");
                System.out.println(" -- Mile " + i);
                cost += fuelCost * (car.tankSize - car.fuelLevel);
                car.addGas();
            }
            car.drive(1);
        }
        System.out.println("FINISH:");
        System.out.print(String.format(" -- Total cost @ $%.2f", fuelCost));
        System.out.println(String.format(" per/gallon is $%.2f.", cost));
        System.out.print(String.format(" -- With %.2f left in the tank",
                                           car.fuelLevel));
        System.out.println(" starting with 0 gallons.");
                                            
    }
}
