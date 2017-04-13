import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureRooms {
	
    Scanner scLR = new Scanner(System.in);
	private String roomNo;
	private String roomName;
	private int roomCapacity;
	private String oneLR;
	private String twoLR;
	private String threeLR;
	private String one2;
	private String two2;
	private String three2; 
	
    public void addLectureRooms() {
    	System.out.print(" \t Add Room No. :- ");
	    roomNo = scLR.next();
		System.out.print(" \t Add Room Name :- ");
		roomName = scLR.next();
		System.out.print(" \t Add Room Capacity :- ");
		roomCapacity = scLR.nextInt();
		
		File file2 = new File("lecturehalls.txt");
		FileWriter fw2 = null;
		PrintWriter pw2 = null;
		
		
		try {
			fw2 = new FileWriter(file2,true);
			pw2 = new PrintWriter(fw2, true);
			pw2.println();
			pw2.printf("%-18s%-18s%-18d",  roomNo, roomName, roomCapacity );
		}catch (FileNotFoundException e) {
			
			System.err.println(" \t File not found please check the file");
				e.printStackTrace();
		} catch (IOException e) {
		
			System.err.println(" \t Somthing wrong within your IO");
				e.printStackTrace();
			}
		finally{
			try{
			fw2.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
			pw2.close();
			Interface begin7 = new Interface();
			begin7.main(null);
		}

		
	}
    
    
    public void deleteLectureRooms() {
    	System.out.print(" \t Enter the room No: of the exact lecturer:- ");
    	String searchs3 = scLR.nextLine();
		File searchFilede3 = new File("lecturehalls.txt");
		File file3 = new File("TempLR.txt");
		try {
			Scanner inputLR = new Scanner(searchFilede3);
			String linede3 = null;
			int count3= 0;
			while(inputLR.hasNextLine()){
			    linede3 = inputLR.nextLine();
			    ArrayList<String> wordsde3 = new ArrayList<String>();
			    String[] line2de3 = linede3.split(" \\s+");
			    for(String value : line2de3){
			    wordsde3.add(value);
			    }
			    
			    for(int i = 0; i < wordsde3.size(); i++){
			    	
			    	if( line2de3[i].equalsIgnoreCase(searchs3)){
			    		wordsde3.clear();	
			    	}
			    	
			    }
			    
			    count3++;
			   
			    if(wordsde3.size() != 0){
		    		oneLR = wordsde3.get(0);			        
			    	twoLR = wordsde3.get(1);
			    	threeLR = wordsde3.get(2);
			    	
					FileWriter fwri3 = null;
					PrintWriter pwri3 = null;
					
					try {
						fwri3 = new FileWriter(file3,true);
						pwri3 = new PrintWriter(fwri3, true);
						pwri3.println();
						pwri3.printf("%-18s%-18s%-18d" , oneLR , twoLR , threeLR);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwri3.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(count3 == 3){
			    	break;
			    }
				}
			
			if(file3.renameTo(searchFilede3)){
				System.out.println("Success");
			}
			else{
				System.out.println("Failed");
			}
			searchFilede3.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c16 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c16 = scLR.nextInt();
		}while( c16 != 1);
		switch(c16){
		case 1 : Interface begin16 = new Interface();
		         begin16.main(null);
		}
		
	}
    
    public void searchLectureRooms() {
    	System.out.print(" \t Enter the room number of the lecture room:- ");
    	String userInput3 = scLR.nextLine();
		File searchFile3 = new File("lecturehalls.txt");
		try {
			Scanner input3 = new Scanner(searchFile3);
			String lineby2 = null;
			while(input3.hasNextLine()){
			    lineby2 = input3.nextLine();
			    ArrayList<String> words3 = new ArrayList<String>();
			    String[] lineby3 = lineby2.split(" \\s+");
			    for(String value : lineby3){
			    words3.add(value);
			    }
			    for(int i = 0; i < lineby3.length; i++){
			    	if( lineby3[i].equals(userInput3)){
			    		System.out.println("\n");
			    		System.out.println(" \t Room No : " + lineby3[i]);
			    		System.out.println(" \t Room Name : " + lineby3[i + 1]);
			    		System.out.println(" \t Room Capacity : " + lineby3[i + 2]);
			    	}
			    }	
			}		
		} catch (FileNotFoundException e) {
			System.err.println(" \t File not found!!!");
			
		}
		int c13 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c13 = scLR.nextInt();
		}while( c13 != 1);
		switch(c13){
		case 1 : Interface begin13 = new Interface();
		         begin13.main(null);
		}
		
		}


	public void editLectureRooms() {
		System.out.print(" \t Enter the detail you want to edit:- ");
    	String searchs1e2 = scLR.nextLine();
    	System.out.print(" \t Enter the replacing word:- ");
    	String replaces2 = scLR.nextLine();
		File searchFiledee2 = new File("lecturehalls.txt");
		File filee2 = new File("TempLR.txt");
		try {
			Scanner inputSe2 = new Scanner(searchFiledee2);
			String linedee2 = null;
			int counte2= 0;
			while(inputSe2.hasNextLine()){
			    linedee2 = inputSe2.nextLine();
			    ArrayList<String> wordsdee2 = new ArrayList<String>();
			    String[] line2dee2 = linedee2.split(" \\s+");
			    for(String value : line2dee2){
			    wordsdee2.add(value);
			    }
			    
			    for(int i = 0; i < wordsdee2.size(); i++){
			    	
			    	if( line2dee2[i].equalsIgnoreCase(searchs1e2)){
			    		String arrword2 = wordsdee2.get(i);
			    		System.out.println(arrword2);
			    		String replword2 = wordsdee2.get(i).replace(wordsdee2.get(i), replaces2);
			    		System.out.print(replword2);
			    		//= wordsdee.get(i).replace(wordsdee.get(i), replaces);	
			    		//System.out.print(wordsdee.get(i));
			    	}
			    	
			    }
			    
			    counte2++;
			   
			    if(wordsdee2.size() != 0){
		    		one2 = wordsdee2.get(0);			        
			    	two2 = wordsdee2.get(1);
			    	three2 = wordsdee2.get(2);
				    
					FileWriter fwrie2 = null;
					PrintWriter pwrie2 = null;
					
					try {
						fwrie2 = new FileWriter(filee2,true);
						pwrie2 = new PrintWriter(fwrie2, true);
						pwrie2.println();
						pwrie2.printf("%-20s%-20s%-20s" , one2 , two2 , three2);
					}catch (FileNotFoundException e) {
						System.err.println(" \t File not found please check the file");
					} catch (IOException e) {
						System.err.println(" \t Somthing wrong within your IO");
						}
					finally{
						try{
						fwrie2.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				    
				}
				
				}
			    if(counte2 == 3){
			    	break;
			    }
				}
			
			if(filee2.renameTo(searchFiledee2)){
				System.out.println(":Success");
			}
			else{
				System.out.println(" Failed");
			}
			searchFiledee2.delete();
		}
			       catch (FileNotFoundException e) {
					System.err.println(" \t File not found!!!");
		    	}
		
		int c8 =0;
		do{
			System.out.print(" \t\n If you want to go back to the main menu please enter 1 - ");
			c8 = scLR.nextInt();
		}while( c8 != 1);
		switch(c8){
		case 1 : Interface begin8 = new Interface();
		         begin8.main(null);
		}
		
	}	

}
