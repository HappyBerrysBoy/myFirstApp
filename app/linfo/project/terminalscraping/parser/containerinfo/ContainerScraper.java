package linfo.project.terminalscraping.parser.containerinfo;

import linfo.project.terminalscraping.objects.ContainerInformation;
import linfo.project.terminalscraping.scrapper.Scraper;
import linfo.project.terminalscraping.scrapper.WebSite;


public class ContainerScraper {

	private String tml;
	private String cntr_no;
	private String vsl_cod;
	private String vvd;
	private String year;
	
	public ContainerScraper(){}
	
	public ContainerScraper(String tml, String cntr_no, String vsl_cod, String vvd, String year){
		this.tml = tml;
		this.cntr_no = cntr_no;
		this.vsl_cod = vsl_cod;
		this.vvd = vvd;
		this.year = year;
	}
	
	public void doScraper(){
		try{
			System.out.println("START!@#$%^&%%$#@$%^&%$#@$%^");
			
			System.out.println(tml);
			System.out.println(cntr_no);
			System.out.println(vsl_cod);
			System.out.println(vvd);
			System.out.println(year);
			Scraper s = new Scraper();
			
//			s.addParam(1, "NCCU1283719"); //bit
//			s.addParam(1, "EISU5805440"); //dpct
//			s.addParam(1, "CXDU1713476"); //hktl
//			s.addParam(1, "AMFU3271777"); //HPNT
			s.addParam(1, cntr_no);
			
			for(String item : s.getItems()){
				if(item.equals("ContainerInformation")){
					for(WebSite t : s.getTerminalList(item)){
						if (t.getTerminalId().equals("DPCT")){
							System.out.println("==================" + t.getTerminalId() + "==================");
							System.out.println(s.getHtml(t));
							DPCTContainerInfoParser dpct = new DPCTContainerInfoParser();
							ContainerInformation dpctCntr = new ContainerInformation();
							dpctCntr = dpct.SetContainerInfo(s.getHtml(t));
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
