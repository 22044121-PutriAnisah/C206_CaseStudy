	import java.time.LocalDate;

	public class feedback {
		private int id;
		private String feedback;
		private LocalDate date;
		private String comments;
		
		public feedback(int id, String feedback, LocalDate date, String comments) {
			this.id = id;
			this.feedback = feedback;
			this.date = date;
			this.comments = comments;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int yes) {
			this.id = yes;
		}
		
		public String getfeedback() {
			return feedback;
		}
		
		public void setfeedback(String edit) {
			this.feedback = edit;
		}
		
		public LocalDate getDate() {
			return date;
		}
		
		public String getComment() {
			return comments;
		}
		
		public void setComment(String comme) {
			this.comments = comme;
		}
		
		public String toString() {
			String itemInfo = String.format("%-10s %-20s %-20s %-10s", id, feedback, date, comments);
			return itemInfo;
			
		}
	}
