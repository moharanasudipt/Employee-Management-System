import p1.Employee;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class registration extends HttpServlet {

    public static final String UPLOAD_DIR="images";
    public String dbFileName="";

    public void init() {
       ServletContext context=getServletContext();
        Dao dao = (Dao) new DaoImpl();
        context.setAttribute("db", dao);
        System.out.println("dao object set....");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        Dao dao = (Dao) context.getAttribute("db");

        String ename = request.getParameter("name");
        String eaddr = request.getParameter("addr");
        String email = request.getParameter("email");
        String phone = request.getParameter("contact");

        Part file=request.getPart("photo");
        String fileName= file.getSubmittedFileName();
         
        System.out.println(fileName);
        String Path=getServletContext().getRealPath("")+UPLOAD_DIR;
        System.out.println("applicationPath: " +Path);
        File file1=new File(Path);
        file.write(Path+File.separator+fileName);
        dbFileName=UPLOAD_DIR+File.separator+fileName;
        System.out.println("DBFileName: " +dbFileName);

        String password = dao.generatePassword(ename, email);
        boolean flag = dao.storeEmp(ename, eaddr, email, password, phone,dbFileName);
        if (flag) {
            System.out.println("You are registered Successfully.");
            System.out.println("Your Username:"+email);
			System.out.println("Your Password:"+password);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}