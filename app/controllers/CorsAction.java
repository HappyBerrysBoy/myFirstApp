package controllers;

import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Response;
import play.mvc.Result;

public static class CorsAction extends Action.Simple {
    public play.libs.F.Promise call(Context context) throws Throwable{
        Response response = context.response();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers","X-Requested-With");
        return delegate.call(context);
    }
}
