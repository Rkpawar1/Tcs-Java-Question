package com.java;

import java.util.Scanner;

class NavalVessel {
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;
    private String classification;

    // Constructor
    public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }

    // Getters and setters
    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }

    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}

public class NavalVessel_Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NavalVessel[] navalVessels = new NavalVessel[4];

        // Reading NavalVessel attributes
        for (int i = 0; i < 4; i++) {
            int vesselId = scanner.nextInt();
            String vesselName = scanner.next();
            int noOfVoyagesPlanned = scanner.nextInt();
            int noOfVoyagesCompleted = scanner.nextInt();
            String purpose = scanner.next();
            navalVessels[i] = new NavalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose);
        }

        int percentage = scanner.nextInt();
        String purpose = scanner.next();

        // Calling static methods
        int avgVoyages = findAvgVoyagesByPct(navalVessels, percentage);
        NavalVessel vessel = findVesselByGrade(purpose, navalVessels);

        if (vessel != null) {
            System.out.println(avgVoyages);
            System.out.println(vessel.getVesselName() + "%" + vessel.getClassification() + " in java");
        } else {
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
    }

    // Static method to find average voyages by percentage
    public static int findAvgVoyagesByPct(NavalVessel[] navalVessels, int percentage) {
        int totalVoyages = 0;
        int count = 0;

        for (NavalVessel vessel : navalVessels) {
            int pct = (vessel.getNoOfVoyagesCompleted() * 100) / vessel.getNoOfVoyagesPlanned();
            if (pct >= percentage) {
                totalVoyages += vessel.getNoOfVoyagesCompleted();
                count++;
            }
        }

        return count > 0 ? totalVoyages / count : 0;
    }

  
    public static NavalVessel findVesselByGrade(String purpose, NavalVessel[] navalVessels) {
        for (NavalVessel vessel : navalVessels) {
            if (vessel.getPurpose().equals(purpose)) {
                int pct = (vessel.getNoOfVoyagesCompleted() * 100) / vessel.getNoOfVoyagesPlanned();
                if (pct == 100) {
                    vessel.setClassification("Star");
                } else if (pct >= 80) {
                    vessel.setClassification("Leader");
                } else if (pct >= 55) {
                    vessel.setClassification("Inspirer");
                } else {
                    vessel.setClassification("Striver");
                }
                return vessel;
            }
        }
        return null;
    }
}
