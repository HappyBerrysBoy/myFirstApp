package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class T_vessel_schedule_history extends Model{

	public String ins_dt;
	public String ins_tm;
	public String terminal_id;
	public String berth_no;
	public String opr;
	public String vvd;
	public String in_vvd_opr;
	public String out_vvd_opr;
	public String vsl_name;
	public String route;
	public String cct;
	public String etb;
	public String etd;
	public String atb;
	public String atd;
	public String load_cnt;
	public String dis_cnt;
	public String shift_cnt;
	public String vvd_status;
	
public static Finder<Long, T_vessel_schedule_history> find = new Finder(Long.class, T_vessel_schedule_history.class);
	
	public static List<T_vessel_schedule_history> all(){
		return find.where().orderBy("ins_dt desc, ins_tm desc, terminal_id").findList();
	}
	
	public static List<T_vessel_schedule_history> terminal(String terminalName){
		if(terminalName.equals(""))
			terminalName = "%%%";
		List<T_vessel_schedule_history> berthInfo = find.where().like("terminal_id", terminalName).orderBy("ins_dt desc, ins_tm desc, terminal_id").findList();
//				.findPagingList(25).setFetchAhead(false).getPage(1).getList();
		return berthInfo;
				
	}
	
	public static String getDatePattern(String date){
	    
		String sReturn = "";
		
    	if(date.length() < 14) return date;
    
    	sReturn = date.substring(0, 4);
    	sReturn += "-";
    	sReturn += date.substring(4, 6);
    	sReturn += "-";
    	sReturn += date.substring(6, 8);
    	sReturn += " ";
    	sReturn += date.substring(8, 10);
    	sReturn += ":";
    	sReturn += date.substring(10, 12);
    	sReturn += ":";
    	sReturn += date.substring(12, 14);
    	
    	return sReturn;
	}
}
