import p1.Employee;
import java.util.*;

public interface Dao {
    public boolean storeEmp(String ename,String eaddr,String email,String password,String phone_no,String filename);
	   public List<Employee> getallEmp();
	   public String generatePassword(String ename, String email);
	   public String check(String email,String password);
	   public String getImg(String email);
	   public void updateEmp(int eid,String ename,String eaddr,String email,String phone_no);
	   public void deleteEmp(int eid);
}
