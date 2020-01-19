import java.text.DecimalFormat;
import java.util.Scanner;
//Keyboard scanner
public class CashMachine {
	
	private int itemCount=0;
	private double tax;
	private double sum=0.0;
	private String receipt="";
	
	private Item[] items;
	
	//My instance variables
	
	Scanner consoleInput = new Scanner(System.in);
	//Allows keyboard to be engaged
	
	public CashMachine(double tax) {
	this.tax = tax;
	receipt="";
	items = new Items[SIZE];
	}//constructor

	
public  String getOneStringInput(String msg) {
	System.out.println(msg);
	return consoleInput.next();
}//end of method
//easily operate our code and change whenever


public  double getOneDoubleInput (String numb) {
	System.out.print(numb);
	return consoleInput.nextDouble();
	//easily operate our code and change whenever
}//end of method
public int  getItemCount(int numberOfItems) {
	return itemCount;
}//end of method 

public double calculateTax() {
return sum*tax ;
}//end of method

public double calclulateTaxPlusSum() {
	return calculateTax()+sum;
}//end of method

public boolean processMenu() {
	double menuInput = getOneDoubleInput("Action>>");
	if (menuInput ==1) {
	purchaseItem();
	}else if (menuInput==2) {
		printReceipt();
	}else if (menuInput==3) {
		return false;
	}
	return true;
}

public void purchaseItem() {
	String itemName= getOneStringInput("Item name(No spaces)>>");
	double itemPrice= getOneDoubleInput("Item price >>");
	 itemCount++;
	 sum = sum+itemPrice;
	 receipt += receipt+String.format("%-15s$%.2f%n",itemName,itemPrice);
}
public void printMenu() {
	System.out.println(""
	+ "\n1)Purchase Item"
	+ "\n2)Print Receipt"
	+ "\n3)Quit");
}
private void printReceipt() {
	System.out.println("\n");
	
	if (itemCount==0) {
		System.out.println("Empty!!");
	}else {
		System.out.println("Receipt for "+itemCount+" items");
		System.out.println(receipt);
		System.out.printf("%-15s$%.2f%n", "Tax: " ,calculateTax());
		System.out.printf("%-15s$%.2f%n","Total: ",calclulateTaxPlusSum());
		
	}
	receipt="";
	sum=0;
	itemCount=0;
	
}

}//end of class