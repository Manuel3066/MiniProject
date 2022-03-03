package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Account;
import Model.Car;
import Model.Order;

/**
 * Servlet implementation class ListingServlet
 */
@WebServlet("/listingServlet")
public class ListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListingServlet() {
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
		String path = "/confirm-order.jsp";
		CarHelper ch = new CarHelper();
		AccountHelper ah = new AccountHelper();
		OrderHelper oh = new OrderHelper();
		try {
			Integer accountId = Integer.parseInt(request.getParameter("id"));
			try {
				Integer carId = Integer.parseInt(request.getParameter("carId"));
				LocalDate ld = LocalDate.now();
				Car c = ch.searchForCarById(carId);
				c.setOrdered(true);
				ch.updateCar(c);
				Account a = ah.searchForAccountById(accountId);
				Order o = new Order(a,c,ld);
				oh.insertNewOrder(o);
				request.setAttribute("id", accountId);
			}catch(NumberFormatException e) {
				path = "/listings.jsp";
				request.setAttribute("id", accountId);
				request.setAttribute("allCars", ch.showAllCars());
				System.out.println(e);
			}
			
		}catch(NumberFormatException e) {
			path = "/index.html";
			System.out.println(e);
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
