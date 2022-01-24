package com.lockerspvtltd.sherwin;

import java.io.File;
import java.util.Scanner;

public class LockedMe {
	
	static final String projectFilesPath = "C:\\Users\\Roosewelt\\Desktop\\MyLockedMefile";
	
	static final String errorMessage = "Some error occured, please contact: admin@lockedme.help";
	
	public static void main(String args[]) {
		deleteFiles();
	}
	
	public static void displayMenu() {
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t\t\t-Created by Sherwin ");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("1.Display all the files");
		System.out.println("2.Create a new file");
		System.out.println("3.Delete a file");
		System.out.println("4.Search a file");
		System.out.println("5.Exit");
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
				for(int i = 0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile()) {
						System.out.println("File - " + listOfFiles[i].getName());
					}
				}
			}
		}
		
		catch(Exception ex) {
			System.out.println(errorMessage);
		}
	}
	
	public static void createFiles() {
		
	}

	/**
	 * this method will delete the files on the directory
	 */
	public static void deleteFiles() {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be deleted ");
			String fileName = sc.next();
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
	
	public static void searchFiles() {
		
	}
	
	
}
