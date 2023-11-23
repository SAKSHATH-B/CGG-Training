import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ObjIpOP implements Serializable{
    int roll;
    String sname;
    ObjIpOP(int r, String s){
        roll = r;
        sname = s;
    }
    public String toString(){
        return "Roll no is : "+roll+" Name is : "+sname;
    }

    public static void main(String[] args) {
        try {
            ObjIpOP obj = new ObjIpOP(5, "MaheshBabu");
            System.out.println("obj : "+obj);
            
            FileOutputStream fos = new FileOutputStream("student");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        try {
            ObjIpOP obj2;
            FileInputStream fis = new FileInputStream("student");
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj2 = (ObjIpOP)ois.readObject();
            ois.close();
            System.out.println("obj2 : "+obj2);

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}