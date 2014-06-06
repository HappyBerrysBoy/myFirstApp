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
		DateTime dt = new DateTime();
		String today = "" + dt.now().getYear() + String.format("%02d", dt.now().getMonthOfYear()) +  String.format("%02d", dt.now().getDayOfMonth());
		String fromTime = "" + String.format("%02d", dt.now().getHourOfDay() - 1) + String.format("%02d", dt.now().getMinuteOfHour()) + String.format("%02d", dt.now().getSecondOfMinute());
		String toTime = "" + String.format("%02d", dt.now().getHourOfDay()) + String.format("%02d", dt.now().getMinuteOfHour()) + String.format("%02d", dt.now().getSecondOfMinute());
		System.out.println("Today : " + today);
		
		return find.where().like("ins_dt", today).between("ins_tm", fromTime, toTime).orderBy("ins_dt desc, ins_tm desc, terminal_id").findList();
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
		
		System.out.println("====================================================");
		System.out.println("ins_dt:" + filledForm.field("ins_dt").value());
		System.out.println("ins_tm:" + filledForm.field("ins_tm").value());
		System.out.println("terminal_id:" + filledForm.field("terminal_id").value());
		System.out.println("opr:" + filledForm.field("opr").value());
		System.out.println("vvd:" + filledForm.field("vvd").value());
		System.out.println("in_vvd_opr:" + filledForm.field("in_vvd_opr").value());
		System.out.println("out_vvd_opr:" + filledForm.field("out_vvd_opr").value());
		System.out.println("vsl_name:" + filledForm.field("vsl_name").value());
		System.out.println("route:" + filledForm.field("route").value());
		System.out.println("vvd_status:" + filledForm.field("vvd_status").value());
		System.out.println("cct:" + filledForm.field("cct").value());
		System.out.println("etb:" + filledForm.field("etb").value());
		System.out.println("etd:" + filledForm.field("etd").value());
		System.out.println("atb:" + filledForm.field("atb").value());
		System.out.println("atd:" + filledForm.field("atd").value());
		
		cls.ins_dt 		= filledForm.field("ins_dt").value(); 
		cls.ins_tm 		= filledForm.field("ins_tm").value(); 
		cls.terminal_id = filledForm.field("terminal_id").value(); 
		cls.opr 		= filledForm.field("opr").value(); 
		cls.vvd 		= filledForm.field("vvd").value(); 
		cls.in_vvd_opr 	= filledForm.field("in_vvd_opr").value(); 
		cls.out_vvd_opr = filledForm.field("out_vvd_opr").value(); 
		cls.vsl_name 	= filledForm.field("vsl_name").value(); 
		cls.route 		= filledForm.field("route").value();
		cls.vvd_status 	= filledForm.field("vvd_status").value();
		cls.cct		 	= filledForm.field("cct").value();
		cls.etb 		= filledForm.field("etb").value();
		cls.etd 		= filledForm.field("etd").value();
		cls.atb 		= filledForm.field("atb").value();
		cls.atd 		= filledForm.field("atd").value();
		
		cls = T_vessel_schedule_history.chkNullVar(cls);
		
		System.out.println("====================================================");
		System.out.println("ins_dt:" + cls.ins_dt);
		System.out.println("ins_tm:" + cls.ins_tm);
		System.out.println("terminal_id:" + cls.terminal_id);
		System.out.println("opr:" + cls.opr);
		System.out.println("vvd:" + cls.vvd);
		System.out.println("in_vvd_opr:" + cls.in_vvd_opr);
		System.out.println("out_vvd_opr:" + cls.out_vvd_opr);
		System.out.println("vsl_name:" + cls.vsl_name);
		System.out.println("route:" + cls.route);
		System.out.println("vvd_status:" + cls.vvd_status);
		System.out.println("cct:" + cls.cct);
		System.out.println("etb:" + cls.etb);
		System.out.println("etd:" + cls.etd);
		System.out.println("atb:" + cls.atb);
		System.out.println("atd:" + cls.atd);
		
		List<T_vessel_schedule_history> berthInfo = 
			find.where().like("ins_dt", cls.ins_dt).like("ins_tm", cls.ins_tm).like("terminal_id", cls.terminal_id)
			.like("opr", cls.opr).like("vvd", cls.vvd).like("in_vvd_opr", cls.in_vvd_opr)
			.like("out_vvd_opr", cls.out_vvd_opr).like("vsl_name", cls.vsl_name)
			.like("route", cls.route).like("vvd_status", cls.vvd_status).like("cct", cls.cct)
			.like("etb", cls.etb).like("etd", cls.etd)
			.like("atb", cls.atb).like("atd", cls.atd)
			.findList();
		
		return berthInfo;
	}
	
	public static T_vessel_schedule_history chkNullVar(T_vessel_schedule_history cls){
		if(cls.ins_dt.equals(null) 		|| cls.ins_dt.equals("")) 		cls.ins_dt = "%%%";
		if(cls.ins_tm.equals(null) 		|| cls.ins_tm.equals("")) 		cls.ins_tm = "%%%";
		if(cls.terminal_id.equals(null) || cls.terminal_id.equals("")) 	cls.terminal_id = "%%%";
		if(cls.opr.equals(null) 		|| cls.opr.equals("")) 			cls.opr = "%%%";
		if(cls.vvd.equals(null) 		|| cls.vvd.equals("")) 			cls.vvd = "%%%";
		if(cls.in_vvd_opr.equals(null) 	|| cls.in_vvd_opr.equals("")) 	cls.in_vvd_opr = "%%%";
		if(cls.out_vvd_opr.equals(null) || cls.out_vvd_opr.equals("")) 	cls.out_vvd_opr = "%%%";
		if(cls.vsl_name.equals(null) 	|| cls.vsl_name.equals("")) 	cls.vsl_name = "%%%";
		if(cls.route.equals(null) 		|| cls.route.equals("")) 		cls.route = "%%%";
		if(cls.vvd_status.equals(null) 	|| cls.vvd_status.equals("")) 	cls.vvd_status = "%%%";
		if(cls.cct.equals(null) 		|| cls.cct.equals("")) 			cls.cct = "%%%";
		if(cls.etb.equals(null) 		|| cls.etb.equals("")) 			cls.etb = "%%%";
		if(cls.etd.equals(null) 		|| cls.etd.equals("")) 			cls.etd = "%%%";
		if(cls.atb.equals(null) 		|| cls.atb.equals("")) 			cls.atb = "%%%";
		if(cls.atd.equals(null) 		|| cls.atd.equals("")) 			cls.atd = "%%%";
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
