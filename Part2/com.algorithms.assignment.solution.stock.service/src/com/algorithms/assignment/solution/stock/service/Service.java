package com.algorithms.assignment.solution.stock.service;

public class Service {
	
	public void stockRise(boolean[] compareStock) {
		int count=0;
		for(int i=0;i<compareStock.length;i++) {
			if(compareStock[i])
				count++;
		}
		System.out.println("Total no of companies whose stock price up today: " + count);
	}
	
	public void stockDecline(boolean[] compareStocks) {
		int count=0;
		for(int i=0;i<compareStocks.length;i++) {
			if(!compareStocks[i])
				count++;
		}
		System.out.println("Total no of companies whose stock price declined today: "+count);
	}
	
	public void searchStock(double[] stockPrice,double key) {
		stockPrice=displayAscending(stockPrice, 0, stockPrice.length-1);
		int lft=0,rht=stockPrice.length-1,flag=-1;
		while(lft<=rht) {
			int m=(lft+rht)/2;
			if (stockPrice[m]==key) {
				System.out.println("Stock of value "+key+ " is present");
				flag=0;
				break;
			}
			if (stockPrice[m] < key)
                lft = m + 1;
			
			else
                rht = m - 1;
		}
		if(flag==-1)
			System.out.println("Value not found");
	}
	
	
	public void mergeAscending(double[] stockPrice, int left, int mid, int right) {
		int no1 = mid-left+1;
		int no2 = right-mid;
		
		double leftArr[] =new double[no1];
		double rightArr[] = new double[no2];
		
		for(int i=0;i<no1;i++) {
			leftArr[i]= stockPrice[left+i];
		}
		for(int j=0;j<no2;j++) {
			rightArr[j]=stockPrice[mid+1+j];
		}
		
		int i=0,j=0,k=left;
		
		while(i<no1 && j<no2) {
			if(leftArr[i]<=rightArr[j]) {
				stockPrice[k]=leftArr[i];
				i++;
			}
			else {
				stockPrice[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<no1) {
			stockPrice[k]=leftArr[i];
			i++;
			k++;
		}
		
		while(j<no2) {
			stockPrice[k]=rightArr[j];
			j++;
			k++;
		}
		
		}
	
	public void mergeDescending(double[] stock_price, int left, int mid, int right) {
		int no1 = mid-left+1;
		int no2 = right-mid;
		
		double leftArr[] =new double[no1];
		double rightArr[] = new double[no2];
		
		for(int i=0;i<no1;i++) {
			leftArr[i]= stock_price[left+i];
		}
		for(int j=0;j<no2;j++) {
			rightArr[j]=stock_price[mid+1+j];
		}
		
		int i=0,j=0,k=left;
		
		while(i<no1 && j<no2) {
			if(leftArr[i]>=rightArr[j]) {
				stock_price[k]=leftArr[i];
				i++;
			}
			else {
				stock_price[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<no1) {
			stock_price[k]=leftArr[i];
			i++;
			k++;
		}
		
		while(j<no2) {
			stock_price[k]=rightArr[j];
			j++;
			k++;
		}
		
		}
	public double[] displayAscending(double[] stockPrice,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			
			displayAscending(stockPrice,left,mid);
			displayAscending(stockPrice,mid+1,right);
			
			mergeAscending(stockPrice,left,mid,right);
					
		}
		return stockPrice;
		
	}
	
	public double[] displayDescending(double[] stockPrice,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			
			displayDescending(stockPrice,left,mid);
			displayDescending(stockPrice,mid+1,right);
			
			mergeDescending(stockPrice,left,mid,right);
					
		}
		return stockPrice;
		
	}

}
