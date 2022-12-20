package in.reportapi.binding;

import lombok.Data;

@Data
public class UserReport {
	
	private Integer userId;
	private String userName;
	private String userEmail;
	private long userMobileNumber;
	private long userssn;
	private String planName;
	private String planStatus;
	private String startDate;
	private String endDate;
	

}
