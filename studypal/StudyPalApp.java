package studypal;
import java.util.Scanner;
public class StudyPalApp {
	
	private static int dailyGoal = 0; 

	public static void main(String[] args) {
		//We will put menus or user inputs etc. into this class
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to StudyPal!");
		
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine(); 
		
		System.out.println("Please enter your age: ");
		int age = scanner.nextInt(); 
		scanner.nextLine();  // clear the buffer
		
		Student stu = new Student(name,age);
		
		//show the main menu
		boolean running = true;
		while (running) {
			System.out.println("\n--- StudyPal Menu ---");
			System.out.println("1. Add Study Session");
			System.out.println("2. View Total Study Time");
			System.out.println("3. View My Information");
			System.out.println("4. View All Study Sessions");
			System.out.println("5. Set and Check Daily Study Goal");
			System.out.println("6. Exit");
			
			System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
			
            switch (choice) {
            case 1:
            	addStudySession(scanner, stu);
            	break;
            case 2:
            	viewTotalStudyTime(stu);
                break;
            case 3:
            	viewMyInformation(stu);
                break;
            case 4:
                viewAllSessions(stu);
                break;
            case 5:
            	setAndCheckGoal(scanner,stu);
            	break;          	
            case 6:
            	running=false;
            	System.out.println("Goodbye!");
            	break;
            default:
            	System.out.println("Invalid option, please try again.");
         
            }
			
		}

	}
	
	private static void addStudySession(Scanner scanner, Student stu) {
		System.out.println("Enter the subject of the study session: ");
		String subject = scanner.nextLine();
		
		System.out.println("Enter the duration of the study session (in minutes): ");
		int duration=scanner.nextInt();
		scanner.nextLine(); // clear the buffer
		
		System.out.println("Enter the date of the study session (e.g. 2025-04-20)");
	    String date = scanner.nextLine();
	    
	    //create and add a new study session 
	    StudySession session = new StudySession(subject,duration,date);
	    stu.addSession(session);
	    
	    System.out.println("Study session added successfully!"); }
	
	//total study time
	private static void viewTotalStudyTime(Student stu) {
	    int totalMinutes = stu.calculateTotalMinutes();
	    int hours = totalMinutes / 60;
	    int minutes = totalMinutes % 60;
	    System.out.println("Total study time: " + hours + " hours and " + minutes + " minutes");
	}
	
	private static void viewAllSessions(Student stu) {
	    for (StudySession session : stu.getSessions()) {
	        System.out.println(session); 
	    }
	}

    // displaying user info
    private static void viewMyInformation(User user) {
        user.displayInfo();
    }
    
    private static void setAndCheckGoal(Scanner scanner, Student stu) {
    	System.out.println("Enter your daily study goal in minutes: ");
    	dailyGoal=scanner.nextInt();
    	scanner.nextLine(); // clean the buffer
    	
    	System.out.println("Enter today's date (e.g 2025-04-20): ");
    	String today=scanner.nextLine();
    	
    	int todayTotal= 0 ;
    	for (StudySession session : stu.getSessions()) {
    		if(session.getDate().equals(today)) {
    			todayTotal += session.getDuration();}
    		}
    System.out.println("\nToday's study time: "+ todayTotal + " minutes");
    if(todayTotal >= dailyGoal) { 
    	System.out.println(":) Congratulations! You reached your goal!"); 
    	System.out.println("Keep up the great work! You're on fire!");}
    else {
        System.out.println(":( You need " + (dailyGoal - todayTotal) + " more minutes to reach your goal.");
        System.out.println("Don't give up! Keep pushing!");
    }
    	
    	}
    }

	    
		
	

	


