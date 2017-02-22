import java.sql.*;

public class sortingasc {
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

   
   static final String USER = "username";
   static final String PASS = "password";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("com.mysql.jdbc.Driver");

     
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      
      System.out.println("Fetching records in ascending order...");
      String sql = "SELECT id, name, cost FROM Registration" +
                   " ORDER BY cost ASC";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         
         int id  = rs.getInt("id");
         int cost = rs.getInt("cost");
         String name = rs.getString("name");
        

         
         System.out.print("ID: " + id);
         System.out.print("cost: " + cost);
         System.out.print("name: " + name);
         
      }

    
      
      rs.close();
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
     
      e.printStackTrace();
   }finally{
    
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}