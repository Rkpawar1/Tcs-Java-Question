package com.java;

import java.util.Scanner;

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;

   
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    // Getters
    public int getRegNo() {
        return regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPrice() {
        return price;
    }

    public boolean hasFlightFacility() {
        return flightFacility;
    }

    // Setters
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}

public class TravelAgencies_Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter the number of travel agencies: ");
        int numAgencies = scanner.nextInt();
        scanner.nextLine(); 
        
       
        TravelAgencies[] agencies = new TravelAgencies[numAgencies];

        
        for (int i = 0; i < numAgencies; i++) {
            System.out.println("Enter details for agency " + (i + 1) + ":");
            System.out.print("Registration Number: ");
            int regNo = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Agency Name: ");
            String agencyName = scanner.nextLine();
            
            System.out.print("Package Type: ");
            String packageType = scanner.nextLine();
            
            System.out.print("Price: ");
            int price = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Flight Facility Available (true/false): ");
            boolean flightFacility = scanner.nextBoolean();
            scanner.nextLine(); 

            agencies[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
        }

        int highestPackagePrice = findAgencyWithHighestPackagePrice(agencies);
        System.out.println("Highest Package Price: " + highestPackagePrice);

        System.out.println("Enter registration number: ");
        int regNo = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Enter package type: ");
        String packageType = scanner.nextLine();

        TravelAgencies resultAgency = agencyDetailsForGivenIdAndType(agencies, regNo, packageType);
        if (resultAgency != null) {
            System.out.println("Agency Name: " + resultAgency.getAgencyName() + ", Price: " + resultAgency.getPrice());
        } else {
            System.out.println("No agency found with the provided details.");
        }

        scanner.close();
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies) {
        int highestPrice = Integer.MIN_VALUE;
        for (TravelAgencies agency : agencies) {
            if (agency.getPrice() > highestPrice) {
                highestPrice = agency.getPrice();
            }
        }
        return highestPrice;
    }

    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] agencies, int regNo, String packageType) {
        for (TravelAgencies agency : agencies) {
            if (agency.getRegNo() == regNo && agency.getPackageType().equalsIgnoreCase(packageType) && agency.hasFlightFacility()) {
                return agency;
            }
        }
        return null;
    }
}
