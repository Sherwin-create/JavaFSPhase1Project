package com.lockerspvtltd.sherwin;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	
	static final String projectFilesPath = "C:\\Users\\Roosewelt\\Desktop\\MyLockedMefile";
	
	static final String errorMessage = "Some error occured, please contact: admin@lockedme.help";
	
	public static void main(String args[]) {
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t\t\t-Created by Sherwin ");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		
		Scanner sc = new Scanner(System.in);
		int ch ;
		do
		{
			displayMenu();
			System.out.println("Enter your choice ");
			ch = sc.nextInt();
				
				switch(ch) {
					case 1: getAllFiles();
					break;
					
					case 2: createFiles();
					break;
					
					case 3: deleteFiles();
					break;
					
					case 4: searchFiles();
					break;
					
					case 5:System.out.println("Exited from the program");
						System.exit(0);
						break;
						
					default:System.out.println("Enter valid option");
					break;
				}
			}while(ch>0);
		}
		
	
	public static void displayMenu() {
		
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
			
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			if( listOfFiles.length==0) {
				System.out.println("Files doesn't exist in this directory - "+ projectFilesPath);
			}
			else {
				System.out.println("Files in the directory - "+projectFilesPath);
				for(int i = 0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile()) {
						System.out.println(listOfFiles[i].getName());
					}
				}
			}
		}
		
		catch(Exception ex) {
			System.out.println(errorMessage);
		}
	}
	
	public static void createFiles() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the filename to be created ");
			String fileName = sc.nextLine();
			
		    File myObj = new File(projectFilesPath+"//" + fileName);
		    if (myObj.createNewFile()) {
		    	System.out.println("File created: " + myObj.getName());
		      }
		    else {
		        System.out.println("File already exists.");
		      }
		    }
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}

	/**
	 * this method will delete the files on the directory
	 */
	public static void deleteFiles() {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be deleted ");
			String fileName = sc.nextLine();
			File folder = new File(projectFilesPath + "\\" + fileName);
			if(folder.exists()) {
				folder.delete();
				System.out.println("File deleted sucessefully " + fileName);
			}
			else {
				System.out.println("Failed to delete the file");
			}
		}
		catch(Exception ex) {
			System.out.println(errorMessage);
		}
		finally {
			sc.close();
		}
	}
	
	/**
	 * This method search the user specifies file name in the directory
	 */
	public static void searchFiles() {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be searched ");
			String fileName = sc.nextLine();
			
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			LinkedList<String> fileNames = new LinkedList<String>();
			 for(File l:listOfFiles) {
				 fileNames.add(l.getName());
			 }
			 
			 if(fileNames.contains(fileName)) {
				 System.out.println("file is available");
			 }
			 else {
				 System.out.println("File is not available, please check if the file exists or not");
			 }
		
		}
		catch(Exception ex) {
			System.out.println(errorMessage);
		}
		finally {
			sc.close();
		}
	}
}
	
	

