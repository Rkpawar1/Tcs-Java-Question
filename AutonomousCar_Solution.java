package com.java;

import java.util.Scanner;

class AutonomousCar {
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class AutonomousCar_Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];
        
        for (int i = 0; i < 4; i++) {
            int carId = scanner.nextInt();
            String brand = scanner.next();
            int noOfTestsConducted = scanner.nextInt();
            int noOfTestsPassed = scanner.nextInt();
            String environment = scanner.next();
            cars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }

        String environment = scanner.next();
        String brand = scanner.next();

        int totalTestPassed = findTestPassedByEnv(cars, environment);
        if (totalTestPassed > 0) {
            System.out.println(totalTestPassed);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar car = updateCarGrade(brand, cars);
        if (car != null) {
            System.out.println(car.getBrand() + "::" + car.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }
    }

    public static int findTestPassedByEnv(AutonomousCar[] cars, String environment) {
        int totalTestPassed = 0;
        for (AutonomousCar car : cars) {
            if (car.getEnvironment().equals(environment)) {
                totalTestPassed += car.getNoOfTestsPassed();
            }
        }
        return totalTestPassed;
    }

    public static AutonomousCar updateCarGrade(String brand, AutonomousCar[] cars) {
        for (AutonomousCar car : cars) {
            if (car.getBrand().equals(brand)) {
                int rating = (car.getNoOfTestsPassed() * 100) / car.getNoOfTestsConducted();
                car.setGrade(rating >= 80 ? "A1" : "B2");
                return car;
            }
        }
        return null;
	}

}
