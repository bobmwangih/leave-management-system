package models;

import java.util.List;

public class Approver extends User{

		private List<Review> reviews;

		public Approver(String employeeId, String firstName, String lastName) {
			super(employeeId, firstName, lastName);
			this.reviews = reviews;
		}

		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}

		@Override
		public String toString() {
			return "Approver [reviews=" + reviews + "]";
		}
		
		
}
