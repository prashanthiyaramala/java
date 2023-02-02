package MyGits;

import java.util.Scanner;
public class Transaction 
{
	static Accounts ac[];
	static Customer cs[];
	static int i;
	static int j;
	static Scanner sc;
	
	static
	{
		ac = new Accounts[50];
		cs = new Customer[3];		
		i=0;
		j=0;
	}
	
		
	static boolean openaccount()
	{
		System.out.println("\n\t Register Customer   ");
		System.out.println("\n Customer ID : " + (i+1));
		
		cs[i] = new Customer();
		cs[i].custid=i;
		
		System.out.println("\n Name : ");
		cs[i].name = sc.next();
		
		System.out.println("\n Email : ");
		cs[i].email = sc.next();
		
		System.out.println("\n Contact : ");
		cs[i].contact = sc.next();
		

		System.out.println("Initial Amount to open A/C   : ");
		cs[i].initial_amt = sc.nextLong();
		cs[i].total_amt = cs[i].initial_amt;
		
		try {
		Thread.sleep(2000);}catch(Exception e) {}
		
		
		cs[i].accno = (i+1)*10;
		System.out.println("Generated Account No - "+ cs[i].accno);
						
		i++;
		
		return true;
		
	}
	
	static void deposit()
	{	
		int flag=0;
		int v=0;
		
		System.out.println("\n\n\t\tDeposit Amount");
		
		ac[j] = new Accounts();
		
		System.out.println("A/C No  : ");
		ac[j].accno  = sc.nextInt();
		
		
		for(Customer c : cs)
		{
			if(c.accno == ac[j].accno)
			{
				flag=1;
				break;
			}
			
			v++;
		}
					
		if( flag ==1 )
		{
			try {
				Thread.sleep(1000);}catch(Exception e) {}
						
			System.out.println("Enter Amount : ");
			ac[j].amount = sc.nextLong();
			
			cs[v].total_amt = cs[v].total_amt +ac[j].amount;
			
			ac[j].trans_type="Deposit";
			
			j++;
		}
		else
		{
			System.out.println("Accnount number not exist! ");			
		}
	}
	
	static void withdraw()
	{	
		int flag=0;
		int v=0;
		
		System.out.println("\n\n\t\tWithdraw Amount");
		
		ac[j] = new Accounts();
		
		System.out.println("A/C No  : ");
		ac[j].accno  = sc.nextInt();
		
		
		for(Customer c : cs)
		{
			if(c.accno == ac[j].accno)
			{
				flag=1;
				break;
			}
			v++;
		}
					
		if( flag ==1 )
		{
			try {
				Thread.sleep(1000);}catch(Exception e) {}
						
			System.out.println("Enter Amount : ");
			ac[j].amount = sc.nextLong();
				if(cs[v].total_amt > ac[j].amount)
					{
					cs[v].total_amt = cs[v].total_amt - ac[j].amount;
					}
				else
				{
					System.out.println("Not a sufficient amount! ");
					System.exit(0);
				}
			ac[j].trans_type="Withdraw";
			j++; 
		}
		else
		{
			System.out.println("Account number not exist! ");			
		}
	}
	
	static void customers()
	{
		System.out.println("\n\n\tCustomer Details \n");
		System.out.println("\t");
		for(Customer c : cs)			
		{
			System.out.printf("%-15d|%-15d|%-15s|%-15s|%-15s|%-15d\n",c.accno,c.custid,c.name,c.email,c.contact,c.total_amt);
		
		}
	}
	
	static int search()
	{
		int accno,v=0;
		System.out.println("\n\tA/C No  : ");
		accno = sc.nextInt();
		
		for(Customer c : cs)			
		{
			if(c.accno == accno)
			{
				return v;				
			}
			v++;
		}
		
		return -1;
	}
	
	
	
	
	
	public static void main(String... g)
	{	
		int ch;	
		String ans="";
		
		Transaction.sc = new Scanner(System.in);
		
		
		while(true)
		{
		System.out.println("\t\tMain Menu\n \t\t1:Open Account");
		System.out.println("\t\t2:Deposit\n\t\t3:Withdraw\n\t\t4:Customers");
		System.out.println("\t\t5:Search Customer\n\t\t6:Exit");
		
		System.out.println("\t Enter your choice : ");
		
		ch = sc.nextInt();
		
				
		switch(ch)
		{
			case 1:
					System.out.println(openaccount()?"Account is Open and Customer Registration is done":"Invalid details");
					break;
			case 2:
				
					deposit();
					break;
			case 3:
					withdraw();
					break;
			case 4:
					customers();
					break;
			case 5:
					int s = search();
					System.out.println("Account No : "+cs[s].accno);
					System.out.println("Customer Id : "+cs[s].custid);
					System.out.println("Name : "+cs[s].name);
					System.out.println("Email : "+cs[s].email);
					System.out.println("Contact : "+cs[s].contact);
					System.out.println("Total Amount : "+cs[s].total_amt);
					break;
			case 6: 
					System.exit(0);
					break;
						
		}
			System.out.println("\n\n\t Do  you want to continue [Y/y] : ");
			ans = sc.next();
			if(ans.equals("N") || ans.equals("n"))
					{
						try {
								Thread.sleep(1500);}catch(Exception e) {}
						System.out.println("Exit From a System ! ");
						System.exit(0);
					}
		}
		
		
	}

}
