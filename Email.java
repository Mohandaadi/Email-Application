import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultpasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "xyzcompany.com";
	
	// Constructor to receive the first and last name
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your password is : "+this.password);
		
		// Combine elements to generate email 
		email = firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.println("New worker: "+firstName+". Department Codes: \n\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n\n Enter department code : ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "Sales";}
		else if (depChoice == 2) {return "Dev";}
		else if (depChoice == 3) {return "Acct";}
		else {return "";}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlterEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity+"mb";
	}
}
