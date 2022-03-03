package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Account;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if(!firstName.equals("")&&!lastName.equals("")&&!address.equals("")&&!phoneNumber.equals("")&&!email.equals("")&&!password.equals("")&&!password2.equals("")) {
			AccountHelper ah = new AccountHelper();
			List<Account> foundItems = ah.searchForAccountByEmail(email);
			if(foundItems.isEmpty()) {
				if(password.equals(password2)) {
					Account account = new Account(email,password,firstName,lastName,address,phoneNumber);
					ah.insertAccount(account);
					getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else {
					request.setAttribute("message", "Passwords must be Identical");
					request.setAttribute("firstName", firstName);
					request.setAttribute("lastName", lastName);
					request.setAttribute("address", address);
					request.setAttribute("phoneNumber", phoneNumber);
					request.setAttribute("email", email);
					request.setAttribute("password", password);
					request.setAttribute("password2", password2);
					getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("message", "Email Already Registered");
				request.setAttribute("firstName", firstName);
				request.setAttribute("lastName", lastName);
				request.setAttribute("address", address);
				request.setAttribute("phoneNumber", phoneNumber);
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				request.setAttribute("password2", password2);
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("message", "All Fields Must Not Be Empty!");
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("address", address);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("password2", password2);
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

}
