package com.lockerspvtltd.sherwin;

import java.io.File;
import java.io.FileWriter;

import java.util.*;

public class LockedMe {

	static final String PROJECTFILESPATH = "C:\\Users\\Roosewelt\\Desktop\\MyLockedMefile";

	static final String ERRORMESSAGE = "Sorry :\\  \n"
			+ "Some error occured, please contact: admin.help@lockedme.com";
	
	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\t\tWelcome to Lockedme.com\n");
		System.out.println("\t\t\t\t-Designed by Sherwin Dcosta ");
		System.out.println("\t\t\t\t-email: sherwindcosta18@gmail.com ");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		
		System.out.println();
		System.out.println("# This program helps you to display files, create files, search files \nand delete files on your machine. \n");
		
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
					
					case 2: businessMenu();
							break;
					case 3:System.out.println("Thank you for using lockedMe.com\n"+
							                  "Bye Bye... \n"+
											  "Program exited");
						   System.exit(ch);
					}
				
				}
				else {
					System.out.println("Please enter only integer ");
				}
				CONSOLE.nextLine();
				
			}while(true);
		}
		catch(Exception ex) {
			System.out.println(ERRORMESSAGE);
			System.out.println("Exited from the program " +ex);	
		}
		finally {
			CONSOLE.close();
		}
	
	}
	
	/**
	 * this method displays menu operations
	 */
	public static void displayMenu() {
		System.out.println();
		System.out.println("Main menu - ");
		System.out.println("1.Display all the files");
		System.out.println("2.Business level operation - add, delete & create files");
		System.out.println("3.Exit");
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
		System.out.println("enter your filename");
		String fileName= CONSOLE.next();

		System.out.println("enter the number of lines you would like to insert on your file");
		boolean cIsAnInt = CONSOLE.hasNextInt();
		try {
			if(cIsAnInt) {
				int line= Integer.parseInt(CONSOLE.next());
				
				FileWriter writeInto= new FileWriter(PROJECTFILESPATH+"\\"+fileName);
					
				for(int i=1;i<=line;i++) {
					System.out.println("Enter line "+i);
					writeInto.write(CONSOLE.next()+"\n");
				}
				System.out.println("New file created with the name " + fileName);
				System.out.println();
				writeInto.close();
			}
			else {
				System.out.println("Please enter only integer");
			}
			CONSOLE.nextLine();
			CONSOLE.nextLine();
		}
		catch(Exception ex){
			System.out.println(ERRORMESSAGE);
		}
	}

	/**
	 * this method will delete the files on the directory
	 */
	
	public static void deleteFiles() {
		try {
			System.out.println("Enter the file name to be deleted ");
			String fileName = CONSOLE.next();
			
			File folder = new File(PROJECTFILESPATH + "\\" + fileName);
			
			if(folder.exists()) {
				folder.delete();
				System.out.println("File - "+ fileName+ " deleted sucessefully " );
			}
			else {
				System.out.println("Failed to delete the file");
			}
			System.out.println();
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
				 System.out.println(fileName+" file found");
			 }
			 else {
				 System.out.println("Sorry :( \n"+	"The file you are looking for is not in this directory");
			 }
			 System.out.println();
		}
		catch(Exception ex) {
			System.out.println(ERRORMESSAGE);
		}
	}
	
	/**
	 * this method performs the operation of business menu
	 */
	public static void businessMenu(){
		 boolean leave = true;
			while(leave) {
				System.out.println();
				System.out.println("Business operations - ");
				System.out.println("1.Create a new file");
				System.out.println("2.Delete a file");
				System.out.println("3.Search a file");
				System.out.println("4.Return to the main menu");
				System.out.println();
				 
				System.out.println("Enter your choice");
				boolean bIsAnInt = CONSOLE.hasNextInt();
				
				if(bIsAnInt){
					int businessCh = CONSOLE.nextInt();	
					if(businessCh == 1) {
						createFiles();
						continue;
					}
					else if(businessCh == 2) {
						deleteFiles();
						continue;
					}
					else if(businessCh == 3) {
						searchFiles();
						continue;
					}
					else if(businessCh == 4) {
						System.out.println("Returned to the main menu");
						leave = false;
						break;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				else {
					System.out.println("enter only integer");
					System.out.println();
				}
				CONSOLE.nextLine();
				CONSOLE.nextLine();
			}
	}
}