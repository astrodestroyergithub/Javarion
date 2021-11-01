import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFLister {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Take the path of the folder form the user
		System.out.println("Enter the path of the directory: ");
		String path = sc.nextLine();
		
		// These 2 arraylists will hold the names of the files and the directories
		ArrayList<String> fileNames = new ArrayList<String>();
		ArrayList<String> dirNames = new ArrayList<String>();

		// Initialize the necessary variables for later use
		String fileSeq = new String("File ");
		String dirSeq = new String("Directory ");
		String toFileName, toDirName;
		File sourceFile, destFile, sourceDir, destDir;
		int fileNum=0, dirNum=0;
		
		// List the names of all the files in the specified directory
		File[] files = new File(path).listFiles();

		for (File item : files) {
			
			// Check whether item is a file or not
		    if (item.isFile()) {
		        fileNames.add(item.getName());
		    }
		    
		    // Check whether item is a directory or not
		    if (item.isDirectory()) {
		    	dirNames.add(item.getName());
		    }
		}
		
		System.out.println("\nThe renamed file names are:\n");
		
		System.out.println("========================================");
		
		for(String temp : fileNames) {
			
			toFileName = fileSeq+Integer.toString(++fileNum);
			
			int indexOfDot = temp.lastIndexOf('.');
			if(indexOfDot > 0) {
				toFileName += new String("."+temp.substring(indexOfDot+1));
			}
			
			sourceFile = new File(path+temp);
			destFile = new File(path+toFileName);
			
			boolean flag = sourceFile.renameTo(destFile);
			
			if(flag == true) 
				System.out.println(temp+" is renamed to "+toFileName);
			else
				System.out.println(temp+" couldn't be renamed to "+toFileName);
			
		}
		
		System.out.println("========================================\n");
		
		System.out.println("The renamed directory names are:\n");
		
		System.out.println("========================================");
		
		for(String temp : dirNames) {
			
			toDirName = dirSeq+Integer.toString(++dirNum);
			
			sourceDir = new File(path+temp);
			destDir = new File(path+toDirName);
			
			boolean flag = sourceDir.renameTo(destDir);
			
			if(flag == true) 
				System.out.println(temp+" is renamed to "+toDirName);
			else
				System.out.println(temp+" couldn't be renamed to "+toDirName);
			
		}
		
		System.out.println("========================================\n");
	}
}
