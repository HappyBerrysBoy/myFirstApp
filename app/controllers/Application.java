package controllers;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import linfo.project.terminalscraping.parser.containerinfo.ContainerScraper;
import models.PLAY_TEST_BAR;
import models.T_vessel_schedule;
import models.T_vessel_schedule_history;
import models.Task;
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import play.api.mvc.Request;
import play.data.*;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);
	static Form<T_vessel_schedule> berthForm = Form.form(T_vessel_schedule.class);
	
	public static Result getTasks(){
		List<Task> tasks = new Model.Finder(Long.class, Task.class).all();
		return ok(Json.toJson(tasks));
	}
	
	public static Result index() {
//		Result ok = ok("Hello world!");
//		Result notFound = notFound();
//		Result pageNotFound = notFound("<h1>Page not found</h1>").as("text/html");
//		Result badRequest = badRequest(views.html.form.render(formWithErrors));
//		Result oops = internalServerError("Oops");
//		Result anyStatus = status(488, "Strange response type");
//		return redirect(routes.Application.tasks());
//		return redirect(routes.Application.berthinfo());
		return ok(index.render("Start.. Berth Information!!!"));
	}

    public static Result tasks(){
    	return ok(views.html.task.render(Task.all(), taskForm));
    }
    
    public static Result newTask(){
    	Form<Task> filledForm = taskForm.bindFromRequest();
    	if(filledForm.hasErrors()){
    		return badRequest(views.html.task.render(Task.all(), filledForm));
    	}else{
    		Task.create(filledForm.get());
    		return redirect(routes.Application.tasks());
    	}
    }
    
    public static Result deleteTask(Long id){
		Task.delete(id);
		return redirect(routes.Application.tasks());
    }
    
    
    public static Result berthinfo(){
    	System.out.println("Request Time(berthinfo) : " + GregorianCalendar.getInstance());
    	return ok(views.html.berthinfo.render(T_vessel_schedule.all(), berthForm));
    }
    
    
    public static Result getBerthinfo(){
//    	final Set<Map.Entry<String,String[]>> entries = request().queryString().entrySet();
//        for (Map.Entry<String,String[]> entry : entries) {
//            final String key = entry.getKey();
//            final String value = Arrays.toString(entry.getValue());
//            Logger.debug(key + " " + value);
//        }
    	String tml = request().getQueryString("tml");
    	String vcod = request().getQueryString("vcod");
    	String vvd = request().getQueryString("vvd");
    	String year = request().getQueryString("year");
    	String opr = request().getQueryString("opr");
    	String in_vvd_opr = request().getQueryString("in_vvd_opr");
    	String out_vvd_opr = request().getQueryString("out_vvd_opr");
    	String berth_no = request().getQueryString("berth_no");
    	String cct = request().getQueryString("cct");
    	String etb = request().getQueryString("etb");
    	String etd = request().getQueryString("etd");
    	String atb = request().getQueryString("atb");
    	String atd = request().getQueryString("atd");
    	String vvd_status = request().getQueryString("vvd_status");
    	String vsl_name = request().getQueryString("vsl_name");
    	String route = request().getQueryString("route");
    	
    	response().setHeader("Access-Control-Allow-Origin", "*");       // Need to add the correct domain in here!!
//        response().setHeader("Access-Control-Allow-Methods", "POST");   // Only allow POST
//        response().setHeader("Access-Control-Max-Age", "300");          // Cache response for 5 minutes
//        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");         // Ensure this header is also allowed!
    	
    	System.out.println("tml:" + tml + ",vcod:" + vcod + ",vvd:" + vvd + ",year:" + year + ",opr:" + opr + ",in_vvd_opr:" + ",out_vvd_opr:" + berth_no + ",cct:" + cct + ",etb:" + etb + ",etd:" + etd + ",atb:" + atb + ",atd:" + atd + ",vvd_status:" + vvd_status + ",vsl_name:" + vsl_name + ",route:" + route);
    	
    	return ok(Json.toJson(T_vessel_schedule.terminal(tml, vcod, vvd, year, opr, in_vvd_opr, out_vvd_opr, berth_no, cct, etb, etd, atb, atd, vvd_status, vsl_name, route)));
    }
    
    public static Result berthinfoTerminal(){
    	System.out.println("Request Time(berthinfoTerminal) : " + GregorianCalendar.getInstance());
    	Form<T_vessel_schedule> filledForm = berthForm.bindFromRequest();
		return ok(views.html.berthinfo.render(T_vessel_schedule.terminal(berthForm.bindFromRequest()), berthForm));
    }
    
    public static Result berthinfoAllJson(){
    	System.out.println("Request Time(berthinfoJson) : " + GregorianCalendar.getInstance());
//    	List<T_vessel_schedule_history> berthInfo = new Model.Finder(String.class, T_vessel_schedule_history.class).all();
    	return ok(Json.toJson(T_vessel_schedule.all()));
    }
    
    public static Result berthinfoTerminalJson(){
//    	System.out.println("Request Time(berthinfoTerminalJson) : " + GregorianCalendar.getInstance());
//    	return ok(Json.toJson(T_vessel_schedule.terminal(berthForm.bindFromRequest())));
    	String tml = request().getQueryString("tml");
    	String vcod = request().getQueryString("vcod");
    	String vvd = request().getQueryString("vvd");
    	String year = request().getQueryString("year");
    	String opr = request().getQueryString("opr");
    	String in_vvd_opr = request().getQueryString("in_vvd_opr");
    	String out_vvd_opr = request().getQueryString("out_vvd_opr");
    	String berth_no = request().getQueryString("berth_no");
    	String cct = request().getQueryString("cct");
    	String etb = request().getQueryString("etb");
    	String etd = request().getQueryString("etd");
    	String atb = request().getQueryString("atb");
    	String atd = request().getQueryString("atd");
    	String vvd_status = request().getQueryString("vvd_status");
    	String vsl_name = request().getQueryString("vsl_name");
    	String route = request().getQueryString("route");
    	
    	response().setHeader("Access-Control-Allow-Origin", "*");       // Need to add the correct domain in here!!
//        response().setHeader("Access-Control-Allow-Methods", "POST");   // Only allow POST
//        response().setHeader("Access-Control-Max-Age", "300");          // Cache response for 5 minutes
//        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");         // Ensure this header is also allowed!
        
    	System.out.println("tml:" + tml + ",vcod:" + vcod + ",vvd:" + vvd + ",year:" + year + ",opr:" + opr + ",in_vvd_opr:" + ",out_vvd_opr:" + berth_no + ",cct:" + cct + ",etb:" + etb + ",etd:" + etd + ",atb:" + atb + ",atd:" + atd + ",vvd_status:" + vvd_status + ",vsl_name:" + vsl_name + ",route:" + route);
    	
    	return ok(Json.toJson(T_vessel_schedule.terminal(tml, vcod, vvd, year, opr, in_vvd_opr, out_vvd_opr, berth_no, cct, etb, etd, atb, atd, vvd_status, vsl_name, route)));
    }
    
    public static Result checkPreFlight(){
    	response().setHeader("Access-Control-Allow-Origin", "*");       // Need to add the correct domain in here!!
    	return ok();
    }
    
    public static Result getContainerInfo(){
    	String cntr_no = request().getQueryString("cntr_no");
    	String tml = request().getQueryString("tml");
    	String vsl_cod = request().getQueryString("vsl_cod");
    	String vvd = request().getQueryString("vvd");
    	String year = request().getQueryString("year");
    	
    	ContainerScraper cs = new ContainerScraper(tml, cntr_no, vsl_cod, vvd, year);
    	cs.doScraper();
    	
    	return ok(index.render(cntr_no + tml));
    }
}
