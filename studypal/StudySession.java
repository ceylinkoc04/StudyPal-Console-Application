package studypal;

public class StudySession {
	private String subject;
	private int duration; //in minutes
	private String date;
	
	public StudySession(String subject, int duration, String date) {
		this.subject = subject;
		this.duration = duration;
		this.date = date;
	}
	
	public int getDuration() {
		return duration;	}
	
	public String toString() {
		return subject + "-" +duration + " mins on " + date;
	}
	
	public String getDate() {
	    return date;
	}

}
