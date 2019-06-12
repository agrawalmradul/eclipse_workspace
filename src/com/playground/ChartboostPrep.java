package com.playground;

import java.util.ArrayList;
import java.util.List;

//Write a function to detect whether a number is prime.  
//Write a function to detect whether a string is a palindrome.
//Write a function that takes an array of strings and returns those strings which are palindromes and whose length is a prime number.  
//How would you architect a product list page?  
//Write a function to serialize a binary tree into a string. Write another function to deserialize a string back into a binary tree.  
//Q1: Write a program to print the number of times each word appears in a given sentence. For example "the fox jumps over the fox moon" would output:
//the:2
//fox:2
//jumps:1
//over:1
//moon:1  
//What happens in the system when I run "curl www.google.com" on the console  
//Describe the architect of Google or Facebook  
//find pairs or people who have $1.00 for lunch and match them up
//(i.e. given a list, find matches (pairs) that add up to 100; reject ones that don't have a match or odd numbers)  

//The class should have next() and hasNext() and should run in O(1) time. Everytime next() is called, it should hit the consecutive iterator. 
//Detecting memory leaks in Java? Interprocess communication in Android? A lot of specific knowledge based questions that do not really provide good representation of someone's technical ability  

public class ChartboostPrep {

	public static void main(String[] args) {
		
//		System.out.println(isPrime(4));
		System.out.println(listPrimeNumbers(2809));
	}

	public static boolean isPrime(int num) {
		if (num <= 0 || num == 1) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if ((num * num - 1) % 24 == 0) {
			return true;
		}
		return false;
	}
	
	public static List<Integer> listPrimeNumbers(int n){
		List<Integer> result = new ArrayList<>();
		int curr=0;
		int i = 1;
		while(curr < n) {
			double temp = Math.sqrt(24*i + 1);
			curr = (int)temp;
			if(temp%1 == 0) {
				result.add(curr);
			}
			i++;
		}
		return result;
	}

}
