import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Units {
	Scanner scU = new Scanner(System.in);
	private String unitID;
	private String unitName;
	private String studentNo;
	private String lastName;
	private String firstName;
	private String oneU;
	private String twoU;
	private String threeU;
	private String fourU;
	private String fiveU;
	private String one3;
	private String two3;
	private String three3;
	
	public void addUnits() {
		
		System.out.print(" \t Add Unit ID :- ");
	    unitID = scU.next();
		System.out.print(" \t Add Unit Name :- ");
		unitName = scU.next();
		System.out.print(" \t Add Student No :- ");
		studentNo = scU.next();
		System.out.print(" \t Add Last name :- ");
		lastName = scU.next();
		System.out.print(" \t Add First name :- ");
		firstName = scU.next();
		
		File file3 = new File("units.txt");
		FileWriter fw3 = null;
		PrintWriter pw3 = null;
		
		
		try {
			fw3 = new FileWriter(file3,true);
			pw3 = new PrintWriter(fw3, true);
			pw3.println();
			pw3.printf("%-18s%-18s%-18s%-18s%-18s",  unitID, unitName, studentNo, lastName, firstName );
		}catch (FileNotFoundException e) {
			
			System.err.println(" \t File not found please check the file");
				e.printStackTrace();
		} catch (IOException e) {
		
			System.err.println(" \t Somthing wrong within your IO");
				e.printStackTrace();
			}
		finally{
			try{
			fw3.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
			pw3.close();
			Interface begin9 = new Interface();
			begin9.main(null);
		}
		
	}
	
	
	public void searchUnits() {
		
	 	System.out.print(" \t Enter the UnitID:- ");
    	String userInput4 = scU.nextLine();
		File searchFile4 = new File("units.txt");
		try {
			Scanner input4 = new Scanner(searchFile4);
			String lineby3 = null;
			int count = 0;
			while(input4.hasNextLine()){
			    lineby3 = input4.nextLine();
			    ArrayList<String> words4 = new ArrayList<String>();
			    String[] lineby4 = lineby3.split(" \\s+");
			    for(String value : lineby4){
			    words4.add(value);
			    }
			    
			    for(int i = 0; i < lineby4.length; i++){
			    	if( lineby4[i].equals(userInput4)){
			            count++;
			    		System.out.println("\n");
			    		System.out.println(" \t UnitID : " + lineby4[i]);
			    		System.out.println(" \t Unit Name : " + lineby4[i + 1]);		    		
			    		System.out.println(" \t Student details : " +  lineby4[i + 2] + " " + lineby4[i + 3] + " " +  lineby4[i + 4] );
			    	}
			    }
			    
			}
			System.out.println(" \t Number of students : " + count);
		} catch (FileNotFoundException e) {
			System.err.println(" \t File not found!!!");
			
		}
		int c14 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c14 = scU.nextInt();
		}while( c14 != 1);
		switch(c14){
		case 1 : Interface begin14 = new Interface();
		         begin14.main(null);
		}
		
	}


	public void deleteUnits() {
		System.out.print(" \t Enter the exact Unit ID:- ");
    	String searchs4 = scU.nextLine();
		File searchFilede4 = new File("units.txt");
		File file4 = new File("TempU.txt");
		try {
			Scanner inputU = new Scanner(searchFilede4);
			String linede4 = null;
			int count4= 0;
			while(inputU.hasNextLine()){
			    linede4 = inputU.nextLine();
			    ArrayList<String> wordsde4 = new ArrayList<String>();
			    String[] line2de4 = linede4.split(" \\s+");
			    for(String value : line2de4){
			    wordsde4.add(value);
			    }
			    
			    for(int i = 0; i < wordsde4.size(); i++){
			    	
			    	if( line2de4[i].equalsIgnoreCase(searchs4)){
			    		wordsde4.clear();	
			    	}
			    	
			    }
			    
			    count4++;
			   
			    if(wordsde4.size() != 0){
		    		oneU = wordsde4.get(0);			        
			    	twoU = wordsde4.get(1);
			    	threeU = wordsde4.get(2);
			    	fourU = wordsde4.get(3);
			    	fiveU = wordsde4.get(4);
			    	
					FileWriter fwri4 = null;
					PrintWriter pwri4 = null;
					
					try {
						fwri4 = new FileWriter(file4,true);
						pwri4 = new PrintWriter(fwri4, true);
						pwri4.println();
						pwri4.printf("%-18s%-18s%-18s%-18s%-18s" , oneU , twoU , threeU , fourU , fiveU);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwri4.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(count4 == 3){
			    	break;
			    }
				}
			
			if(file4.renameTo(searchFilede4)){
				System.out.println("Success");
			}
			else{
				System.out.println("Failed");
			}
			searchFilede4.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c17 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c17 = scU.nextInt();
		}while( c17 != 1);
		switch(c17){
		case 1 : Interface begin17 = new Interface();
		         begin17.main(null);
		}
		
	}


	public void editUnits() {
		System.out.print(" \t Enter the detail you want to edit:- ");
    	String searchs1e3 = scU.nextLine();
    	System.out.print(" \t Enter the replacing word:- ");
    	String replaces3 = scU.nextLine();
		File searchFiledee3 = new File("units.txt");
		File filee3 = new File("Temp.txt");
		try {
			Scanner inputSe3 = new Scanner(searchFiledee3);
			String linedee3 = null;
			int counte3= 0;
			while(inputSe3.hasNextLine()){
			    linedee3 = inputSe3.nextLine();
			    ArrayList<String> wordsdee3 = new ArrayList<String>();
			    String[] line2dee3 = linedee3.split(" \\s+");
			    for(String value : line2dee3){
			    wordsdee3.add(value);
			    }
			    
			    for(int i = 0; i < wordsdee3.size(); i++){
			    	
			    	if( line2dee3[i].equalsIgnoreCase(searchs1e3)){
			    		String arrword3 = wordsdee3.get(i);
			    		System.out.println(arrword3);
			    		String replword3 = wordsdee3.get(i).replace(wordsdee3.get(i), replaces3);
			    		System.out.print(replword3);
			    		//= wordsdee.get(i).replace(wordsdee.get(i), replaces);	
			    		//System.out.print(wordsdee.get(i));
			    	}
			    	
			    }
			    
			    counte3++;
			   
			    if(wordsdee3.size() != 0){
		    		one3 = wordsdee3.get(0);			        
			    	two3 = wordsdee3.get(1);
			    	three3 = wordsdee3.get(2);
				    
					FileWriter fwrie3 = null;
					PrintWriter pwrie3 = null;
					
					try {
						fwrie3 = new FileWriter(filee3,true);
						pwrie3 = new PrintWriter(fwrie3, true);
						pwrie3.println();
						pwrie3.printf("%-20s%-20s%-20s" , one3 , two3 , three3);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwrie3.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(counte3 == 3){
			    	break;
			    }
				}
			
			if(filee3.renameTo(searchFiledee3)){
				System.out.println(":Success");
			}
			else{
				System.out.println(" Failed");
			}
			searchFiledee3.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c10 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c10 = scU.nextInt();
		}while( c10 != 1);
		switch(c10){
		case 1 : Interface begin10 = new Interface();
		         begin10.main(null);
		
	}

}
}