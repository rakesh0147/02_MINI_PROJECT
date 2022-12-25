package in.reportapi.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_PLAN_DTLS")
public class CitizenPlan {
	
	@Id
	@GeneratedValue
	private Integer cid;
	private String cname;
	private String cemail;
	private Long cphone;
	private String gender;
	private String planName;
	private String planStatus;
	private Long csnn;
	

}
