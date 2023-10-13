import p1.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("cmail", email);
        System.out.println("email set");
		ServletContext context = getServletContext();
		Dao dao = (Dao) context.getAttribute("db");
		String res = dao.check(email, password);
		String fn=dao.getImg(email);
		session.setAttribute("name", res);
		session.setAttribute("iname", fn);
		System.out.println(res);
		System.out.println(fn);

		if (res != null) {
			System.out.println("Login Successfully");
			List<Employee> ls = dao.getallEmp();
			request.setAttribute("allEmp", ls);
			System.out.println(ls);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	
}