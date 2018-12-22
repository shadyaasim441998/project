import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class operations {
	User user_obj=new User();
	String x;
	item item_obj=new item();
	File Item_file=new File("Item2.txt");
	Scanner input = new Scanner(System.in);
	
	ArrayList<item> Posted_Item_array= new ArrayList<>();
	public void get_data_from_file() throws IOException, ClassNotFoundException
	{	
		Scanner item=new Scanner(Item_file);
		
		while(item.hasNextLine())
		{
			item obj=new item();
			obj.name=item.nextLine();
			obj.type=item.nextLine();
			obj.color=item.nextLine();
			obj.location=item.nextLine();
			obj.phone_number=item.nextLine();
			Posted_Item_array.add(obj);
		}

	}
	public void post_an_item() throws IOException
	{
		
		
		PrintWriter write_item=new PrintWriter(new BufferedWriter(new FileWriter(Item_file, true)));
		char choise;
		System.out.println("please enter the number of the thing you found");
		System.out.println("1- Moblie "+ "\n"+ "2- ID"+ "\n"+ "3- Money"+ "\n"+ "4- Laptop"+ "\n"+ "5- Other");
		choise = (char) input.nextByte();
		if (choise == 1)
		{
			item_obj.name="Mobile";
			
		}
		else if (choise == 2)
		{
			item_obj.name="ID";
		}
		else if (choise == 3)
		{
			item_obj.name="Money"; 
		}
		else if (choise == 4)
		{
			item_obj.name="Laptop";
		}

		else if (choise == 5)
		{
			item_obj.name="Other";
		}
		write_item.println(item_obj.name);
		input.nextLine();
		System.out.println("enter the type of thing if it has or null");
		item_obj.type=input.nextLine().toLowerCase();
		write_item.println(item_obj.type);
		System.out.println("enter the color of thing if it has or null");
		item_obj.color=input.nextLine().toLowerCase();
		write_item.println(item_obj.color);
		System.out.println("enter the location which you have found the thing or null");
		item_obj.location=input.nextLine().toLowerCase();
		write_item.println(item_obj.location);
		System.out.println("enter your phone number");
		item_obj.phone_number=input.nextLine();
		write_item.println(item_obj.phone_number);
		
	
		
		Posted_Item_array.add(item_obj);
		
		write_item.close();
	}
	public void search_for_item()
	{	
		
		int choise;
		item item_obj=new item();
		System.out.println("What are you search for");
		System.out.println("1- Moblie "+ "\n"+ "2- ID"+ "\n"+ "3- Money"+ "\n"+ "4- Laptop"+ "\n"+ "5- Other");
		choise = (char) input.nextByte();
		if (choise == 1)
		{
			item_obj.name="Mobile";
			
		}
		else if (choise == 2)
		{
			item_obj.name="ID";
		}
		else if (choise == 3)
		{
			item_obj.name="Money"; 
		}
		else if (choise == 4)
		{
			item_obj.name="Laptop";
		}
		input.nextLine();
		System.out.println("enter the type of thing if it has or null");
		item_obj.type=input.nextLine().toLowerCase();
		System.out.println("enter the color of thing if it has or null");
		item_obj.color=input.nextLine().toLowerCase();
		System.out.println("enter the location which you have found the thing or null");
		item_obj.location=input.nextLine().toLowerCase();
		
		for (int i=0;i<Posted_Item_array.size();i++)
		{
			if (Posted_Item_array.get(i).name.equals(item_obj.name))
			{
				if ((Posted_Item_array.get(i).type.equals(item_obj.type))||(Posted_Item_array.get(i).type.equals(null))&&(Posted_Item_array.get(i).color.equals(item_obj.color))||(Posted_Item_array.get(i).color.equals(null))&&(Posted_Item_array.get(i).location.equals(item_obj.location))||(Posted_Item_array.get(i).location.equals(null)))
				{
					System.out.println("we found your item and you can contact with "+ Posted_Item_array.get(i).phone_number);
				}
				else
				{
					System.out.println("we can't find your item");
				}
			}
			else
			{
				System.out.println("we can't find your item");
			}
		}
	}
	public void clean_file() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(Item_file);
		writer.print("");
		writer.close();
	}

}
