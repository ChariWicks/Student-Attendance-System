import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Stuednt {
	Scanner scs = new Scanner(System.in);
	private int studentNo;//variable for student no
	private String lastName;//variable for last name
	private String firstName;//variable for first name
	private String two;//variable for keep the second index number
	private String three;//variable for keep the third index number
	private String one; //variable for keep the first index number
	public void addStudent() {
		System.out.print(" \t Add Student No. :- ");
	    studentNo = scs.nextInt();
		System.out.print(" \t Add Last name :- ");
		lastName = scs.next();
		System.out.print(" \t Add First name :- ");
		firstName = scs.next();
		File file = new File("studentsdetails.txt");
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file,true);
			pw = new PrintWriter(fw, true);
			pw.println();
			pw.printf("%-20d%-20s%-20s" , studentNo , lastName , firstName);
		}catch (FileNotFoundException e) {
			System.err.println(" \t File not found please check the file");
		} catch (IOException e) {
			System.err.println(" \t Somthing wrong within your IO");
			}
		finally{
			try{
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
			pw.close();
			Interface begin1 = new Interface();
			begin1.main(null);
	}
	}
    public void editStudent() {
    	System.out.print(" \t Enter the detail you want to edit:- ");
    	String searchs1e = scs.nextLine();//variable to keep the word you want to edit
    	System.out.print(" \t Enter the replacing word:- ");
    	String replaces = scs.nextLine();//variable for replacing word
		File searchFiledee = new File("studentsdetails.txt");
		File filee = new File("Temp.txt");//creating temporary file
		try {
			Scanner inputSe = new Scanner(searchFiledee);
			String linedee = null;//variable for keep the line from text file
			int counte= 0;
			while(inputSe.hasNextLine()){//checking whether input is a string
			    linedee = inputSe.nextLine();
			    ArrayList<String> wordsdee = new ArrayList<String>();
			    String[] line2dee = linedee.split(" \\s+");//splitting the sentence
			    for(String value : line2dee){
			    wordsdee.add(value);
			    }
			    
			    for(int i = 0; i < wordsdee.size(); i++){
			    	
			    	if( line2dee[i].equalsIgnoreCase(searchs1e)){//searching matching word
			    		String arrword = wordsdee.get(i);
			    		System.out.println(arrword);
			    		String replword = wordsdee.get(i).replace(wordsdee.get(i), replaces);
			    		System.out.print(replword);
			    		
			    	}
			    }
			    counte++;
			    if(wordsdee.size() != 0){
		    		one = wordsdee.get(0);			        
			    	two = wordsdee.get(1);
			    	three = wordsdee.get(2);
					FileWriter fwrie = null;
					PrintWriter pwrie = null;
					try {
						fwrie = new FileWriter(filee,true);
						pwrie = new PrintWriter(fwrie, true);
						pwrie.println();
						pwrie.printf("%-20s%-20s%-20s" , one , two , three);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwrie.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				}			
				}
			    if(counte == 3){
			    	break;
			    }
				}		
			if(filee.renameTo(searchFiledee)){//rename file
				System.out.println(":Success");
			}
			else{
				System.out.println(" Failed");//delete current file
			}
			searchFiledee.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		int c2 =0;//variable for keep prompt choice
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");//prompt for main menu
			c2 = scs.nextInt();
		}while( c2 != 1);
		switch(c2){
		case 1 : Interface begin2 = new Interface();
		         begin2.main(null);
		}	
	} 
    public void deleteStudent() {
    	System.out.print(" \t Enter the Student No of the exact student:- ");
    	String searchs1 = scs.nextLine();//variable for keep delete word
		File searchFilede = new File("studentsdetails.txt");
		File file = new File("Temp.txt");
		try {
			Scanner inputS = new Scanner(searchFilede);
			String linede = null;
			int count= 0;
			while(inputS.hasNextLine()){
			    linede = inputS.nextLine();
			    ArrayList<String> wordsde = new ArrayList<String>();
			    String[] line2de = linede.split(" \\s+");
			    for(String value : line2de){
			    wordsde.add(value);
			    }
			    for(int i = 0; i < wordsde.size(); i++){
			    	
			    	if( line2de[i].equalsIgnoreCase(searchs1)){
			    		wordsde.clear();	
			    	}	
			    }
			    count++;
			    if(wordsde.size() != 0){
		    		one = wordsde.get(0);			        
			    	two = wordsde.get(1);
			    	three = wordsde.get(2);
					FileWriter fwri = null;
					PrintWriter pwri = null;
					try {
						fwri = new FileWriter(file,true);
						pwri = new PrintWriter(fwri, true);
						pwri.println();
						pwri.printf("%-20s%-20s%-20s" , one , two , three);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwri.close();
					}catch (IOException e) {
						e.printStackTrace();
					} 
				}
				}
			    if(count == 3){
			    	break;
			    }
				}
			if(file.renameTo(searchFilede)){
				System.out.println(":Success");
			}
			else{
				System.out.println(" Failed");
			}
			searchFilede.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c3 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c3 = scs.nextInt();
		}while( c3 != 1);
		switch(c3){
		case 1 : Interface begin3 = new Interface();
		         begin3.main(null);
		}
			}	   
    public void searchStudent(String studentNo, String lastName, String firstName){
    	System.out.print(" \t Enter the Student No of the exact student:- ");
    	String userInput = scs.nextLine();
		File searchFile = new File("studentsdetails.txt");
		try {
			Scanner input = new Scanner(searchFile);
			String line = null;
			while(input.hasNextLine()){
			    line = input.nextLine();
			    ArrayList<String> words = new ArrayList<String>();
			    String[] line2 = line.split(" \\s+");
			    for(String value : line2){
			    words.add(value);
			    }
			    for(int i = 0; i < line2.length; i++){
			    	if( line2[i].equalsIgnoreCase(userInput)){
			    		System.out.println("\n");
			    		System.out.println(" \t Student No : " + line2[i]);
			    		System.out.println(" \t Last Name : " + line2[i + 1]);
			    		System.out.println(" \t First Name : " + line2[i + 2]);
			    	}
			    }	
			}		
		} catch (FileNotFoundException e) {
			System.err.println(" \t File not found!!!");
		}
		int c11 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c11 = scs.nextInt();
		}while( c11 != 1);
		switch(c11){
		case 1 : Interface begin11 = new Interface();
		         begin11.main(null);
		}
		}
	}

