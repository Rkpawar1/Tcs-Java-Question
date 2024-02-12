package com.java;

import java.util.Arrays;

class Inventory {
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}

public class Inventory_Solution {
    public static Inventory[] replenish(Inventory[] inventories, int limit) {
        return Arrays.stream(inventories)
                     .filter(inv -> inv.getThreshold() <= limit)
                     .toArray(Inventory[]::new);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Inventory[] inventories = new Inventory[4];

        for (int i = 0; i < inventories.length; i++) {
            Inventory inventory = new Inventory();
            inventory.setInventoryId(scanner.nextLine());
            inventory.setMaximumQuantity(Integer.parseInt(scanner.nextLine()));
            inventory.setCurrentQuantity(Integer.parseInt(scanner.nextLine()));
            inventory.setThreshold(Integer.parseInt(scanner.nextLine()));
            inventories[i] = inventory;
        }

        int limit = scanner.nextInt();
        Inventory[] replenishedInventories = replenish(inventories, limit);

        for (Inventory inventory : replenishedInventories) {
            if (inventory.getThreshold() > 75) {
                System.out.println(inventory.getInventoryId() + " Critical Filling");
            } else if (inventory.getThreshold() >= 50 && inventory.getThreshold() <= 75) {
                System.out.println(inventory.getInventoryId() + " Moderate Filling");
            } else {
                System.out.println(inventory.getInventoryId() + " Non-Critical Filling");
            }
        }
    }
}
