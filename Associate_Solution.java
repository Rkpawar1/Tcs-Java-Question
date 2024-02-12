package com.java;

import java.util.Scanner;

class Associate{
	private int id;
	private String Name;
	private String Technology;
	private int ExperienceInYear;
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public String getTechnology() 
	{
		return Technology;
	}
	public void setTechnology(String technology)
	{
		Technology = technology;
	}
	public int getExperienceInYear()
	{
		return ExperienceInYear;
	}
	public void setExperienceInYear(int exoerienceInYear) 
	{
		ExperienceInYear = getExperienceInYear();
	}
}
public class Associate_Solution
{
public static Associate[] associatesForGivenTechnology(Associate[] associates, String searchTechnology) {
	   
    int count = 0;
    for (Associate associate : associates) 
    {
        if (associate.getTechnology().equalsIgnoreCase(searchTechnology) && associate.getExperienceInYear() % 5 == 0) {
            count++;
        }
    }

    Associate[] result = new Associate[count];
    int index = 0;
    for (Associate associate : associates) 
    {
        if (associate.getTechnology().equalsIgnoreCase(searchTechnology) && associate.getExperienceInYear() % 5 == 0) 
        {
            result[index++] = associate;
        }
    }

    return result;
}

public static void main(String[] args) 
{
	
	 Scanner scanner = new Scanner(System.in);
        Associate[] associates = new Associate[5];
        for (int i = 0; i < 5; i++) {
            Associate associate = new Associate();
            System.out.println("Enter Associate " + (i + 1) + " details:");
            System.out.print("ID: ");
            associate.setId(scanner.nextInt());
            scanner.nextLine(); 
            System.out.print("Name: ");
            associate.setName(scanner.nextLine());
            System.out.print("Technology: ");
            associate.setTechnology(scanner.nextLine());
            System.out.print("Experience in Years: ");
            associate.setExperienceInYear(scanner.nextInt());
            scanner.nextLine(); 
            associates[i] = associate;
        }

        System.out.print("Enter search technology: ");
        String searchTechnology = scanner.nextLine();

        
        Associate[] filteredAssociates = associatesForGivenTechnology(associates, searchTechnology);

        
        System.out.println("IDs of Associates with technology " + searchTechnology );
        for (Associate associate : filteredAssociates) {
            System.out.println(associate.getId());
        }
    } 


}

