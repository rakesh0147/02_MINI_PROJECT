package in.reportapi.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.reportapi.binding.CitizenPlan;
import in.reportapi.binding.SearchRequest;
import in.reportapi.service.CitizenPlanService;

@RestController
public class CitizenPlanRestcontroller {
	
	@Autowired
	private CitizenPlanService planService;
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getUniquePlanNames(){
		List<String> plannames=planService.getPlanNames();
		return new ResponseEntity<List<String>>(plannames,HttpStatus.OK);
	}
	
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getUniquePlanStatus(){
		List<String> planstatus=planService.getPlanStatuses();
		return new ResponseEntity<List<String>>(planstatus,HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<CitizenPlan>> getAllCitizenPlans(@RequestBody SearchRequest searchRequest){
		List<CitizenPlan> plans=planService.getCitizenPlans(searchRequest);
		return new ResponseEntity<List<CitizenPlan>>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse httpServletResponse) throws Exception {
		
		httpServletResponse.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=plandetails.xlsx";
		
		httpServletResponse.setHeader(headerKey, headerValue);
		
		planService.exportExcel(httpServletResponse);
		
		httpServletResponse.flushBuffer();
	}
	
	@GetMapping("/pdf")
	public void generatePdfReport(HttpServletResponse httpServletResponse) throws Exception {
		
		httpServletResponse.setContentType("application/pdf");
		
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=plandetails.pdf";
		
		httpServletResponse.setHeader(headerKey, headerValue);
		
		planService.exportPdf(httpServletResponse);
		
		httpServletResponse.flushBuffer();
	}

}
