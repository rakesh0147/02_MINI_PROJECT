package in.reportapi.service.impl;
 
import java.awt.Color;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.reportapi.binding.CitizenPlan;
import in.reportapi.binding.SearchRequest;
import in.reportapi.repository.CitizenPlanRepository;
import in.reportapi.service.CitizenPlanService;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService{

	@Autowired
	private CitizenPlanRepository cpRepo;
	
	
	@Override
	public List<String> getPlanNames() {	
		return cpRepo.findDistinctPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return cpRepo.findDistinctPlanStatus();
	}

	@Override
	public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest) {
		CitizenPlan entity=new CitizenPlan();
		
		if(searchRequest.getPlanName()!=null&& !searchRequest.getPlanName().equals("")) {
			entity.setPlanName(searchRequest.getPlanName());
		}
		
		if(searchRequest.getPlanStatus()!=null && !searchRequest.getPlanStatus().equals("")) {
			entity.setPlanStatus(searchRequest.getPlanStatus());
		}
		
		Example<CitizenPlan> example=Example.of(entity);
		
		List<CitizenPlan> records = cpRepo.findAll(example);
	
		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse httpServletResponse) throws Exception {
		
		List<CitizenPlan> allPlans=cpRepo.findAll();
		
	   XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Citizen Plan Info");
		
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("PHONE");
		row.createCell(4).setCellValue("GENDER");
		row.createCell(5).setCellValue("PLAN NAME");
		row.createCell(6).setCellValue("PLAN STATUS");
		row.createCell(7).setCellValue("CSNN");
		
		int rowIndex=1;
		
		for(CitizenPlan ctCitizenPlan:allPlans) {
		XSSFRow	dataRow=sheet.createRow(rowIndex);
		dataRow.createCell(0).setCellValue(ctCitizenPlan.getCid());
		dataRow.createCell(1).setCellValue(ctCitizenPlan.getCname());
		dataRow.createCell(2).setCellValue(ctCitizenPlan.getCemail());
		dataRow.createCell(3).setCellValue(ctCitizenPlan.getCphone());
		dataRow.createCell(4).setCellValue(ctCitizenPlan.getGender());
		dataRow.createCell(5).setCellValue(ctCitizenPlan.getPlanName());
		dataRow.createCell(6).setCellValue(ctCitizenPlan.getPlanStatus());
		dataRow.createCell(7).setCellValue(ctCitizenPlan.getCsnn());
		rowIndex ++;
		}
		
		ServletOutputStream ops=httpServletResponse.getOutputStream();
		
		workbook.write(ops);
		
		workbook.close();
		ops.close();
	}

	@Override
	public void exportPdf(HttpServletResponse httpServletResponse) throws Exception {
		
		
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f,2.3f,2.5f});
        table.setSpacingBefore(10);
         
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font cellfont = FontFactory.getFont(FontFactory.HELVETICA);
        cellfont.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("ID", cellfont));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("NAME", cellfont));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("EMAIL", cellfont));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("PHONE", cellfont));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("GENDER", cellfont));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("PLAN NAME", cellfont));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("PLAN STATUS", cellfont));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("SNN", cellfont));
        table.addCell(cell);
        
        List<CitizenPlan> records=cpRepo.findAll();
        
        for (CitizenPlan record :records) {
            table.addCell(String.valueOf(record.getCid()));
            table.addCell(record.getCname());
            table.addCell(record.getCemail());
            table.addCell(String.valueOf(record.getCphone()));
            table.addCell(record.getGender());
            table.addCell(record.getPlanName());
            table.addCell(record.getPlanStatus());
            table.addCell(String.valueOf(record.getCsnn()));
            
        }
         
        document.add(table);
         
        document.close();
         
	}

	
}
