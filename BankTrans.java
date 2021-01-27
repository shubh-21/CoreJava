package day5;

import java.util.*;


class BankTransaction{
	int bal;
	BankTransaction(int bal){
		this.bal = bal;
	}
	void withdraw(int amt){
		
	}
	void deposite(int amt){
		
	}
	void checkBal(){
		
	}
}

class ICICITrans extends BankTransaction{
	ICICITrans(int bal){
		super(bal);
	}
	void withdraw(int amt){
		if(amt<=bal){
			bal=bal-amt;
			System.out.println(" Amount "+amt+"is debited from your ICICI account");
			checkBal();
		}
		else{
			System.out.println("Sorry,your balance is insufficient!!!");
		}
	}
	void deposite(int amt){
		bal=bal+amt;
		System.out.println(" Amount is credited successfully in your ICICI account");
		checkBal();
	}
	void checkBal(){
		System.out.println("Your account balance is "+bal);
	}
	
}

class SBITrans extends BankTransaction{
	SBITrans(int bal){
		super(bal);
	}
	void withdraw(int amt){
		if(amt<=bal){
			bal=bal-amt;
			System.out.println(" Amount "+amt+"is debited from your SBI account");
			checkBal();
		}
		else{
			System.out.println("Sorry,your balance is insufficient!!!");
		}
	}
	void deposite(int amt){
		bal=bal+amt;
		System.out.println("Amount is credited successfully in your SBI account");
		checkBal();
	}
	void checkBal(){
		System.out.println("Your account balance is "+bal);
	}

}

class ATM{
	
	ATM(){
		
	}
	
	void forwithdraw(BankTransaction b){
		System.out.println("Enter the amount you want to withdraw?");
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		b.withdraw(amt);
		//sc.close();
	}
	
	void fordeposite(BankTransaction b){
		System.out.println("Enter the amount you want to deposite?");
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		b.deposite(amt);
		
	}
	
	void forcheckBal(BankTransaction b){
		b.checkBal();
	}
	
	
}



public class BankTrans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATM a = new ATM();
		System.out.println("Enter your choice:\n1.ICICI\n2.SBI\n");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice==1){
			ICICITrans i = new ICICITrans(0);
			char dec='y';
			do{
			System.out.println("Enter what do you want to do?");
			System.out.println("1.Deposite\n2.Withdraw\n3.Display");
			int ch = sc.nextInt();
			switch(ch){
				case 1: a.fordeposite(i);
						break;
				case 2:a.forwithdraw(i);
						break;
				case 3:a.forcheckBal(i);
						break;
				default:System.out.println("Invalid Choice");
						break;
			}
			
			System.out.println("Do you want to continue?[y/n]");
			dec = sc.next().charAt(0);
			
			}while(dec=='y');
		}else{
			SBITrans s = new SBITrans(0);
			char decide = 'y';
			do{
			System.out.println("Enter what do you want to do?");
			System.out.println("1.Deposite\n2.Withdraw\n3.Display");
			int ch = sc.nextInt();
			switch(ch){
			case 1: a.fordeposite(s);
					break;
			case 2:a.forwithdraw(s);
					break;
			case 3:a.forcheckBal(s);
					break;
			default:System.out.println("Invalid Choice");
					break;
			}
			System.out.println("Do you want to continue?[y/n]");
			decide=sc.next().charAt(0);
			}while(decide =='y');
		}
		sc.close();
	}

}
