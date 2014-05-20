package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

import play.api.libs.json.Json;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Time;

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
	
	public static List<T_vessel_schedule_history> terminal(Form<T_vessel_schedule_history> filledForm){
		T_vessel_schedule_history cls = filledForm.get();
		cls.ins_dt = filledForm.apply("InputDate").value(); 
		cls.terminal_id = filledForm.apply("Terminal").value(); 
		cls.opr = filledForm.apply("OPR").value(); 
		cls.vvd = filledForm.apply("VVD").value(); 
		cls.in_vvd_opr = filledForm.apply("In VVD OPR").value(); 
		cls.out_vvd_opr = filledForm.apply("Out VVD OPR").value(); 
		cls.vsl_name = filledForm.apply("Vsl Name").value(); 
		cls.route = filledForm.apply("Route").value();
		cls.vvd_status = filledForm.apply("Status").value();
		
		cls = T_vessel_schedule_history.chkNullVar(cls);
		
		List<T_vessel_schedule_history> berthInfo = 
			find.where().like("ins_dt", cls.ins_dt).like("terminal_id", cls.terminal_id)
			.like("opr", cls.opr).like("vvd", cls.vvd).like("in_vvd_opr", cls.in_vvd_opr)
			.like("out_vvd_opr", cls.out_vvd_opr).like("vsl_name", cls.vsl_name)
			.like("route", cls.route).like("vvd_status", cls.vvd_status).findList();
		
		return berthInfo;
	}
	
	public static T_vessel_schedule_history chkNullVar(T_vessel_schedule_history cls){
		if(cls.ins_dt.equals(null) || cls.ins_dt.equals("")) cls.ins_dt = "%%%";
		if(cls.terminal_id.equals(null) || cls.terminal_id.equals("")) cls.terminal_id = "%%%";
		if(cls.opr.equals(null) || cls.opr.equals("")) cls.opr = "%%%";
		if(cls.vvd.equals(null) || cls.vvd.equals("")) cls.vvd = "%%%";
		if(cls.in_vvd_opr.equals(null) || cls.in_vvd_opr.equals("")) cls.in_vvd_opr = "%%%";
		if(cls.out_vvd_opr.equals(null) || cls.out_vvd_opr.equals("")) cls.out_vvd_opr = "%%%";
		if(cls.vsl_name.equals(null) || cls.vsl_name.equals("")) cls.vsl_name = "%%%";
		if(cls.route.equals(null) || cls.route.equals("")) cls.route = "%%%";
		if(cls.vvd_status.equals(null) || cls.vvd_status.equals("")) cls.vvd_status = "%%%";
		return cls;
	}
//	public static String getDatePattern(String date){
//	    
//		String sReturn = "";
//		
//    	if(date.length() < 14) return date;
//    
//    	sReturn = date.substring(0, 4);
//    	sReturn += "-";
//    	sReturn += date.substring(4, 6);
//    	sReturn += "-";
//    	sReturn += date.substring(6, 8);
//    	sReturn += " ";
//    	sReturn += date.substring(8, 10);
//    	sReturn += ":";
//    	sReturn += date.substring(10, 12);
//    	sReturn += ":";
//    	sReturn += date.substring(12, 14);
//    	
//    	return sReturn;
//	}
}
