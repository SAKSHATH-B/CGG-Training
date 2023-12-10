import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StdDAO {
    public static boolean insertStudentToDB(Student st){
        boolean bool=false;

        try {
            Connection con = ConnMngr.createC();
            String query = "insert into students(sname,sphone,scity) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, st.getsName());
            ps.setString(2, st.getsPhone());
            ps.setString(3, st.getsCity());

            ps.executeUpdate();
            bool=true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bool;
    }

    public static boolean updateStudent(Student uS){
        boolean bool = false;
        try {
            Connection con = ConnMngr.createC();
            String query = "update students set sname=?, sphone=?, scity=? where studentId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uS.getsName());
            ps.setString(2, uS.getsPhone());
            ps.setString(3, uS.getsCity());
            ps.setInt(4, uS.getStudentId());

            int rowsUpdated = ps.executeUpdate();
            if(rowsUpdated>0){
                bool = true;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bool;
    }
    public static Student getStudentById(int studentId){
        Student student = null;
        try {
            Connection con = ConnMngr.createC();
            String query = "SELECT * FROM students WHERE studentId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("studentId");
                String name = rs.getString("sname");
                String phone = rs.getString("sphone");
                String city = rs.getString("scity");
                student = new Student(id,name,phone,city);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public static boolean deleteStudent(int userId){
        boolean bool = false;
        try {
            Connection con = ConnMngr.createC();
            String query = "delete from students where studentId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
            bool = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bool;
    }

    public static boolean showAllStudents(){
        boolean bool=false;
        try {
            Connection con = ConnMngr.createC();
            String query = "select * from students";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Id: "+rs.getInt(1));
                System.out.println("Name: "+rs.getString(2));
                System.out.println("PhoneNo: "+rs.getString(3));
                System.out.println("City: "+rs.getString(4));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bool;
    }
}
