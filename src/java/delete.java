
import p1.Employee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class delete extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                int eid=0;
        try {
             eid = Integer.parseInt(request.getParameter("del"));
            ServletContext context = getServletContext();
            Dao d = (Dao) context.getAttribute("db");
            d.deleteEmp(eid);
           
            List<Employee> list = d.getallEmp();
            if (list!=null) {                
                request.setAttribute("allEmp", list);
                System.out.println("Delete Successfully");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }
        } catch (Exception r) {
            r.printStackTrace();
        }
    }
}