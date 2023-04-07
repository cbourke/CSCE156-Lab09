package unl.soc.albums;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import unl.soc.database.DataLoader;

public class AlbumDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final Gson gson = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		int albumId = Integer.parseInt(request.getParameter("albumId"));
		
		//set CORS upfront
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		Album a = DataLoader.loadDetailedAlbum(albumId);
		if(a == null) {
			try {
				//alright alright alright
				response.sendError(420);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	    JsonElement je = gson.toJsonTree(a);
	    JsonObject jo = new JsonObject();
	    jo.add("album", je);
	    String jsonResponse = jo.toString();
	    System.out.println(jsonResponse);

	    response.setContentType("application/json");
	    PrintWriter out;
		try {
			out = response.getWriter();
		    out.print(jsonResponse);
		    out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	 
	}
	

}
