import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Lecturer {
	private String unitID;
	private String unitName;
	private String roomNo;
	private String roomName;
	private String lecturerName;
	private int capacityRoom;
	private int studentsNumber;
	Scanner scL = new Scanner(System.in);
	private String oneL;
	private String twoL;
	private String threeL;
	private String fourL;
	private String fiveL;
	private String sixL;
	private String sevenL;
	private String one1;
	private String two1;
	private String three1;

	public void addLecturer() {
		System.out.print(" \t Add Unit ID :- ");
	    unitID = scL.next();
		System.out.print(" \t Add Unit name :- ");
		unitName = scL.next();
		System.out.print(" \t Add Room No :- ");
	    roomNo = scL.next();
		System.out.print(" \t Add Room name :- ");
		roomName = scL.next();
		System.out.print(" \t Add Lecturer name :- ");
		lecturerName = scL.next();
		System.out.print(" \t Add the capacity of room :- ");
	    capacityRoom = scL.nextInt();
	    System.out.print(" \t Add the number of students enrolled:- ");
	    studentsNumber = scL.nextInt();
		
		
		File file1 = new File("lecturer.txt");
		FileWriter fw1 = null;
		PrintWriter pw1 = null;
		
		
		try {
			fw1 = new FileWriter(file1,true);
			pw1 = new PrintWriter(fw1, true);
			pw1.println();
			pw1.printf("%-18s%-18s%-18s%-18s%-18s%-18d%-18d", unitID, unitName, roomNo, roomName, lecturerName, capacityRoom, studentsNumber);
		}catch (FileNotFoundException e) {
			
			System.err.println(" \t File not found please check the file");
				e.printStackTrace();
		} catch (IOException e) {
		
			System.err.println(" \t Somthing wrong within your IO");
				e.printStackTrace();
			}
		finally{
			try{
			fw1.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
			pw1.close();
			Interface begin4 = new Interface();
			begin4.main(null);
		}
		
	}
	
	
    public void deleteLecturer() {
    	
    	System.out.print(" \t Enter the name  of the exact lecturer:- ");
    	String searchs2 = scL.nextLine();
		File searchFilede2 = new File("lecturer.txt");
		File file2 = new File("TempL.txt");
		try {
			Scanner inputL = new Scanner(searchFilede2);
			String linede2 = null;
			int count2= 0;
			while(inputL.hasNextLine()){
			    linede2 = inputL.nextLine();
			    ArrayList<String> wordsde2 = new ArrayList<String>();
			    String[] line2de2 = linede2.split(" \\s+");
			    for(String value : line2de2){
			    wordsde2.add(value);
			    }
			    
			    for(int i = 0; i < wordsde2.size(); i++){
			    	
			    	if( line2de2[i].equalsIgnoreCase(searchs2)){
			    		wordsde2.clear();	
			    	}
			    	
			    }
			    
			    count2++;
			   
			    if(wordsde2.size() != 0){
		    		oneL = wordsde2.get(0);			        
			    	twoL = wordsde2.get(1);
			    	threeL = wordsde2.get(2);
			    	fourL = wordsde2.get(3);
			    	fiveL = wordsde2.get(4);
			    	sixL = wordsde2.get(5);
			    	sevenL = wordsde2.get(6);
				    
					FileWriter fwri2 = null;
					PrintWriter pwri2 = null;
					
					try {
						fwri2 = new FileWriter(file2,true);
						pwri2 = new PrintWriter(fwri2, true);
						pwri2.println();
						pwri2.printf("%-18s%-18s%-18s%-18s%-18s%-18d%-18d" , oneL , twoL , threeL , fourL , fiveL , sixL , sevenL);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwri2.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(count2 == 7){
			    	break;
			    }
				}
			
			if(file2.renameTo(searchFilede2)){
				System.out.println("Success");
			}
			else{
				System.out.println("Failed");
			}
			searchFilede2.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c6 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c6 = scL.nextInt();
		}while( c6 != 1);
		switch(c6){
		case 1 : Interface begin6 = new Interface();
		         begin6.main(null);
		}
		
		
	}
	
	
	
    public void searchLecturer() {
    	
    	
    	System.out.print(" \t Enter the name of the lecturer:- ");
    	String userInput2 = scL.nextLine();
		File searchFile2 = new File("lecturer.txt");
		try {
			Scanner input2 = new Scanner(searchFile2);
			String lineby = null;
			while(input2.hasNextLine()){
			    lineby = input2.nextLine();
			    ArrayList<String> words2 = new ArrayList<String>();
			    String[] lineby2 = lineby.split(" \\s+");
			    for(String value : lineby2){
			    words2.add(value);
			    }
			    for(int i = 0; i < lineby2.length; i++){
			    	if( lineby2[i].equalsIgnoreCase(userInput2)){
			    		System.out.println("\n");
			    		System.out.println(" \t Unit ID : " + lineby2[i - 4]);
			    		System.out.println(" \t Unit Name : " + lineby2[i - 3]);
			    		System.out.println(" \t Room No : " + lineby2[i - 2]);
			    		System.out.println(" \t Room Name : " + lineby2[i - 1]);
			    		System.out.println(" \t Lecturer Name : " + lineby2[i]);
			    		System.out.println(" \t Room Capacity : " + lineby2[i + 1]);
			    		System.out.println(" \t No of Student Enrolled : " + lineby2[i + 2]);
			    	}
			    }	
			}		
		} catch (FileNotFoundException e) {
			System.err.println(" \t File not found!!!");
			
		}
		int c12 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c12 = scL.nextInt();
		}while( c12 != 1);
		switch(c12){
		case 1 : Interface begin12 = new Interface();
		         begin12.main(null);
		}
		
		}


	public void editLecturer() {
		System.out.print(" \t Enter the detail you want to edit:- ");
    	String searchs1e1 = scL.nextLine();
    	System.out.print(" \t Enter the replacing word:- ");
    	String replaces1 = scL.nextLine();
		File searchFiledee1 = new File("lecturer.txt");
		File filee1 = new File("Temp.txt");
		try {
			Scanner inputSe1 = new Scanner(searchFiledee1);
			String linedee1 = null;
			int counte1= 0;
			while(inputSe1.hasNextLine()){
			    linedee1 = inputSe1.nextLine();
			    ArrayList<String> wordsdee1 = new ArrayList<String>();
			    String[] line2dee1 = linedee1.split(" \\s+");
			    for(String value : line2dee1){
			    wordsdee1.add(value);
			    }
			    
			    for(int i = 0; i < wordsdee1.size(); i++){
			    	
			    	if( line2dee1[i].equalsIgnoreCase(searchs1e1)){
			    		String arrword1 = wordsdee1.get(i);
			    		System.out.println(arrword1);
			    		String replword1 = wordsdee1.get(i).replace(wordsdee1.get(i), replaces1);
			    		System.out.print(replword1);
			    		//= wordsdee.get(i).replace(wordsdee.get(i), replaces);	
			    		//System.out.print(wordsdee.get(i));
			    	}
			    	
			    }
			    
			    counte1++;
			   
			    if(wordsdee1.size() != 0){
		    		one1 = wordsdee1.get(0);			        
			    	two1 = wordsdee1.get(1);
			    	three1 = wordsdee1.get(2);
				    
					FileWriter fwrie1 = null;
					PrintWriter pwrie1 = null;
					
					try {
						fwrie1 = new FileWriter(filee1,true);
						pwrie1 = new PrintWriter(fwrie1, true);
						pwrie1.println();
						pwrie1.printf("%-20s%-20s%-20s" , one1 , two1 , three1);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwrie1.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(counte1 == 3){
			    	break;
			    }
				}
			
			if(filee1.renameTo(searchFiledee1)){
				System.out.println(":Success");
			}
			else{
				System.out.println(" Failed");
			}
			searchFiledee1.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c5 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c5 = scL.nextInt();
		}while( c5 != 1);
		switch(c5){
		case 1 : Interface begin5 = new Interface();
		         begin5.main(null);
		}
		
	}
		
		
	}


