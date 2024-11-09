import java.sql.*;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Object {
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


    }


