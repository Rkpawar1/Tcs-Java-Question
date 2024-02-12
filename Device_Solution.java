package com.java;

import java.util.Scanner;

class Phone 
{
    private int phoneId;
    private String os;
    private String brand;
    private int price;
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Phone(int phoneId, String os, String brand, int price) {
		super();
		this.phoneId = phoneId;
		this.os = os;
		this.brand = brand;
		this.price = price;
	}

}
public class Device_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        Phone[] phones = new Phone[4];
        for (int i = 0; i < 4; i++) 
        {
        	System.out.println("Enter Phoneid:");
            int phoneId = scanner.nextInt();
            System.out.println("Enter os:");
            String os = scanner.next();
            System.out.println("Enter Brand:");
            String brand = scanner.next();
            System.out.println("Enter Price:");
            int price = scanner.nextInt();
            phones[i] = new Phone(phoneId, os, brand, price);
        }
        System.out.println("Enter Brand to Search");
        String brandToSearch = scanner.next();
        System.out.println("Enter Os to search:");
        String osToSearch = scanner.next();

        System.out.println(findPriceForGivenBrand(phones, brandToSearch));
        System.out.println(getPhoneIdBasedOnOs(phones, osToSearch));
    }

    public static int findPriceForGivenBrand(Phone[] phones, String brand)
    {
        int totalPrice = 0;
        for (Phone phone : phones)
        {
            if (phone.getBrand().equalsIgnoreCase(brand))
            {
                totalPrice += phone.getPrice();
            }
        }
        if (totalPrice > 0)
        {
            return totalPrice;
        } else 
        {
            System.out.println("The given Brand is not available");
            return 0;
        }
    }

    public static Integer getPhoneIdBasedOnOs(Phone[] phones, String os) 
    {
        for (Phone phone : phones) 
        {
            if (phone.getOs().equalsIgnoreCase(os) && phone.getPrice() >= 50000) 
            {
                return phone.getPhoneId();
            }
        }
        System.out.println("No phones are available with specified os and price range");
        return null;
	}

}
