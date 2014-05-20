package controllers;

import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.PLAY_TEST_BAR;
import models.T_vessel_schedule_history;
import models.Task;
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import play.data.*;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);
	static Form<T_vessel_schedule_history> berthForm = Form.form(T_vessel_schedule_history.class);
	
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
    	return ok(views.html.berthinfo.render(T_vessel_schedule_history.all(), berthForm));
    }
    
    public static Result berthinfoTerminal(){
    	System.out.println("Request Time(berthinfoTerminal) : " + GregorianCalendar.getInstance());
    	Form<T_vessel_schedule_history> filledForm = berthForm.bindFromRequest();
		return ok(views.html.berthinfo.render(T_vessel_schedule_history.terminal(filledForm.apply("Terminal").value()), berthForm));
    }
    
    public static Result berthinfoJson(){
    	System.out.println("Request Time(berthinfoJson) : " + GregorianCalendar.getInstance());
//    	List<T_vessel_schedule_history> berthInfo = new Model.Finder(String.class, T_vessel_schedule_history.class).all();
    	return ok(Json.toJson(T_vessel_schedule_history.all()));
    }
    
    public static Result berthinfoTerminalJson(){
    	System.out.println("Request Time(berthinfoTerminalJson) : " + GregorianCalendar.getInstance());
    	return ok(Json.toJson(T_vessel_schedule_history.terminal(berthForm.bindFromRequest())));
    }
}
