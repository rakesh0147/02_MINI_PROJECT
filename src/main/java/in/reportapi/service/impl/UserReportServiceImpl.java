package in.reportapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.reportapi.binding.UserReport;
import in.reportapi.repository.UserReportRepository;
import in.reportapi.service.UserReportService;

public class UserReportServiceImpl implements UserReportService{

	@Autowired
	private UserReportRepository userRepo;
	@Override
	public List<UserReport> getAllUserReport() {
		return userRepo.findAll();
	}

	@Override
	public List<UserReport> getUserReportByPlanName(String planName) {
	
		return userRepo.findByPlanName(planName);
	}

	@Override
	public List<UserReport> getUserReportByPlanStatus(String planStatus) {
		
		return userRepo.findByPlanStatus(planStatus);
	}

	@Override
	public void generateExcelFmt(UserReport userReport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generatePdfFmt(UserReport userReport) {
		// TODO Auto-generated method stub
		
	}

}
