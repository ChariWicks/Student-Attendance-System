import java.io.IOException;
import java.util.Scanner;
public class Interface {

	private static int optionNum;//variable keeps user's option number
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println(" \t\t\t University of Gugsi ");
		System.out.println(" \t\t\t ___________________\n");
		System.out.println(" \t\t     Facilities Management Office ");
		System.out.println(" \t\t    ______________________________\n");
		System.out.println(" \t\t\t   ** Main Menu **\n\n ");
		
		System.out.println(" \t 1. Add new student details");
		System.out.println(" \t 2. Edit existing student details");
		System.out.println(" \t 3. Delete existing student details");
		System.out.println(" \t 4. Add new lecturer details");
		System.out.println(" \t 5. Edit existing lecturer details");
		System.out.println(" \t 6. Delete existing lecturer details");
		System.out.println(" \t 7. Add new lecture rooms' details");
		System.out.println(" \t 8. Edit existing lecture rooms' details");
		System.out.println(" \t 9. Add new units' details");
		System.out.println(" \t 10.Edit existing units' details");
		System.out.println(" \t 11.Search existing student details");
		System.out.println(" \t 12.Search existing lecturer details");
		System.out.println(" \t 13.Search for lecture rooms' details");
		System.out.println(" \t 14.Search for unit details");
		System.out.println(" \t 15.Delete existing units' details");
		System.out.println(" \t 16.Delete existing Lecture Rooms' details");
		System.out.println(" \t 17.Generate attendence report");
		System.out.println(" \n");
		 
		
	 	boolean valid;
	 	
	 	do{
	 		System.out.print(" \t Enter the number of your option:- ");
	 		if(sc.hasNextInt()){//check whether user has typed a number
	 			optionNum = sc.nextInt();
	 			if(optionNum > 0 && optionNum < 18){//check whether number is between 0 to 18
	 				valid = true;
	 				Interface.conditions();	
	 			}
	 			else{
	 				System.out.println(" \t Please, Enter a number between 1 and 18!!!!");
	 				valid = false;
	 			}
	 				
	 		}
	 		else
	 		{
	 			System.out.println(" \t Please, Enter a number!!!!");
	 			System.out.println("\n");
	 			valid = false;
	 			sc.next();
	 		}
	 	}while(!(valid));
	 		
	}
	private static void conditions(){
		Stuednt obj = new Stuednt();
		Lecturer obj2 = new Lecturer();
		LectureRooms obj3 = new LectureRooms();
		Units obj4 = new Units();
		Reports obj5 = new Reports();
		switch(optionNum){
		case 1 : obj.addStudent();
		break;
		case 2 : obj.editStudent();
		break;
		case 3 : obj.deleteStudent();
		break;
		case 4 : obj2.addLecturer();
		break;
		case 5 : obj2.editLecturer();
		break;
		case 6 : obj2.deleteLecturer();
		break;
		case 7 : obj3.addLectureRooms();
		break;
		case 8 : obj3.editLectureRooms();
		break;
		case 9 : obj4.addUnits();
		break;
		case 10 : obj4.editUnits();
		break;
		case 11 : obj.searchStudent(null, null, null);
		break;
		case 12 : obj2.searchLecturer();
		break;
		case 13 : obj3.searchLectureRooms();
		break;
		case 14 : obj4.searchUnits();
		break;
		case 15 : obj3.deleteLectureRooms();
		break;
		case 16 : obj4.deleteUnits();
		break;
		case 17 : try {
				obj5.genarateReport();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		default:
		break;
		}
	
	
	
}	
	}

