package models;

import java.util.List;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import play.data.Form;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class T_vessel_schedule extends Model{

	public String terminal_id;
	public String vsl_cod;
	public String vvd;
	public String vvd_year;
	public String opr;
	public String in_vvd_opr;
	public String out_vvd_opr;
	public String berth_no;
	public String cct;
	public String etb;
	public String etd;
	public String atb;
	public String atd;
	public String load_cnt;
	public String dis_cnt;
	public String shift_cnt;
	public String vvd_status;
	public String vsl_name;
	public String route;

	public static Finder<Long, T_vessel_schedule> find = new Finder(String.class, T_vessel_schedule.class);
	
	public static List<T_vessel_schedule> all(){
//		DateTime dt = new DateTime();
//		String today = "" + dt.now().getYear() + String.format("%02d", dt.now().getMonthOfYear()) +  String.format("%02d", dt.now().getDayOfMonth());
//		String fromTime = "" + String.format("%02d", dt.now().getHourOfDay() - 1) + String.format("%02d", dt.now().getMinuteOfHour()) + String.format("%02d", dt.now().getSecondOfMinute());
//		String toTime = "" + String.format("%02d", dt.now().getHourOfDay()) + String.format("%02d", dt.now().getMinuteOfHour()) + String.format("%02d", dt.now().getSecondOfMinute());
//		System.out.println("Today : " + today);
		
//		return find.where().orderBy("terminal_id").findList();
		return find.all();
	}
	
	public static List<T_vessel_schedule> terminal(String tml, String vcod, String vvd, String year, String opr, 
			String in_vvd_opr, String out_vvd_opr, String berth_no, String cct, String etb, String etd, 
			String atb, String atd, String vvd_status, String vsl_name, String route){
		if(tml == null) tml = "%%%";
		if(vcod == null) vcod = "%%%";
		if(vvd == null) vvd = "%%%";
		if(year == null) year = "%%%";
		if(opr == null) opr = "%%%";
		if(in_vvd_opr == null) in_vvd_opr = "%%%";
		if(out_vvd_opr == null) out_vvd_opr = "%%%";
		if(berth_no == null) berth_no = "%%%";
		if(cct == null) cct = "%%%";
		if(etb == null) etb = "%%%";
		if(etd == null) etd = "%%%";
		if(atb == null) atb = "%%%";
		if(atd == null) atd = "%%%";
		if(vvd_status == null) vvd_status = "%%%";
		if(vsl_name == null) vsl_name = "%%%";
		if(route == null) route = "%%%";
		
		List<T_vessel_schedule> berthInfo = find.where().like("terminal_id", tml).like("vsl_cod", vcod).like("vvd", vvd)
				.like("vvd_year", year).like("opr", opr).like("in_vvd_opr", in_vvd_opr)
				.like("out_vvd_opr", out_vvd_opr).like("berth_no", berth_no).like("cct", cct)
				.like("etb", etb).like("etd", etd).like("atb", atb)
				.like("atd", atd).like("vvd_status", vvd_status).like("vsl_name", vsl_name).like("route", route)
				.orderBy("terminal_id").findList();
//				.findPagingList(25).setFetchAhead(false).getPage(1).getList();
		return berthInfo;
	}
	
	public static List<T_vessel_schedule> terminal(Form<T_vessel_schedule> filledForm){
		T_vessel_schedule cls = filledForm.get();
		//http://hnctech73.iptime.org:9000/berthJson?vvd_status=&atd=&cct=&etb=&etd=&in_vvd_opr=&opr=&out_vvd_opr=&route=&terminal_id=&vsl_name=&vvd=&atb=
//		System.out.println("====================================================");
//		System.out.println("terminal_id:" + filledForm.field("terminal_id").value());
//		System.out.println("opr:" + filledForm.field("opr").value());
//		System.out.println("vvd:" + filledForm.field("vvd").value());
//		System.out.println("in_vvd_opr:" + filledForm.field("in_vvd_opr").value());
//		System.out.println("out_vvd_opr:" + filledForm.field("out_vvd_opr").value());
//		System.out.println("vsl_name:" + filledForm.field("vsl_name").value());
//		System.out.println("route:" + filledForm.field("route").value());
//		System.out.println("vvd_status:" + filledForm.field("vvd_status").value());
//		System.out.println("cct:" + filledForm.field("cct").value());
//		System.out.println("etb:" + filledForm.field("etb").value());
//		System.out.println("etd:" + filledForm.field("etd").value());
//		System.out.println("atb:" + filledForm.field("atb").value());
//		System.out.println("atd:" + filledForm.field("atd").value());
		
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
		
		cls = T_vessel_schedule.chkNullVar(cls);
		
//		System.out.println("====================================================");
//		System.out.println("terminal_id:" + cls.terminal_id);
//		System.out.println("opr:" + cls.opr);
//		System.out.println("vvd:" + cls.vvd);
//		System.out.println("in_vvd_opr:" + cls.in_vvd_opr);
//		System.out.println("out_vvd_opr:" + cls.out_vvd_opr);
//		System.out.println("vsl_name:" + cls.vsl_name);
//		System.out.println("route:" + cls.route);
//		System.out.println("vvd_status:" + cls.vvd_status);
//		System.out.println("cct:" + cls.cct);
//		System.out.println("etb:" + cls.etb);
//		System.out.println("etd:" + cls.etd);
//		System.out.println("atb:" + cls.atb);
//		System.out.println("atd:" + cls.atd);
		
		List<T_vessel_schedule> berthInfo = 
			find.where().like("terminal_id", cls.terminal_id)
			.like("opr", cls.opr).like("vvd", cls.vvd).like("in_vvd_opr", cls.in_vvd_opr)
			.like("out_vvd_opr", cls.out_vvd_opr).like("vsl_name", cls.vsl_name)
			.like("route", cls.route).like("vvd_status", cls.vvd_status).like("cct", cls.cct)
			.like("etb", cls.etb).like("etd", cls.etd)
			.like("atb", cls.atb).like("atd", cls.atd)
			.findList();
		
		return berthInfo;
	}
	
	public static T_vessel_schedule chkNullVar(T_vessel_schedule cls){
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
}
