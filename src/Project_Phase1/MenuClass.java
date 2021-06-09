package Project_Phase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuClass {
	
	public static void welcomeScreen() {
		
		System.out.println("--------------------------------------------\n"+ "Welcome to LockedMe.com.\n"+ 
		"Developed by Vaibhav Agrawal. \n"+ "------------------------------------------------");
		System.out.println("You can use this application to : \n" + "1. Retrieve all file names in ascending order. \n"+ 
		"2. Add/Search/Delete User specified files. \n"+ 
		"3. Exit the Application. \n");
		System.out.println("------------------------------------------");
		
	}
	
	
	public static void display() {
		String m= "\n\n ----------------------------------- \n Select any number from (1-3) \n"+
	" 1. Retrieve all files. \n 2. Add/Search/Delete file to folder. \n 3. Exit The Application. \n";
		System.out.println(m);
	}
	public static void DisplayMenu() {
		String m1="\n\n Select number from 1-5. \n"+ 
	" 1. Add a file to folder. \n" +" 2. Delete a file from folder. \n"
				+ " 3. Search a file in folder. \n 4. Go to previous menu. \n 5. Exit \n";
		System.out.println(m1);
	}
	public static void handleInput() {
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the root directory for all future operations: ");
		String root_dir = sc.nextLine();
		while(flag==true) {
			try {
				display();
				int in=sc.nextInt();
				if(in==1) {
					FileOperation.displayFiles(root_dir);
					//break;
				}
				else if(in==2) {
				    handleMenuInput(sc,root_dir);
					//break;
				}
				else if(in==3) {
					System.out.println("Exit Successful");
					flag=false;
					sc.close();
					System.exit(0);
					//break;
				}
				else {
					System.out.println("Enter valid option");
					
				}
				
			} catch(Exception e) {
				System.out.println("Exception occurred: "+ e.getClass().getName());
				handleInput();
				
			}
		}
	}
	
	public static void handleMenuInput(Scanner sc, String root_dir) {
		//Scanner sc1 = new Scanner(System.in);
		
		boolean flag=true;
		
		while(flag) {
			try {
				DisplayMenu();
				//FileOperation.createMain("main");
				int in=sc.nextInt();
				if(in==1) {
					System.out.println("Enter the name of the file to be added");
					String fileName = sc.next();
					
					
					FileOperation.createFile(root_dir,fileName);
					//FileOperations.createFile(fileName,sc);
				}
				else if(in==2) {
					System.out.println("Enter the name of the file to be deleted ");
					String fileName = sc.next();
					//FileOperation.createMain("main");
					FileOperation.deleteFile(fileName, root_dir);
					
					
					
				}
				else if(in==3) {
					System.out.println("Enter the name of the file to be searched ");
					String fileName = sc.next();
					List<String> li= new ArrayList<>();
					li=FileOperation.searchFile(fileName, root_dir);
					for(String l:li) {
						System.out.println(l);
					}
				}
				else if(in==4) {
					return;
				}
				else if(in==5) {
					System.out.println("Program exited successfully.");
					flag = false;
					sc.close();
					System.exit(0);
				}
				else {
					System.out.println("Enter valid option");
					
				}
				
			} catch(Exception e) {
				System.out.println("Exception occurred: "+ e.getClass().getName());
				//handleMenuInput();
			}
		}
	}

}
