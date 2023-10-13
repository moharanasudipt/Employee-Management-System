import p1.Employee;
import java.security.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class DaoImpl implements Dao {
    Connection con = null;

	//create connection
    private Connection getConnection(){
        try {
	    
            BasicDataSource bd = new BasicDataSource();
            bd.setUsername("root");
            bd.setPassword("SKgudu@2003");
            bd.setUrl("jdbc:mysql://localhost:3306/db");
            bd.setDriverClassName("com.mysql.jdbc.Driver");
            DataSource ds = (DataSource) bd;
            con = ds.getConnection();

            System.out.println("Connection Created ");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
	//close connection
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //for insertion
    public boolean storeEmp(String ename, String eaddr, String email, String password, String phone_no,String filename) {
        boolean flag = false;
        try {
            con = getConnection();
            String qs = "insert into employee(ename,eaddr,email,password,phone_no,filename) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(qs);
            ps.setString(1, ename);
            ps.setString(2, eaddr);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, phone_no);
            ps.setString(6, filename);
            int result = ps.executeUpdate();
            if (result == 1) {
                flag = true;
                System.out.println("Record inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }
        return flag;
    }

	// for selection
    public List<Employee> getallEmp(){
        Connection con=null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            con=getConnection();
            System.out.println(con);
            if (con!=null) {
                System.out.println("emp success");           
		String s="select eid,ename,eaddr,email,phone_no from employee";
                PreparedStatement pst=con.prepareStatement(s);
                ResultSet rs=pst.executeQuery();
                while (rs.next()){
                    Employee e= new Employee();
                    e.setEid(rs.getInt(1));
                    e.setEname(rs.getString(2));
                    e.setEaddr(rs.getString(3));
                    e.setEmail(rs.getString(4));
                    e.setPhone_no(rs.getString(5));
                    list.add(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection(con);
        }
        return list;
    }
    
	
    public String generatePassword(String ename, String email) {
        String inputForPassword = ename + email;
        int passwordLength = 8; 
        StringBuilder password = new StringBuilder();

        String specialSymbols = "@#$%&*";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputForPassword.getBytes());
            SecureRandom random = new SecureRandom(hash);

            for (int i = 0; i < passwordLength; i++) {
                int value = random.nextInt(36 + specialSymbols.length());

                char charToAdd;
                if (value < 10) {
                    charToAdd = (char) ('0' + value); 
                } else if (value < 36) {
                    charToAdd = (char) ('a' + (value - 10)); 
                } else {
                    charToAdd = specialSymbols.charAt(value - 36); 
                }

                password.append(charToAdd);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password.toString();
    }

   //for login 
    public String check(String email, String password) {
        Connection con = null;
        ResultSet rs = null;
        String ename = null;
        try {
            con = getConnection();
            String qs = "select  ename from employee where email=? and password=? ";
            PreparedStatement ps = con.prepareStatement(qs);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                ename = rs.getString(1);
            }
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            closeConnection(con);
        }
        return ename;
    }

    //for image
    public String getImg(String email){
        Connection con=null;
        String filename=null;
        try {
            con=getConnection();
            String qs="select filename from employee where email=?";
            PreparedStatement ps=con.prepareStatement(qs);
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                filename=rs.getString(1);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return filename;
    }
	// for update
    public void updateEmp(int eid, String ename, String eaddr, String email, String phone_no) {
        Connection con = null;
        
        try {
            con = getConnection();
            String qs = "update employee set ename=?,eaddr=?,email=?,phone_no=? where eid=?";
            PreparedStatement ps = con.prepareStatement(qs);
            ps.setString(1, ename);
            ps.setString(2, eaddr);
            ps.setString(3, email);
            ps.setString(4, phone_no);
            ps.setInt(5, eid);
            int res = ps.executeUpdate();
            if (res == 1) {
                System.out.println("Record updated successfully:");
            }
        } catch (Exception e) {
        } finally {
            closeConnection(con);
        }
    }

    //for delete
    public void deleteEmp(int eid) {
        Connection con = null;
        
        try {
            con = getConnection();

            String qs = "delete from employee where eid = ?";
            PreparedStatement ps = con.prepareStatement(qs);
            ps.setInt(1, eid);
            int res = ps.executeUpdate();
            if (res == 1) { 
                System.out.println("Record deleted successfully:");
            }
        } catch (Exception e) {
        } finally {
            closeConnection(con);
        }
    }
}