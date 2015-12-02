

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {
	RequestDispatcher dis;
	private static final long serialVersionUID = 1L;
       
    
    public RegServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String user,fname,pass,email;
		user=request.getParameter("user");
		fname=request.getParameter("fname");
		pass=request.getParameter("pass");
		email=request.getParameter("email");
		UserModel um =new UserModel();
		um.setEmail(email);
		um.setFname(fname);
		um.setPass(pass);
		um.setUser(user);
		UserDAO uDao =new UserDAO();
		if(uDao.AddUser(um))
		{
			System.out.println("registerd success");
			dis=request.getRequestDispatcher("index.html#login");
        //We have taken this above
			dis.forward(request, response);
		}
		else
			//if it don`t contain this
			dis=request.getRequestDispatcher("index.html#register");
		dis.forward(request, response);
		
	}

}
