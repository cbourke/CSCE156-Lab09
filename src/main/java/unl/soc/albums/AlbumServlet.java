package unl.soc.albums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import unl.soc.database.DataLoader;

public class AlbumServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final Gson gson = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		//set CORS upfront
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		List<Album> albums = DataLoader.loadAlbumSummaries();
	    JsonElement je = gson.toJsonTree(albums);
	    JsonObject jo = new JsonObject();
	    jo.add("albums", je);
	    String jsonResponse = jo.toString();

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
