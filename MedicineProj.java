package day7;

import java.util.Scanner;

interface inf1 {
	void displayLabel();
}

abstract class Medicine implements inf1{
	
	String name;
	String Brand;
	double price;
	
	Medicine(String name, String brand, double price) {
		
		this.name = name;
		Brand = brand;
		this.price = price;
	}

	void getDetails(){
		System.out.println("Name of the product is "+name);
		System.out.println("Brand of the product is "+Brand);
		System.out.println("Price of the product is Rs."+price);
	}
	
}

class Tablet extends Medicine{
	
	Tablet(String name, String brand, double price) {
		super(name, brand, price);
		// TODO Auto-generated constructor stub
	}

	public void displayLabel(){
		System.out.println("**Store in a cool dry place.**\n\n");
	}
}
class Ointment extends Medicine{
	
	Ointment(String name, String brand, double price) {
		super(name, brand, price);
		// TODO Auto-generated constructor stub
	}

	public void displayLabel(){
		System.out.println("**for external use only.**\n\n");
	}
}

class Syrup extends Medicine{
	
	Syrup(String name, String brand, double price) {
		super(name, brand, price);
		// TODO Auto-generated constructor stub
	}

	public void displayLabel(){
		System.out.println("**Consult your pharmacist or physician before use.**\n\n");
	}
}


class TestMedicine{
	void Details(Medicine m){
		m.getDetails();
	}
	void disLabel(Medicine m){
		m.displayLabel();
	}
	
	
}

public class MedicineProj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMedicine t = new TestMedicine();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Tablet\n2.Ointment\n3.Syrup");
		System.out.println("Enter your choice=");
		int choice = sc.nextInt();
		String MName;
		String BName;
		double MPrice;
		System.out.println("Enter the name of product=");
		MName = sc.next();
		System.out.println("Enter the brand of product=");
		BName = sc.next();
		System.out.println("Enter the price of product=");
		MPrice = sc.nextDouble();
		
		switch(choice){
			case 1:
					Tablet tb = new Tablet(MName,BName,MPrice);
					t.Details(tb);
					System.out.println("Additional Info:- ");
					t.disLabel(tb);
					break;
			
			case 2:
					Ointment o = new Ointment(MName,BName,MPrice);
					t.Details(o);
					System.out.println("Additional Info:- ");
					t.disLabel(o);
					break;
			case 3:
					Syrup s = new Syrup(MName,BName,MPrice);
					t.Details(s);
					System.out.println("Additional Info:- ");
					t.disLabel(s);
					break;
			default:
				System.out.println("Invalid Choice\n");
				
		}
		sc.close();
		
	}

}
