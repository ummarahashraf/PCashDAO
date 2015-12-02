

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	RequestDispatcher dis;
	UserDAO udao= new UserDAO();
	UserModel um =new UserModel();
	
    public LoginServlet() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user,pass;
		user=request.getParameter("user");
		pass=request.getParameter("pass");
		System.out.println(user+pass);
		
		um.setUser(user);
		um.setPass(pass);
		if(udao.CheckUser(um))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user",um.getUser());
			System.out.println("logged in");
			dis=request.getRequestDispatcher("TransactionServlet?action=showAll");
			//dis.forward(request, response);
			
		}
		else{ 
			System.out.println("error");
			dis=request.getRequestDispatcher("error.jsp");
		}
		dis.forward(request, response);
	}

	
	
}
