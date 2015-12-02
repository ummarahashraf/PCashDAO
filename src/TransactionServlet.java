

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet {

	public TransactionServlet() {
        super();
    }
	RequestDispatcher dis;
	TransactionDAO tDAO = new TransactionDAO();
	TransModel tm = new TransModel();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String forward = "";
		String action = request.getParameter("action");
		String user = session.getAttribute("user").toString();
		System.out.println("Action: "+action);
		
		if(action.equalsIgnoreCase("showAll")){
			request.setAttribute("showAll", tDAO.getTransByUser(user));
			forward = "home.jsp";
		}
		
		if(action.equalsIgnoreCase("add"))
		{
			String descr,type,date;
			double amount;
			descr = request.getParameter("descr");
			type = request.getParameter("type");
			date = request.getParameter("date");
			amount = Double.parseDouble(request.getParameter("amount"));
			tm.setDescr(descr);
			tm.setAmount(amount);
			tm.setType(type);
			tm.setUser(user);
			tDAO.addToHistory(tm);
			request.setAttribute("showAll", tDAO.getTransByUser(user));
			forward = "home.jsp";
		}
		
		dis = request.getRequestDispatcher(forward);
		dis.forward(request, response);
	}

}
