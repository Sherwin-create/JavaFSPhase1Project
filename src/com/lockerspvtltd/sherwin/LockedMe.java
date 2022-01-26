package com.lockerspvtltd.sherwin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LockedMe {

	static final String PROJECTFILESPATH = "C:\\Users\\Roosewelt\\Desktop\\MyLockedMefile";

	static final String ERRORMESSAGE = "Sorry :\\ . \n"
			+ "Some error occured, please contact: admin@lockedme.help";
	
	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t\t\t-Created by Sherwin ");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		
		//Scanner CONSOLE = new Scanner(System.in);
		try {
			int ch = 0;
			do{
				displayMenu();
				System.out.println("Enter your choice ");
				boolean isAnInt = CONSOLE.hasNextInt();
	
				if(isAnInt) {
					ch = CONSOLE.nextInt();
					switch(ch) {
					
					case 1: getAllFiles();
					break;
					
					case 2: createFiles();
					break;
					
					case 3: deleteFiles();
					break;
					
					case 4: searchFiles();
					break;
					
					case 5:System.out.println("Bye Bye... \n"+
												"Program exited");
						   System.exit(ch);
					
					default:System.out.println("Enter valid option");
					break;
					}
				
				}
				else {
					System.out.println("Invalid number");
				}
				CONSOLE.nextLine();
				
			}while(true);
		}
		catch(Exception ex) {
			System.out.println("Enter only numbers from (1 - 5 ) ");
			System.out.println("Exited from the program " +ex);
		}
		finally {
			CONSOLE.close();
		}
	
	}

	public static void displayMenu() {
		System.out.println();
		System.out.println("1.Display all the files");
		System.out.println("2.Create a new file");
		System.out.println("3.Delete a file");
		System.out.println("4.Search a file");
		System.out.println("5.Exit");
		System.out.println();
	}

	/**
	 * This method returns all the files in an directory
	 */
	public static void getAllFiles() {
		try {

			File folder = new File(PROJECTFILESPATH);
			File[] listOfFiles = folder.listFiles();

			if( listOfFiles.length==0) {
				System.out.println("No files in this directory - "+ PROJECTFILESPATH);
			}
			else {
				for(int i = 0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile()) {
						System.out.println("File - " + listOfFiles[i].getName());
					}
				}
			}
		}

		catch(Exception ex) {
			System.out.println(ERRORMESSAGE);
		}
	}

	/**
	 * this method creates new files into the directory
	 */
	public static void createFiles() {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter your filename");
		String fileName= sc.next();
		System.out.println("enter the number of lines you would like to insert to your file");
		int line= Integer.parseInt(sc.next());
		try {
			FileWriter writeInto= new FileWriter(PROJECTFILESPATH+"\\"+fileName);
			for(int i=1;i<=line;i++) {
				System.out.println("Enter line "+i);
				writeInto.write(sc.next()+"\n");
				
			}
			System.out.println("file added");
			writeInto.close();
			
		}
		catch (IOException e) {
			System.out.println(ERRORMESSAGE);
		}
	}

	/**
	 * this method will delete the files on the directory
	 */
	
	public static void deleteFiles() {
		//Scanner CONSOLE = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be deleted ");
				String fileName = CONSOLE.next();
			
			File folder = new File(PROJECTFILESPATH + "\\" + fileName);
			if(folder.exists()) {
				folder.delete();
				System.out.println("File "+ fileName+ " deleted sucessefully " );
			}
			else {
				System.out.println("Failed to delete the file");
			}	
		}
		catch(Exception ex) {
			System.out.println(ERRORMESSAGE);
		}
	}
	
	/**
	 * this method checks whether the entered file is available or not in the directory
	 */
	public static void searchFiles() {
		//Scanner CONSOLE = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be searched ");
			String fileName = CONSOLE.next();

			File folder = new File(PROJECTFILESPATH);
			File[] listOfFiles = folder.listFiles();

			LinkedList<String> fileNames = new LinkedList<String>();
			 for(File l:listOfFiles) {
				 fileNames.add(l.getName());
			 }

			 if(fileNames.contains(fileName)) {
				 System.out.println(fileName+" found");
			 }
			 else {
				 System.out.println("The file you are looking for is not in this directory");
			 }

		}
		catch(Exception ex) {
			System.out.println(ERRORMESSAGE);
		}
	}
}