import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports {

	public String reportPrompt;//variable for report prompt
	public String reUnit;//variable for unit id
	public String reRoom;//variable for room no
	public String reName;//variable for unit name
	public String reLecturer;//variable for lecturer name
	public String reWeek;//variable for week no
	public String reDate;//variable for date
	public String reEnrolled;//variable for number of enrolled student 
	public String reCapacity;//variable for room capacity
	public double percentage;//variable for percentage
	public String reRoomNO;//variable for room no
	public String reStuNo;//variable for student no
	public String reLast;//variable for last name
	public String reFirst;//variable for first name

	public void genarateReport() throws IOException {
		Scanner scR = new Scanner(System.in);
		System.out.print(" \t Enter Unit ID :  ");
	    reportPrompt = scR.nextLine();
		
		switch(reportPrompt){
		case ("ECSC410") : Sdp01();
		break;
		case ("ECSC412") : Csf();
		break;
		case ("ECSC414") : Idm();
		break;
		case ("ECSC416") : Csse();
		break;
		case ("ECSC418") : Sdpd();
		break;
		default :
		break;	
		}
		
	}
   
	public void Sdp01() throws IOException {
		File barcode = new File("attendancelog.txt");
		Scanner barcodeS = new Scanner(barcode);
		
		String keep = null;
	    int countRe= 0;
		while(barcodeS.hasNextLine()){
		    keep = barcodeS.nextLine();
		    ArrayList<String> split = new ArrayList<String>();
		    String[] keeparray = keep.split(" \\s+");
		    for(String value : keeparray){
		    split.add(value);
		    }
		    
		    for(int i = 0; i < split.size(); i++){
		    	if(keeparray[i].equalsIgnoreCase(reportPrompt)){
		    		countRe++;
		    		reUnit = split.get(i);
		    		reRoomNO = split.get(i-2);
		    		reLecturer = split.get(i+1);
		    		reWeek = split.get(i+3);
		    		reDate = split.get(i+2);
		    	}
		    }
		 }
		 File lecturer = new File("lecturer.txt");
		 Scanner lecturerS = new Scanner(lecturer);
		 
		 String keepLec = null;
		 while(lecturerS.hasNextLine()){
			    keepLec = lecturerS.nextLine();
			    ArrayList<String> splitLec = new ArrayList<String>();
			    String[] keeparrayLec = keepLec.split(" \\s+");
			    for(String value : keeparrayLec){
			    splitLec.add(value);
			    }
			    
			    for(int i = 0; i < splitLec.size(); i++){
			    	if(keeparrayLec[i].equalsIgnoreCase(reportPrompt)){
			    		reEnrolled = splitLec.get(i+6);
			    		reCapacity = splitLec.get(i+5);
			    		reRoom = splitLec.get(i+3);
			    		
			    	}
			    }
		 }
		 percentage = (countRe) / (Double.parseDouble(reCapacity)) * 100.0;//calculating percentage
 		//System.out.println((Double.parseDouble(reEnrolled)));
 		//System.out.println((Double.parseDouble(reCapacity)));
 		//System.out.println(percentage);
 		int perce = (int) percentage;//convert double into int

		 File writesdp01 = new File("SDP01Report.txt");
		 FileWriter fwriterRe = new FileWriter(writesdp01);
		 PrintWriter pwriterRe = new PrintWriter(fwriterRe);
		 pwriterRe.println("Attendence Report");
		 pwriterRe.println("Unit            :" + "     " + reUnit );
		 pwriterRe.println("Unit Name       :     Software Development Principles01");
		 pwriterRe.println("Room            :" + "     " + reRoomNO);
		 pwriterRe.println("Name            :" + "     " + reRoom);
		 pwriterRe.println("Lecturer        :" + "     " + reLecturer);
		 pwriterRe.println("Week#           :" + "     " + reWeek);
		 pwriterRe.println("Date            :" + "     " + reDate);
		 
		 File student = new File("units.txt");
		 Scanner studentS = new Scanner(student);
		 String keepUnits = null;
		 while(studentS.hasNextLine()){
			    keepUnits = studentS.nextLine();
			    ArrayList<String> splitStu = new ArrayList<String>();
			    String[] keeparrayStu1 = keepUnits.split(" \\s+");
			    for(String value : keeparrayStu1){
			    splitStu.add(value);
			    }
			    for(int i = 0; i < splitStu.size(); i++){
			    	if(keeparrayStu1[i].equalsIgnoreCase(reportPrompt)){
			    		reStuNo = splitStu.get(i+2);
			    		reLast = splitStu.get(i+3);
			    		reFirst = splitStu.get(i+4);
			    		
			    		File barcode2 = new File("attendancelog.txt");
			    		Scanner barcodeS2 = new Scanner(barcode2);
			    		while(barcodeS2.hasNextLine()){
			    		    keep = barcodeS2.nextLine();
			    		    ArrayList<String> split = new ArrayList<String>();
			    		    String[] keeparray = keep.split(" \\s+");
			    		    for(String value1 : keeparray){
			    		    split.add(value1);
			    		    }
			    		    
			    		    
			    //check the absentees and present students
			    		    //check student no in both unit file and attendance log file
			    		    //check unit id in both unit file and attendance file
			    		    	if( (splitStu.get(i+2)     .equals(split.get(1))       ) &&  (splitStu.get(i)      .equals(split.get(i+2))         )){
			    		    		String acc = " Y";
			    		    		pwriterRe.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc);
			    		    		pwriterRe.println();
			    		    	}
			    		    	if( !(splitStu.get(i+2)     .equals(split.get(1))       ) &&  (splitStu.get(i)      .equals(split.get(i+2))         )){
			    		    		String acc = " N";
			    		    		pwriterRe.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc);
			    		    		pwriterRe.println();
			    		    	}
			    		    	
			    		    }
			    	}
			    }
			    }
		 
		 pwriterRe.println("Lecturer confirmed attendence : Yes/No");
		 pwriterRe.println("Students Enrolled             :" + reEnrolled);
		 pwriterRe.println("Attendance                    :" + countRe);
		 pwriterRe.println("Room Capacity                 :" + reCapacity);
		 pwriterRe.println("Percentage Occupancy          :" + perce + "%");
		 
		 pwriterRe.close();
		 fwriterRe.close();
			    
		 
			    
		
		
		
		
	}

	public void Csse() throws IOException {
		File barcode1 = new File("attendancelog.txt");
		Scanner barcodeS1 = new Scanner(barcode1);
		
		String keep1 = null;
	    int countRe1= 0;
		while(barcodeS1.hasNextLine()){
		    keep1 = barcodeS1.nextLine();
		    ArrayList<String> split1 = new ArrayList<String>();
		    String[] keeparray1 = keep1.split(" \\s+");
		    for(String value1 : keeparray1){
		    split1.add(value1);
		    }
		    
		    for(int i = 0; i < split1.size(); i++){
		    	if(keeparray1[i].equalsIgnoreCase(reportPrompt)){
		    		countRe1++;
		    		reUnit = split1.get(i);
		    		reRoomNO = split1.get(i-2);
		    		reLecturer = split1.get(i+1);
		    		reWeek = split1.get(i+3);
		    		reDate = split1.get(i+2);
		    	}
		    }
		 }
		 File lecturer1 = new File("lecturer.txt");
		 Scanner lecturerS1 = new Scanner(lecturer1);
		 
		 String keepLec1 = null;
		 while(lecturerS1.hasNextLine()){
			    keepLec1 = lecturerS1.nextLine();
			    ArrayList<String> splitLec1 = new ArrayList<String>();
			    String[] keeparrayLec1 = keepLec1.split(" \\s+");
			    for(String value1 : keeparrayLec1){
			    splitLec1.add(value1);
			    }
			    
			    for(int i = 0; i < splitLec1.size(); i++){
			    	if(keeparrayLec1[i].equalsIgnoreCase(reportPrompt)){
			    		reEnrolled = splitLec1.get(i+6);
			    		reCapacity = splitLec1.get(i+5);
			    		reRoom = splitLec1.get(i+3);
			    		
			    	}
			    }
		 }
		 percentage = (countRe1) / (Double.parseDouble(reCapacity)) * 100.0;
 		//System.out.println((Double.parseDouble(reEnrolled)));
 		//System.out.println((Double.parseDouble(reCapacity)));
 		//System.out.println(percentage);
 		int perce = (int) percentage;

		 File writesdp011 = new File("CSSEReport.txt");
		 FileWriter fwriterRe1 = new FileWriter(writesdp011);
		 PrintWriter pwriterRe1 = new PrintWriter(fwriterRe1);
		 pwriterRe1.println("Attendence Report");
		 pwriterRe1.println("Unit            :" + "     " + reUnit );
		 pwriterRe1.println("Unit Name       :     Software Development Principles01");
		 pwriterRe1.println("Room            :" + "     " + reRoomNO);
		 pwriterRe1.println("Name            :" + "     " + reRoom);
		 pwriterRe1.println("Lecturer        :" + "     " + reLecturer);
		 pwriterRe1.println("Week#           :" + "     " + reWeek);
		 pwriterRe1.println("Date            :" + "     " + reDate);
		 
		 File student1 = new File("units.txt");
		 Scanner studentS1 = new Scanner(student1);
		 String keepUnits1 = null;
		 while(studentS1.hasNextLine()){
			    keepUnits1 = studentS1.nextLine();
			    ArrayList<String> splitStu1 = new ArrayList<String>();
			    String[] keeparrayStu11 = keepUnits1.split(" \\s+");
			    for(String value1 : keeparrayStu11){
			    splitStu1.add(value1);
			    }
			    for(int i = 0; i < splitStu1.size(); i++){
			    	if(keeparrayStu11[i].equalsIgnoreCase(reportPrompt)){
			    		reStuNo = splitStu1.get(i+2);
			    		reLast = splitStu1.get(i+3);
			    		reFirst = splitStu1.get(i+4);
			    		
			    		File barcode21 = new File("attendancelog.txt");
			    		Scanner barcodeS21 = new Scanner(barcode21);
			    		while(barcodeS21.hasNextLine()){
			    		    keep1 = barcodeS21.nextLine();
			    		    ArrayList<String> split1 = new ArrayList<String>();
			    		    String[] keeparray1 = keep1.split(" \\s+");
			    		    for(String value11 : keeparray1){
			    		    split1.add(value11);
			    		    }
			    		    
			    		    
			    
			    		    	if( (splitStu1.get(i+2)     .equals(split1.get(1))       ) &&  (splitStu1.get(i)      .equals(split1.get(i+2))         )){
			    		    		String acc1 = " Y";
			    		    		pwriterRe1.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc1);
			    		    		pwriterRe1.println();
			    		    	}
			    		    	if( !(splitStu1.get(i+2)     .equals(split1.get(1))       ) &&  (splitStu1.get(i)      .equals(split1.get(i+2))         )){
			    		    		String acc1 = " N";
			    		    		pwriterRe1.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc1);
			    		    		pwriterRe1.println();
			    		    	}
			    		    	
			    		    }
			    	}
			    }
			    }
		 
		 pwriterRe1.println("Lecturer confirmed attendence : Yes/No");
		 pwriterRe1.println("Students Enrolled             :" + reEnrolled);
		 pwriterRe1.println("Attendance                    :" + countRe1);
		 pwriterRe1.println("Room Capacity                 :" + reCapacity);
		 pwriterRe1.println("Percentage Occupancy          :" + perce + "%");
		 
		 pwriterRe1.close();
		 fwriterRe1.close();
		
	}

	public void Idm() throws IOException {
		File barcode3 = new File("attendancelog.txt");
		Scanner barcodeS3 = new Scanner(barcode3);
		
		String keep3 = null;
	    int countRe3= 0;
		while(barcodeS3.hasNextLine()){
		    keep3 = barcodeS3.nextLine();
		    ArrayList<String> split3 = new ArrayList<String>();
		    String[] keeparray3 = keep3.split(" \\s+");
		    for(String value3 : keeparray3){
		    split3.add(value3);
		    }
		    
		    for(int i = 0; i < split3.size(); i++){
		    	if(keeparray3[i].equalsIgnoreCase(reportPrompt)){
		    		countRe3++;
		    		reUnit = split3.get(i);
		    		reRoomNO = split3.get(i-2);
		    		reLecturer = split3.get(i+1);
		    		reWeek = split3.get(i+3);
		    		reDate = split3.get(i+2);
		    	}
		    }
		 }
		 File lecturer3 = new File("lecturer.txt");
		 Scanner lecturerS3 = new Scanner(lecturer3);
		 
		 String keepLec3 = null;
		 while(lecturerS3.hasNextLine()){
			    keepLec3 = lecturerS3.nextLine();
			    ArrayList<String> splitLec3 = new ArrayList<String>();
			    String[] keeparrayLec3 = keepLec3.split(" \\s+");
			    for(String value3 : keeparrayLec3){
			    splitLec3.add(value3);
			    }
			    
			    for(int i = 0; i < splitLec3.size(); i++){
			    	if(keeparrayLec3[i].equalsIgnoreCase(reportPrompt)){
			    		reEnrolled = splitLec3.get(i+6);
			    		reCapacity = splitLec3.get(i+5);
			    		reRoom = splitLec3.get(i+3);
			    		
			    	}
			    }
		 }
		percentage = (countRe3) / (Double.parseDouble(reCapacity)) * 100.0;
 		//System.out.println(percentage);
 		int perce = (int) percentage;

		 File writesdp013 = new File("IDMeport.txt");
		 FileWriter fwriterRe3 = new FileWriter(writesdp013);
		 PrintWriter pwriterRe3 = new PrintWriter(fwriterRe3);
		 pwriterRe3.println("Attendence Report");
		 pwriterRe3.println("Unit            :" + "     " + reUnit );
		 pwriterRe3.println("Unit Name       :     Software Development Principles01");
		 pwriterRe3.println("Room            :" + "     " + reRoomNO);
		 pwriterRe3.println("Name            :" + "     " + reRoom);
		 pwriterRe3.println("Lecturer        :" + "     " + reLecturer);
		 pwriterRe3.println("Week#           :" + "     " + reWeek);
		 pwriterRe3.println("Date            :" + "     " + reDate);
		 
		 File student3 = new File("units.txt");
		 Scanner studentS3 = new Scanner(student3);
		 String keepUnits3 = null;
		 while(studentS3.hasNextLine()){
			    keepUnits3 = studentS3.nextLine();
			    ArrayList<String> splitStu3 = new ArrayList<String>();
			    String[] keeparrayStu13 = keepUnits3.split(" \\s+");
			    for(String value3 : keeparrayStu13){
			    splitStu3.add(value3);
			    }
			    for(int i = 0; i < splitStu3.size(); i++){
			    	if(keeparrayStu13[i].equalsIgnoreCase(reportPrompt)){
			    		reStuNo = splitStu3.get(i+2);
			    		reLast = splitStu3.get(i+3);
			    		reFirst = splitStu3.get(i+4);
			    		
			    		File barcode23 = new File("attendancelog.txt");
			    		Scanner barcodeS23 = new Scanner(barcode23);
			    		while(barcodeS23.hasNextLine()){
			    		    keep3 = barcodeS23.nextLine();
			    		    ArrayList<String> split3 = new ArrayList<String>();
			    		    String[] keeparray3 = keep3.split(" \\s+");
			    		    for(String value13 : keeparray3){
			    		    split3.add(value13);
			    		    }
			    		    
			    		    
			    
			    		    	if( (splitStu3.get(i+2)     .equals(split3.get(1))       ) &&  (splitStu3.get(i)      .equals(split3.get(i+2))         )){
			    		    		String acc3 = " Y";
			    		    		pwriterRe3.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc3);
			    		    		pwriterRe3.println();
			    		    	}
			    		    	if( !(splitStu3.get(i+2)     .equals(split3.get(1))       ) &&  (splitStu3.get(i)      .equals(split3.get(i+2))         )){
			    		    		String acc3 = " N";
			    		    		pwriterRe3.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc3);
			    		    		pwriterRe3.println();
			    		    	}
			    		    	
			    		    }
			    	}
			    }
			    }
		 
		 pwriterRe3.println("Lecturer confirmed attendence : Yes/No");
		 pwriterRe3.println("Students Enrolled             :" + reEnrolled);
		 pwriterRe3.println("Attendance                    :" + countRe3);
		 pwriterRe3.println("Room Capacity                 :" + reCapacity);
		 pwriterRe3.println("Percentage Occupancy          :" + perce + "%");
		 
		 pwriterRe3.close();
		 fwriterRe3.close();
	}

	public void Csf() throws IOException {
		File barcode4 = new File("attendancelog.txt");
		Scanner barcodeS4 = new Scanner(barcode4);
		
		String keep4 = null;
	    int countRe4= 0;
		while(barcodeS4.hasNextLine()){
		    keep4 = barcodeS4.nextLine();
		    ArrayList<String> split4 = new ArrayList<String>();
		    String[] keeparray4 = keep4.split(" \\s+");
		    for(String value4 : keeparray4){
		    split4.add(value4);
		    }
		    
		    for(int i = 0; i < split4.size(); i++){
		    	if(keeparray4[i].equalsIgnoreCase(reportPrompt)){
		    		countRe4++;
		    		reUnit = split4.get(i);
		    		reRoomNO = split4.get(i-2);
		    		reLecturer = split4.get(i+1);
		    		reWeek = split4.get(i+3);
		    		reDate = split4.get(i+2);
		    	}
		    }
		 }
		 File lecturer4 = new File("lecturer.txt");
		 Scanner lecturerS4 = new Scanner(lecturer4);
		 
		 String keepLec4 = null;
		 while(lecturerS4.hasNextLine()){
			    keepLec4 = lecturerS4.nextLine();
			    ArrayList<String> splitLec4 = new ArrayList<String>();
			    String[] keeparrayLec4 = keepLec4.split(" \\s+");
			    for(String value4 : keeparrayLec4){
			    splitLec4.add(value4);
			    }
			    
			    for(int i = 0; i < splitLec4.size(); i++){
			    	if(keeparrayLec4[i].equalsIgnoreCase(reportPrompt)){
			    		reEnrolled = splitLec4.get(i+6);
			    		reCapacity = splitLec4.get(i+5);
			    		reRoom = splitLec4.get(i+3);
			    		
			    	}
			    }
		 }
		 percentage = (countRe4) / (Double.parseDouble(reCapacity)) * 100.0;
 		//System.out.println((Double.parseDouble(reEnrolled)));
 		//System.out.println((Double.parseDouble(reCapacity)));
 		//System.out.println(percentage);
 		int perce = (int) percentage;

		 File writesdp014 = new File("CSFeport.txt");
		 FileWriter fwriterRe4 = new FileWriter(writesdp014);
		 PrintWriter pwriterRe4 = new PrintWriter(fwriterRe4);
		 pwriterRe4.println("Attendence Report");
		 pwriterRe4.println("Unit            :" + "     " + reUnit );
		 pwriterRe4.println("Unit Name       :     Software Development Principles01");
		 pwriterRe4.println("Room            :" + "     " + reRoomNO);
		 pwriterRe4.println("Name            :" + "     " + reRoom);
		 pwriterRe4.println("Lecturer        :" + "     " + reLecturer);
		 pwriterRe4.println("Week#           :" + "     " + reWeek);
		 pwriterRe4.println("Date            :" + "     " + reDate);
		 
		 File student4 = new File("units.txt");
		 Scanner studentS4 = new Scanner(student4);
		 String keepUnits4 = null;
		 while(studentS4.hasNextLine()){
			    keepUnits4 = studentS4.nextLine();
			    ArrayList<String> splitStu4 = new ArrayList<String>();
			    String[] keeparrayStu14 = keepUnits4.split(" \\s+");
			    for(String value4 : keeparrayStu14){
			    splitStu4.add(value4);
			    }
			    for(int i = 0; i < splitStu4.size(); i++){
			    	if(keeparrayStu14[i].equalsIgnoreCase(reportPrompt)){
			    		reStuNo = splitStu4.get(i+2);
			    		reLast = splitStu4.get(i+3);
			    		reFirst = splitStu4.get(i+4);
			    		
			    		File barcode24 = new File("attendancelog.txt");
			    		Scanner barcodeS24 = new Scanner(barcode24);
			    		while(barcodeS24.hasNextLine()){
			    		    keep4 = barcodeS24.nextLine();
			    		    ArrayList<String> split4 = new ArrayList<String>();
			    		    String[] keeparray4 = keep4.split(" \\s+");
			    		    for(String value14 : keeparray4){
			    		    split4.add(value14);
			    		    }
			    		    
			    		    
			    
			    		    	if( (splitStu4.get(i+2)     .equals(split4.get(1))       ) &&  (splitStu4.get(i)      .equals(split4.get(i+2))         )){
			    		    		String acc4 = " Y";
			    		    		pwriterRe4.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc4);
			    		    		pwriterRe4.println();
			    		    	}
			    		    	if( !(splitStu4.get(i+2)     .equals(split4.get(1))       ) &&  (splitStu4.get(i)      .equals(split4.get(i+2))         )){
			    		    		String acc4 = " N";
			    		    		pwriterRe4.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc4);
			    		    		pwriterRe4.println();
			    		    	}
			    		    	
			    		    }
			    	}
			    }
			    }
		 
		 pwriterRe4.println("Lecturer confirmed attendence : Yes/No");
		 pwriterRe4.println("Students Enrolled             :" + reEnrolled);
		 pwriterRe4.println("Attendance                    :" + countRe4);
		 pwriterRe4.println("Room Capacity                 :" + reCapacity);
		 pwriterRe4.println("Percentage Occupancy          :" + perce + "%");
		 
		 pwriterRe4.close();
		 fwriterRe4.close();
	}
		
	

	public void Sdpd() throws IOException {
		File barcode5 = new File("attendancelog.txt");
		Scanner barcodeS5 = new Scanner(barcode5);
		
		String keep5 = null;
	    int countRe5= 0;
		while(barcodeS5.hasNextLine()){
		    keep5 = barcodeS5.nextLine();
		    ArrayList<String> split5 = new ArrayList<String>();
		    String[] keeparray5 = keep5.split(" \\s+");
		    for(String value5 : keeparray5){
		    split5.add(value5);
		    }
		    
		    for(int i = 0; i < split5.size(); i++){
		    	if(keeparray5[i].equalsIgnoreCase(reportPrompt)){
		    		countRe5++;
		    		reUnit = split5.get(i);
		    		reRoomNO = split5.get(i-2);
		    		reLecturer = split5.get(i+1);
		    		reWeek = split5.get(i+3);
		    		reDate = split5.get(i+2);
		    	}
		    }
		 }
		 File lecturer5 = new File("lecturer.txt");
		 Scanner lecturerS5 = new Scanner(lecturer5);
		 
		 String keepLec5 = null;
		 while(lecturerS5.hasNextLine()){
			    keepLec5 = lecturerS5.nextLine();
			    ArrayList<String> splitLec5 = new ArrayList<String>();
			    String[] keeparrayLec5 = keepLec5.split(" \\s+");
			    for(String value5 : keeparrayLec5){
			    splitLec5.add(value5);
			    }
			    
			    for(int i = 0; i < splitLec5.size(); i++){
			    	if(keeparrayLec5[i].equalsIgnoreCase(reportPrompt)){
			    		reEnrolled = splitLec5.get(i+6);
			    		reCapacity = splitLec5.get(i+5);
			    		reRoom = splitLec5.get(i+3);
			    		
			    	}
			    }
		 }
		 percentage = (countRe5) / (Double.parseDouble(reCapacity)) * 100.0;
 		//System.out.println((Double.parseDouble(reEnrolled)));
 		//System.out.println((Double.parseDouble(reCapacity)));
 		//System.out.println(percentage);
 		int perce = (int) percentage;

		 File writesdp015 = new File("SDPDReport.txt");
		 FileWriter fwriterRe5 = new FileWriter(writesdp015);
		 PrintWriter pwriterRe5 = new PrintWriter(fwriterRe5);
		 pwriterRe5.println("Attendence Report");
		 pwriterRe5.println("Unit            :" + "     " + reUnit );
		 pwriterRe5.println("Unit Name       :     Software Development Principles01");
		 pwriterRe5.println("Room            :" + "     " + reRoomNO);
		 pwriterRe5.println("Name            :" + "     " + reRoom);
		 pwriterRe5.println("Lecturer        :" + "     " + reLecturer);
		 pwriterRe5.println("Week#           :" + "     " + reWeek);
		 pwriterRe5.println("Date            :" + "     " + reDate);
		 
		 File student5 = new File("units.txt");
		 Scanner studentS5 = new Scanner(student5);
		 String keepUnits5 = null;
		 while(studentS5.hasNextLine()){
			    keepUnits5 = studentS5.nextLine();
			    ArrayList<String> splitStu5 = new ArrayList<String>();
			    String[] keeparrayStu15 = keepUnits5.split(" \\s+");
			    for(String value5 : keeparrayStu15){
			    splitStu5.add(value5);
			    }
			    for(int i = 0; i < splitStu5.size(); i++){
			    	if(keeparrayStu15[i].equalsIgnoreCase(reportPrompt)){
			    		reStuNo = splitStu5.get(i+2);
			    		reLast = splitStu5.get(i+3);
			    		reFirst = splitStu5.get(i+4);
			    		
			    		File barcode25 = new File("attendancelog.txt");
			    		Scanner barcodeS25 = new Scanner(barcode25);
			    		while(barcodeS25.hasNextLine()){
			    		    keep5 = barcodeS25.nextLine();
			    		    ArrayList<String> split5 = new ArrayList<String>();
			    		    String[] keeparray5 = keep5.split(" \\s+");
			    		    for(String value15 : keeparray5){
			    		    split5.add(value15);
			    		    }
			    		    
			    		    
			    
			    		    	if( (splitStu5.get(i+2)     .equals(split5.get(1))       ) &&  (splitStu5.get(i)      .equals(split5.get(i+2))         )){
			    		    		String acc5 = " Y";
			    		    		pwriterRe5.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc5);
			    		    		pwriterRe5.println();
			    		    	}
			    		    	if( !(splitStu5.get(i+2)     .equals(split5.get(1))       ) &&  (splitStu5.get(i)      .equals(split5.get(i+2))         )){
			    		    		String acc5 = " N";
			    		    		pwriterRe5.printf("%-20s%-20s%-20s%-20s", reStuNo, reLast, reFirst, acc5);
			    		    		pwriterRe5.println();
			    		    	}
			    		    	
			    		    }
			    	}
			    }
			    }
		 
		 pwriterRe5.println("Lecturer confirmed attendence : Yes/No");
		 pwriterRe5.println("Students Enrolled             :" + reEnrolled);
		 pwriterRe5.println("Attendance                    :" + countRe5);
		 pwriterRe5.println("Room Capacity                 :" + reCapacity);
		 pwriterRe5.println("Percentage Occupancy          :" + perce + "%");
		 
		 pwriterRe5.close();
		 fwriterRe5.close();
	}
		
	}


