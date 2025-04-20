package studypal;
import java.util.ArrayList;
public class Student extends User {
	private ArrayList<StudySession> sessions;
	
	public Student(String name, int age) {
		super(name,age);
		sessions= new ArrayList<>();}
	
	public void addSession(StudySession session) {
		sessions.add(session);	}
	
	public ArrayList<StudySession> getSessions(){
		return sessions;
	}
	
	public int calculateTotalMinutes() {
		int total = 0;
		for (StudySession session : sessions ) {
			total += session.getDuration();
		}
		return total;}
	
	@Override
	public void displayInfo() {
		System.out.println("Student: "+ name+ ", Age : " + age);
		System.out.println("Total study time: " + calculateTotalMinutes() + "minutes" );
	}

}
