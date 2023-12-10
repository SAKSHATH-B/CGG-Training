import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentManage {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Student Management Application");

        while (true) {
            System.out.println("Press 1 to Add Student");
            System.out.println("Press 2 to Update Student");
            System.out.println("Press 3 to Delete Student");
            System.out.println("Press 4 to Display All Student");
            System.out.println("Press 5 to Exit");

            System.out.println("Enter your choice: ");

            try {
                int ch = Integer.parseInt(br.readLine());

                if(ch==1){
                    //add Student
                    System.out.println("Enter Student Name: ");
                    String name = br.readLine();
                    System.out.println("Enter Student PhoneNumber: ");
                    String pno = br.readLine();
                    System.out.println("Enter Student City");
                    String city = br.readLine();

                    Student stud = new Student(name, pno, city);
                    System.out.println(stud);
                    boolean ans = StdDAO.insertStudentToDB(stud);

                    if(ans==true){
                        System.out.println("Student Added Successfully...!");
                    }else{
                        System.out.println("Something went wrong!!!");
                    }
                }else if(ch==2){
                    //update student
                    System.out.println("Enter StudentId to Update: ");
                    int sId = Integer.parseInt(br.readLine());
                    Student es = StdDAO.getStudentById(sId);
                    if(es!=null){
                        System.out.println("Enter updated Student Name: ");
                        String uName = br.readLine();
                        System.out.println("Enter updated PhoneNumber: ");
                        String uPhone = br.readLine();
                        System.out.println("Enter updated Student City: ");
                        String uCity = br.readLine();

                        es.setsName(uName);
                        es.setsPhone(uPhone);
                        es.setsCity(uCity);

                        boolean ans = StdDAO.updateStudent(es);

                        if(ans==true){
                            System.out.println("Student Updated Successfully...!");
                        }else{
                            System.out.println("Something Went Wrong!!!");
                        }
                    }else{
                        System.out.println("Student with Id "+ sId+" not found.");
                    }
                }else if(ch==3){
                    //delete student
                    System.out.println("Enter studentId to delete: ");
                    int userId = Integer.parseInt(br.readLine());
                    boolean ans = StdDAO.deleteStudent(userId);
                    if(ans==true){
                        System.out.println("Student Deleted");
                    }else{
                        System.out.println("Something went Wrong!!!");
                    }
                }else if(ch==4){
                    //show all students
                    StdDAO.showAllStudents();
                }else if(ch==5){
                    //exit
                    break;
                }
            } catch (NumberFormatException | IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        System.out.println("ThankYou!");
    }   
}
