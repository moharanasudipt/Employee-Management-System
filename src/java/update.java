import p1.Employee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String mail = request.getParameter("email");
		String phone = request.getParameter("contact");
		int eid=0;
		try {
		 eid = Integer.parseInt(request.getParameter("id"));
		 session.setAttribute("name", name);
		 	request.setAttribute("cmail", mail);
			ServletContext context = getServletContext();
			Dao dao = (Dao) context.getAttribute("db");
			dao.updateEmp(eid, name, addr, mail, phone);
				System.out.println("Update Successfully");
			    String img= dao.getImg(mail);
				session.setAttribute("iname", img);
				List<Employee> ls = dao.getallEmp();
				request.setAttribute("allEmp", ls);
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
