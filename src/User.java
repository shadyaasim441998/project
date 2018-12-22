import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	
	protected String Email;
	protected String User_name;
	protected String password;
	protected String confirm_password;
	protected String phone_number;
	protected String gender;
	
	public ArrayList<String> Email_array=new ArrayList<>();
	public ArrayList<String> User_name_array=new ArrayList<>();
	public ArrayList<String> Password_array=new ArrayList<>();
	public ArrayList<String> Phone_number_array=new ArrayList<>();
	public ArrayList<String> gender_array=new ArrayList<>();
	
	File Email_file=new File("E-mail.txt");
	File User_name_file=new File("User_name.txt");
	File Password_file=new File("Password.txt");
	File Phone_number_file=new File("phone_number.txt");
	File gender_file=new File("gender.txt");
	
	Scanner input=new Scanner(System.in);
	

	public void read_user_data_from_files() throws FileNotFoundException
	{
		Scanner Email=new Scanner(Email_file);
		Scanner user_name=new Scanner(User_name_file);
		Scanner Password=new Scanner(Password_file);
		Scanner phone_number=new Scanner(Phone_number_file);
		Scanner gender=new Scanner(gender_file);
		while (Email.hasNextLine())
		{
			String x=Email.nextLine();
			Email_array.add(x);
		}
		while (user_name.hasNextLine())
		{
			String x=user_name.nextLine();
			User_name_array.add(x);
		}
		while (Password.hasNextLine())
		{
			String x=Password.nextLine();
			Password_array.add(x);
		}
		while (phone_number.hasNextLine())
		{
			String x=phone_number.nextLine();
			Phone_number_array.add(x);
		}
		while (gender.hasNextLine())
		{
			String x=gender.nextLine();
			gender_array.add(x);
		}
		
	}
	public void enter_email() throws IOException 
	{
 		PrintWriter write_Email=new PrintWriter(new BufferedWriter(new FileWriter(Email_file, true)));
		System.out.println("enter your E-mail");
		Email=input.nextLine();
		while (!Email.contains("@")||!Email.contains(".")||(Email.indexOf(".")<Email.indexOf("@"))||Email_array.contains(Email))
		{
			
				System.out.println("your E-mail maybe invalid or used before ... please enter correct E-mail");
				Email=input.nextLine();
			
		}
		Email_array.add(Email);
		write_Email.println(Email);
		
		write_Email.close();
		
	}
	public void enter_username() throws IOException
	{
		PrintWriter write_user_name=new PrintWriter(new BufferedWriter(new FileWriter(User_name_file, true)));
		System.out.println("enter your user name");
		User_name=input.nextLine();
		while (User_name_array.contains(User_name))
		{
			
				System.out.println("your E-username is invalid ... please enter correct E-username");
				User_name=input.nextLine();
			
		}
		User_name_array.add(User_name);
		write_user_name.println(User_name);
		
		write_user_name.close();
		
	}
	public void enter_password() throws IOException
	{
		PrintWriter write_Password=new PrintWriter(new BufferedWriter(new FileWriter(Password_file, true)));
		System.out.println("enter your password");
		password=input.nextLine();
		System.out.println("enter your password again");
		confirm_password=input.nextLine();
		while (!password.equals(confirm_password))
		{
			
				System.out.println("your password is wrong ... please enter your password again");
				password=input.nextLine();
				System.out.println("enter your password again");
				confirm_password=input.nextLine();
			
		}
		Password_array.add(password);
		write_Password.println(password);
		
		write_Password.close();
		
	}
	public void enter_phone_number() throws IOException
	{
		PrintWriter write_Phone_number=new PrintWriter(new BufferedWriter(new FileWriter(Phone_number_file, true)));
		System.out.println("enter your phone number");
		phone_number=input.nextLine();
		
		while (Phone_number_array.contains(phone_number))
		{
			
				System.out.println("your phone is already used ... enter correct number");
				phone_number=input.nextLine();
			
		}
		Phone_number_array.add(phone_number);
		write_Phone_number.println(phone_number);
		
		write_Phone_number.close();
	}
	public void enter_gender() throws IOException
	{
		int choise;
		PrintWriter write_gender=new PrintWriter(new BufferedWriter(new FileWriter(gender_file, true)));
		System.out.println("choose your gender");
		System.out.println("1-Male");
		System.out.println("2-Female");
		choise=input.nextInt();
		
		while((choise!=1)&&(choise!=2))
		{
			System.out.println("please choose correct choise");
			System.out.println("1-Male");
			System.out.println("2-Female");
			choise=input.nextInt();
		}
		if (choise==1)
		{
			gender="Male";
		}
		else
		{
			gender="Female";
		}
		
		gender_array.add(gender);
		write_gender.println(gender);
		
		write_gender.close();
	}
	public void sign_up() 

	
	{try{
		
		enter_email();
		enter_username();
		enter_password();
		enter_phone_number();
		enter_gender();
		
		
		
		
	}catch(Exception e){System.out.println("there is some error");}}
	public void log_in()
	{
		String un,pw;
		System.out.println("enter your username");
		//input.nextLine();
		un=input.nextLine();
		while (!User_name_array.contains(un)&&!Email_array.contains(un))
		{
			System.out.println("Not found ... enter correct username");
			un=input.nextLine();
		}
	
		System.out.println("enter your password");
		pw=input.nextLine();
		while ((!pw.equals(Password_array.get(User_name_array.indexOf(un)))))
				{
					System.out.println("you enterd wrong password ... enter corret password");
					pw=input.nextLine();
				}
		
	}
	public void clean_file() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(Email_file);
		PrintWriter writer1 = new PrintWriter(User_name_file);
		PrintWriter writer2 = new PrintWriter(Password_file);
		PrintWriter writer3 = new PrintWriter(gender_file);
		PrintWriter writer4 = new PrintWriter(Phone_number_file);
		writer.print("");writer1.print("");writer2.print("");writer3.print("");writer4.print("");
		writer.close();writer1.close();writer2.close();writer3.close();writer4.close();
	}
	
}
