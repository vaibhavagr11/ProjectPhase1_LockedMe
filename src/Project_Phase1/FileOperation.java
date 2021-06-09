package Project_Phase1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class FileOperation {
	public static void displayFiles(String path) {
		
		
		System.out.println("Displaying in Ascending order");
		
	    try {
	    	File dir= new File(path);
			File[] arr = dir.listFiles();
			if (arr != null && arr.length > 0) {
				Arrays.sort(arr);
				TreeSet<String> tree = new TreeSet<String>();
				for (File file : arr) {
					if (file.isFile()) {
						tree.add(file.getName());
					}
				}
				
				int counter = 1;
				for(String tr:tree) {
					System.out.println("File " + counter + ": " + tr);
					counter++;
				}
				
			}
			else {
				System.out.println("----- Empty Directory -----");
			}
	    	
	    } catch(Exception e) {
	    	System.out.println("Exception occurred: "+ e.getClass().getName());
	    }
		
		
	}
	
	public static void createFile(String path, String name) {
		try {
			Path filePath = Paths.get(path, name);
			File file = new File(filePath.toString());
			
			
				boolean result = file.createNewFile();
				
				if (result) {
					System.out.println("File Created Successfully: " + file.getCanonicalPath() + "\n");
				} else {
					System.out.println("File already exists\n");
				}
				
			
		} 
		catch(Exception e) {
			System.out.println("Exception occurred: "+ e.getClass().getName());
		}
		
		
	}
	
	public static List<String> searchFile(String name, String path) {
		
			List<String> names=new ArrayList<>();
			File dir = new File(path);
			File[] files = dir.listFiles();
			List<File> filesList = Arrays.asList(files);
			if (files != null && files.length > 0) {
				for (File file : filesList) {

					if (file.getName().equals(name)) {
						names.add(file.getAbsolutePath());
					}
				}
			}
			
		return names;
			
	} 
		
		
		
	
	
	public static void deleteFile(String name, String path) {
		try {
			
			File file = new File(Paths.get(path, name).toString());
			
			if (file.delete()) {
				System.out.println("File deleted successfully\n");
			} else {
				System.out.println("Unable to delete file\n");
			}
			
		} catch(Exception e) {
			System.out.println("Exception occurred: "+ e.getClass().getName());
		}
		
	}
}
	
		

