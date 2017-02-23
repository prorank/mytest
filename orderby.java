import java.sql.*;

public class orderby {
   public static void main(String[] args) throws Exception {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con = DriverManager.getConnection (
         "jdbc:derby://localhost:1527/testDb","name","pass");
      
      Statement stmt = con.createStatement();
      String query = "select * from emp order by name";
      String query1="select * from emp order by name, id";
      
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("Table contents ordered by Name");
      System.out.println("Id Name cost");
      
      while (rs.next()) {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int cost = rs.getInt("cost");
         System.out.println(id + "  " + name+"   "+cost);
      }
      rs = stmt.executeQuery(query1);
      System.out.println("Table contents after sorted by Name & id");
      System.out.println("Id Name    cost");
      
      while (rs.next()) {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int cost = rs.getInt("cost");
         System.out.println(id + "  " + name+"   "+cost);
      }
   }
}