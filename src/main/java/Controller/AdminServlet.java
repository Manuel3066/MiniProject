package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Integer id = Integer.parseInt(request.getParameter("id"));
		if(action == null) {
			getServletContext().getRequestDispatcher("/admin-home.jsp").forward(request, response);
		}
		if(action.equals("View As Customer")) {
			request.setAttribute("id", id);
			CarHelper ch = new CarHelper();
			request.setAttribute("allCars", ch.showAllCars());
			getServletContext().getRequestDispatcher("/listings.jsp").forward(request, response);
		}
		if(action.equals("Modify Listings")) {
			request.setAttribute("id", id);
			getServletContext().getRequestDispatcher("/modify-listings.jsp").forward(request, response);
		}
		if(action.equals("Create Listing")) {
			request.setAttribute("id", id);
			getServletContext().getRequestDispatcher("/create-listing.jsp").forward(request, response);
		}
		if(action.equals("View Orders")) {
			request.setAttribute("id", id);
			getServletContext().getRequestDispatcher("/view-orders.jsp").forward(request, response);
		}
	}

}
