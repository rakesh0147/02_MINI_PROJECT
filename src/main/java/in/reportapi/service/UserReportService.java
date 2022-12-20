package in.reportapi.service;

import java.util.List;

import in.reportapi.binding.UserReport;

public interface UserReportService {
	
	public List<UserReport> getAllUserReport();
	
    public List<UserReport> getUserReportByPlanName(String planName);
	
	public List<UserReport> getUserReportByPlanStatus(String planStatus);

	
	public void generateExcelFmt(UserReport userReport);
	
	public void generatePdfFmt(UserReport userReport);

}
