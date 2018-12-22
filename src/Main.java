import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner input=new Scanner(System.in);
		int choise;
		User user_obj=new User();
		operations operations_obj=new operations();
		
		user_obj.read_user_data_from_files();
		operations_obj.get_data_from_file();
		int flag =0;
		while(true){
			System.out.println("please enter your choise");
			System.out.println("1 - Sign up");
			System.out.println("2 - Log in");
			System.out.println("3 - Post an item");
			System.out.println("4 - Search for item");
			System.out.println("5 - Remove data from files");
			System.out.println("10 - Exit");
			choise=input.nextInt();
			
			if (choise==1)
			{
				user_obj.sign_up();
				flag =1;
		    }
			
			else if (choise==2)
			{
				user_obj.log_in();;
				flag =1;
		    }
			else if (choise==3)
			{
				if (flag == 1)
				operations_obj.post_an_item();
				else
					System.out.println("Sorry, you should login first");
		    }
			else if (choise ==4)
			{
				if (flag ==1)
				operations_obj.search_for_item();
				else
					System.out.println("Sorry, you should login first");
			}
			else if (choise == 5)
			{
				operations_obj.clean_file();
				user_obj.clean_file();
			}
			else if(choise==10)
			{
				System.exit(0);
			}
		}
	}

}
