/**
 * 
 * @author Jamey Dogom
  * purpose: test a cicular linked list with a simulating a line rollercoster
 * 
 */

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	static CLLOfRiders list;
	static String outputFile = "output.txt";
	
	public static void main(String ags[]) {
		System.out.println("Welcome to Project 2.");
		System.out.println("What is the name of the data file?");
		System.out.print(">");
		String fileName = new Scanner(System.in).nextLine();
		list = new CLLOfRiders();
		readFile(fileName);
		System.out.println();
		System.out.println("Finished reading the file.");
		System.out.println();
		
		while (true) {
			System.out.println("Next command");
			System.out.print(">");
			String command = new Scanner(System.in).nextLine();
			System.out.println();
			
			if (command.contains("help")) {
				System.out.println("Legal commands:");
				System.out.println("add rider");
				System.out.println("show line");
				System.out.println("process n");
				System.out.println("quit");				
			}
			if (command.contains("add")) {
				System.out.println("Name");
				System.out.print(">");
				String name = new Scanner(System.in).nextLine();
				System.out.println("SpeedPass");
				System.out.print(">");
				String speedPass = new Scanner(System.in).nextLine();
				char sp = speedPass.charAt(0);
				Rider rider = new Rider(name, sp);
				list.addRider(rider);
			}
			if (command.contains("show")) {
				list.showWaiting();
			}
			if (command.contains("process")) {
				String[] ss = command.split(" ");
				int n = Integer.parseInt(ss[1]);
				list.processRiders(n);
			}
			if (command.contains("quit")) {
				System.out.println("Writing to file. Goodbye.");
				writeFile(outputFile);
				break;
			}
			System.out.println();
		}
	}
	
	public static void readFile(String fileName) {
		try {
			Scanner scanner = new Scanner(new FileInputStream(fileName));
			do {
				String line = scanner.nextLine();
				Rider rider = new Rider(null, 'u');
				int index = 0;
				for (int i=line.length() - 1; i>=0; i--) {
					if (line.charAt(i) == 'Y' || line.charAt(i) == 'N') {
						rider.speedPassStatus = line.charAt(i);
						index = i;
						break;
					}
				}
				for (int i=index; i>=0; i--) {
					if (line.charAt(i) == '-') {
						index = i;
						break;
					}
				}
				rider.name = line.substring(0, index - 1);
				list.addRider(rider);
			} while (scanner.hasNextLine());	 
		}
		catch (IOException ex) {
		ex.printStackTrace();
		}
	}
	
	public static void writeFile(String fileName)
	{
		try{
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(list.listString());
			out.close();
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
