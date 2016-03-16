package api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;

/**
 * Servlet implementation class SearchRestaurants
 */
@WebServlet("/restaurants")
public class SearchRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DBConnection connection = new DBConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchRestaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// First Practice
		/*
		 * response.setContentType("application/json");//json can use
		 * response.addHeader("Access-Control-Allow-Origin", "*");//* allows all
		 * people can access String username = ""; PrintWriter out =
		 * response.getWriter();//out is a output buffer if
		 * (request.getParameter("username") != null) { username =
		 * request.getParameter("username"); out.print("Hello " +
		 * username);//print to web/mobile application(client) }
		 * out.flush();//refresh out.close();//delete the buffer
		 */
		// Second Practice
		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println("<html><body>"); out.println(
		 * "<h1>This is a HTML page</h1>"); out.println("</body></html>");//this
		 * method writes directly onto html out.flush(); out.close();
		 */
		// JSON Practice
		/*
		 * response.setContentType("application/json");
		 * response.addHeader("Access-Control-Allow-Origin", "*"); String
		 * username = ""; if (request.getParameter("username") != null) {
		 * username = request.getParameter("username"); } JSONObject obj = new
		 * JSONObject();//map with key and value try { obj.put("username",
		 * username); } catch (JSONException e) { e.printStackTrace(); }
		 * PrintWriter out = response.getWriter(); out.print(obj); out.flush();
		 * out.close();
		 */
		JSONArray array = new JSONArray();

		if (request.getParameterMap().containsKey("user_id") && request.getParameterMap().containsKey("lat")
				&& request.getParameterMap().containsKey("lon")) {
			String userId = request.getParameter("user_id");
			double lat = Double.parseDouble(request.getParameter("lat"));
			double lon = Double.parseDouble(request.getParameter("lon"));
			array = connection.SearchRestaurants(userId, lat, lon);
		}
		RpcParser.writeOutput(response, array);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
