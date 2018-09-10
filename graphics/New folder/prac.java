package graphics;
import java.util.*;
import java.io.*;
public class prac {
	public static void main(String [] args) {
		
		try
		{
		File f= new File("coordinates.txt");
		Scanner sc= new Scanner(f);
		
		while(sc.hasNextLine())
		{
			System.out.println(sc.next());
		}
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
		
		
	}

}
