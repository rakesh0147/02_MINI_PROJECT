package in.reportapi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.reportapi.binding.CitizenPlan;

@Repository
public interface CitizenPlanRepository extends JpaRepository<CitizenPlan,Serializable>{

	@Query("SELECT DISTINCT c.planName FROM CitizenPlan c ")
	public List<String> findDistinctPlanNames();
	
	@Query("SELECT DISTINCT c.planStatus FROM CitizenPlan c ")
	public List<String> findDistinctPlanStatus();
	
	//public List<CitizenPlan> findByPlanName(String planName);
	
	//public List<CitizenPlan> findByPlanStatus(String planStatus);
	
	//public List<CitizenPlan> findByPlanNameAndPlanStatus(String planName,String planStatus);
	
	
}
