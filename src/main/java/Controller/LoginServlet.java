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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(!email.equals("")&&!password.equals("")) {
			AccountHelper ah = new AccountHelper();
			List<Account> foundAccount = ah.searchForAccountByEmail(email);
			if(foundAccount.isEmpty()) {
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				request.setAttribute("message", "Incorect Email or Password!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else {
				for(Account account: foundAccount) {
					String foundPassword = account.getPassword();
					if(foundPassword.equals(password)) {
						if(account.getAccountId() == 253) {
							request.setAttribute("id", account.getAccountId());
							getServletContext().getRequestDispatcher("/admin-home.jsp").forward(request, response);
							break;
						}
						else {
							CarHelper ch = new CarHelper();
							request.setAttribute("allCars", ch.showAllCars());
							request.setAttribute("id", account.getAccountId());
							getServletContext().getRequestDispatcher("/listings.jsp").forward(request, response);
						}
					}
					else {
						request.setAttribute("email", email);
						request.setAttribute("password", password);
						request.setAttribute("message", "Incorect Email or Password!");
						getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}
			}
			
		}
		else{
			request.setAttribute("message", "All Fields Must Not Be Empty!");
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
