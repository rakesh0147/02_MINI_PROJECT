package in.reportapi.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.reportapi.binding.CitizenPlan;
import in.reportapi.repository.CitizenPlanRepository;

@Component
public class CitizenPlanRunner implements ApplicationRunner{

	@Autowired
	private CitizenPlanRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CitizenPlan cp1=new CitizenPlan();
		cp1.setCname("Jhon");
		cp1.setCemail("abc@gmail.com");
		cp1.setCphone(89689098l);
		cp1.setGender("Male");
		cp1.setPlanName("APPN");
		cp1.setPlanStatus("Approved");
		cp1.setCsnn(8465789809l);
		
		CitizenPlan cp2=new CitizenPlan();
		cp2.setCname("Smith");
		cp2.setCemail("smit@gmail.com");
		cp2.setCphone(907865098l);
		cp2.setGender("Male");
		cp2.setPlanName("APPN");
		cp2.setPlanStatus("Approved");
		cp2.setCsnn(8465789809l);
		
		CitizenPlan cp3=new CitizenPlan();
		cp3.setCname("Jully");
		cp3.setCemail("jully@gmail.com");
		cp3.setCphone(89689098l);
		cp3.setGender("Female");
		cp3.setPlanName("CPPN");
		cp3.setPlanStatus("Denied");
		cp3.setCsnn(8465789809l);
		
		CitizenPlan cp4=new CitizenPlan();
		cp4.setCname("Punam");
		cp4.setCemail("punam@gmail.com");
		cp4.setCphone(89689098l);
		cp4.setGender("Femal");
		cp4.setPlanName("CPPN");
		cp4.setPlanStatus("Denied");
		cp4.setCsnn(8465789809l);
		
		List<CitizenPlan> plan=Arrays.asList(cp1,cp2,cp3,cp4);
		
		repo.saveAll(plan);
		
	}

}
