package in.reportapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.reportapi.binding.UserReport;

public interface UserReportRepository extends JpaRepository<UserReport,Integer>{

	public List<UserReport> findByPlanName(String planName);
	
	public List<UserReport> findByPlanStatus(String planStatus);

}
