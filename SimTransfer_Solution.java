package com.java;

import java.util.Scanner;
import java.util.Arrays;

class Sim {
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    
    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    
    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}

public class SimTransfer_Solution {
    public static Sim[] transferCircle(Sim[] sims, String circle1, String circle2) {
        Sim[] result = Arrays.stream(sims)
                            .filter(sim -> sim.getCircle().equals(circle1))
                            .sorted((s1, s2) -> Double.compare(s2.getRatePerSecond(), s1.getRatePerSecond()))
                            .toArray(Sim[]::new);

        for (Sim sim : result) {
            sim.setCircle(circle2);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Sim[] sims = new Sim[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Sim " + (i + 1) + ":");
            System.out.print("Sim Id: ");
            int simId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            System.out.print("Rate Per Second: ");
            double ratePerSecond = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Circle: ");
            String circle = scanner.nextLine();
            sims[i] = new Sim(simId, customerName, balance, ratePerSecond, circle);
        }

        System.out.print("Enter circle1: ");
        String circle1 = scanner.nextLine();
        System.out.print("Enter circle2: ");
        String circle2 = scanner.nextLine();

   
        Sim[] result = SimTransfer_Solution.transferCircle(sims, circle1, circle2);

        
        System.out.println("Result:");
        for (Sim sim : result) {
            System.out.println(sim.getSimId() + " " + sim.getCustomerName() + " " + sim.getCircle() + " " + sim.getRatePerSecond());
        }

        scanner.close();
    }
}
