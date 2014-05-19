package controllers;

import models.PLAY_TEST_BAR;
import models.T_vessel_schedule_history;
import models.Task;
import play.mvc.*;
import views.html.*;
import play.data.*;
import play.db.ebean.Model;


public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);
	static Form<T_vessel_schedule_history> berthForm = Form.form(T_vessel_schedule_history.class);
	
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
    	return ok(views.html.berthinfo.render(T_vessel_schedule_history.all(), berthForm));
    }
    
    public static Result berthinfoTerminal(){
    	Form<T_vessel_schedule_history> filledForm = berthForm.bindFromRequest();
		return ok(views.html.berthinfo.render(T_vessel_schedule_history.terminal(filledForm.apply("Terminal").value()), berthForm));
    }
}