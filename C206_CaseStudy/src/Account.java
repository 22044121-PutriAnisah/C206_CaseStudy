/**
 * 
 */

/**
 * @author 22044121
 *
 */
public class Account {
	
		private int accountID;
		private int customerID;
		private double accountBalance;
		private String status;
		private String username;
		private String password;
		private String contactInfo;
		
		public Account(int accountID, int customerID, double accountBalance, String status, String username,
				String password, String contactInfo) {
			super();
			this.accountID = accountID;
			this.customerID = customerID;
			this.accountBalance = accountBalance;
			this.status = status;
			this.username = username;
			this.password = password;
			this.contactInfo = contactInfo;
		}

		public Account(int accountID, int customerID, double accountBalance, String username,
				String password, String contactInfo) {
			super();
			this.accountID = accountID;
			this.customerID = customerID;
			this.accountBalance = accountBalance;
			this.username = username;
			this.password = password;
			this.contactInfo = contactInfo;
			this.status = "Active";
		}

		public int getAccountID() {
			return accountID;
		}

		public void setAccountID(int accountID) {
			this.accountID = accountID;
		}

		public int getCustomerID() {
			return customerID;
		}

		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}

		public double getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getContactInfo() {
			return contactInfo;
		}

		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}
		
		
		
	}

