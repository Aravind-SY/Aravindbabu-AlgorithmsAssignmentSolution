package com.algorithms.assignment.solution.stock.service;
import com.algorithms.assignment.solution.stock.service.Service;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service stockService = new Service();
		double key;
		
		System.out.println("Enter the no of companies");
		int noOfCompanies = sc.nextInt();
		
		double stockPrice[] = new double[noOfCompanies];
		boolean compareStock[] = new boolean[noOfCompanies];
		
		for(int i=0;i<noOfCompanies;i++) {
			System.out.println("Enter current stock price of the company "+(i+1));
			stockPrice[i] = sc.nextDouble();
			
			System.out.println("Whether company's stock price rose today compared to yesterday?");
			compareStock[i] = sc.nextBoolean();
		}
			while(true) {
				System.out.println();
				System.out.println();
				System.out.println("\n------------------------------------------------------------");
				System.out.println("Enter the operation that you want to perform");
				System.out.println("1. Display the companies stock prices in ascending order");
				System.out.println("2. Display the companies stock prices in descending order");
				System.out.println("3. Display the total no of companies for which stock prices rose today");
				System.out.println("4. Display the total no of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("6. Press 0 to exit");
				System.out.println("--------------------------------------------------------------");
				System.out.println();
				
				int choice = sc.nextInt();
				switch(choice) {
					case 1:
						stockPrice=stockService.displayAscending(stockPrice, 0, stockPrice.length-1);
						System.out.println("Stock prices is ascending order are:");
						for(int i=0;i<stockPrice.length;i++) {
							System.out.print(stockPrice[i]+ " ");
						}
						break;
					case 2:
						stockPrice=stockService.displayDescending(stockPrice, 0, stockPrice.length-1);
						System.out.println("Stock prices is descending order are:");
						for(int i=0;i<stockPrice.length;i++) {
							System.out.print(stockPrice[i]+ " ");
						}
						break;
						
					case 3:
						stockService.stockRise(compareStock);
						break;
						
					case 4:
						stockService.stockDecline(compareStock);
						break;
						
					case 5:
						System.out.println("Enter the key value");
						key = sc.nextDouble();
						stockService.searchStock(stockPrice, key);
						break;
						
					case 0: 
						System.out.println("Exited successfully");
						System.exit(0);
						
					default:
						System.out.println("Enter a valid choice");
						break;
				}
			}
			
			
		

	}

		
	}


