
import java.sql.*;
import java.util.Scanner;
//import java.lang.*;


public  class Main {
    //Object obj = new Object();

    public static void main(String[] args) throws Exception{
        Object obj = new Object();
        String url = "jdbc:mysql://localhost:3306/atm2_schema";
        String user = "root";
        String password = "Prabhu@123";
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Welcome to Atm_Machine");

        while (true) {
            System.out.println("1)Deposit Amount\n 2)Withdraw Amount\n 3)Check Balance\n 4)View_Statement\n 5)Exit");
            Scanner sc = new Scanner(System.in);
                obj.set_balance(con);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:obj.Deposit(con);break;
                    case 2:obj.Withdraw(con);break;
                    case 3:obj.view_balance();break;
                    case 4:obj.View_Statement(con);break;
                    case 5:System.exit(0);
                    default:System.out.println("Invalid choice");
                    sc.close();
                    
                }
            
        }

    }
}

 /*public  class Object {
    Scanner sc = new Scanner(System.in);
    Values val=new Values();
    public void set_balance( Connection con) throws SQLException {
        String query="select * from atm_statement";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        int balance=0;
        while(rs.next()) {
            balance=rs.getInt(4);

        }
        val.setBalance(balance);

    }

    public void view_balance(){
        System.out.println("Avalable Balance:"+ val.getBalance());
    }


    public void Deposit( Connection con) throws SQLException {
     System.out.println("Deposit Amount");
     int dep = sc.nextInt();
     System.out.println(" Amount Deposited");
     val.setBalance(val.getBalance()+dep);

        String query = "insert into atm_statement(Deposit,Withdraw,Balance) values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, dep);
        st.setInt(2, 0);
        st.setInt(3, val.getBalance());
         st.executeUpdate();

    }


    public void Withdraw( Connection con) throws SQLException {
        System.out.println("Withdraw Amount");
        int dep = sc.nextInt();
        System.out.println(" Amount Withdrawn");
        val.setBalance(val.getBalance() - dep);

        String query = "insert into atm_statement(Deposit,Withdraw,Balance) values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, 0);
        st.setInt(2, dep);
        st.setInt(3, val.getBalance());
        st.executeUpdate();
    }

    public void View_Statement(Connection con) throws SQLException {
      String query="select * from atm_statement";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            System.out.println("Transaction ID:" + rs.getInt(1)
            +"\n"+ "Deposited Amount:" + rs.getInt(2)+"\n"+
                    "Withdrawn Amount:" + rs.getInt(3)+"\n"+
                    "Balance"+ rs.getInt(4));
            System.out.println("--------------------------------");
        }

    }


}*/

