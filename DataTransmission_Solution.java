package com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataTransmission_Solution {
    
    
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
   
    public static int[] getPrimesAndSecondLargest(ArrayList<Integer> numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int num : numbers) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        Collections.sort(primes);
        int totalPrimes = primes.size();
        int secondLargest = primes.get(totalPrimes - 2);
        return new int[]{totalPrimes, secondLargest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
    
        String input = scanner.nextLine();
        String[] inputArr = input.trim().split("\\s+");
        for (String numStr : inputArr) {
            if (numStr.endsWith(";")) {
                numStr = numStr.substring(0, numStr.length() - 1); 
            }
            numbers.add(Integer.parseInt(numStr));
        }
        

        int[] primesAndSecondLargest = getPrimesAndSecondLargest(numbers);
        int totalPrimes = primesAndSecondLargest[0];
        int secondLargest = primesAndSecondLargest[1];
        
        
        System.out.println(totalPrimes + secondLargest);
    }
}
