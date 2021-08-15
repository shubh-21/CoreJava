package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student{
    int sid,marks,attendance;
    String name,remark;
    public Student(int sid,String name,int marks,int attendance,String remark)
    {
        this.sid=sid;
        this.name=name;
        this.marks=marks;
        this.attendance=attendance;
        this.remark=remark;
    }

    public int getSid() {
        return sid;
    }

    public int getMarks() {
        return marks;
    }

    public int getAttendance() {
        return attendance;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
  
     @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", marks=" + marks + ", attendance=" + attendance + ", name=" + name + ", remark=" + remark + '}';
    }

}
class StudentDAO{
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement p=null;
        Scanner sc=new Scanner(System.in);
        int i=0;
        void initOperation(){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
                System.out.println("Connected");
            } catch (ClassNotFoundException | SQLException e) {
            	e.printStackTrace();
            }
            
        }
        void insertStudent(Student st){
             
            try {
                String query="insert into student values(?,?,?,?,?)";
                p= conn.prepareStatement(query);
                p.setInt(1, st.getSid());
                p.setString(2, st.getName());
                p.setInt(3, st.getMarks());
                p.setInt(4, st.getAttendance());
                p.setString(5, st.getRemark());
                
                int j=0;
                 j = p.executeUpdate();
                System.out.println("Rows Updated = "+j );
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*void searchStudent(int id)
        {
            
            try {
                String query="SELECT * FROM student WHERE sid=?";              
                p=conn.prepareStatement(query);
                p.setInt(1,id);
                rs=p.executeQuery();
                while(rs.next())
                {
                     System.out.println("ID= "+rs.getInt(1)+" Name= "+rs.getString(2)+" Marks="+rs.getInt(3));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }*/
}
public class assDB{
    public static void main(String[] args) {
        int sid,marks,attendance;
    String name,remark;
    
    StudentDAO sd=new StudentDAO();
    
    Scanner sc=new Scanner(System.in);
    /*System.out.println("Enter No.of records:-");
    int n=sc.nextInt();
    for(int i=0;i<n;i++)
    {*/
       System.out.println("Enter Id:-");
       sid=sc.nextInt();
       System.out.println("Enter Name:-");
       name=sc.next();
       System.out.println("Enter Marks:-");
       marks=sc.nextInt();
       System.out.println("Enter Attendance:-");
       attendance=sc.nextInt();
       System.out.println("Enter remark:-");
       remark=sc.next();
    
     /*  ArrayList<Student> a2=new ArrayList<>();
       a2.add(new Student(sid,name,marks,attendance,remark));

	//System.out.println(a2);
    }*/
    Student st=new Student(sid,name,marks,attendance,remark);
    sd.initOperation();
    //sd.insertStudent(st);
     System.out.println("Enter Id to search:-");
      sid=sc.nextInt();
   // sd.searchStudent(sid);
}
}