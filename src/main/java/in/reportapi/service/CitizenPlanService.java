package in.reportapi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.reportapi.binding.CitizenPlan;
import in.reportapi.binding.SearchRequest;

public interface CitizenPlanService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest);
	
	public void exportExcel(HttpServletResponse httpServletResponse)throws Exception;
	
	public void exportPdf(HttpServletResponse httpServletResponse)throws Exception ;

}
