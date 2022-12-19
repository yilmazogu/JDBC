import java.sql.*;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","converse");

        Statement st=con.createStatement();

         /*
        execute() methodu DDL(create, drop, alter table) ve DQL(select) için kullanılabilir.
        1) Eğer execute() methodu DDL için kullanılırsa 'false' return yapar.
        2) Eğer execute() methodu DQL için kullanılırsa ResultSet alındığında 'true' aksi hale 'false' verir.
         */

        //1.Örnek: "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.

        boolean sql1 = st.execute("CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)");
        System.out.println("sql1 = " + sql1);//false return eder çünkü data çağırmıyoruz.

        //2.Örnek: Table'a worker_address sütunu ekleyerek alter yapın.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        boolean sql2b = st.execute(sql2);
        System.out.println("sql2b = " + sql2b);

        //3.Örnek: workers table'ını silin.

        String sql3 = "DROP TABLE workers";
        boolean sql3b = st.execute(sql3);
        System.out.println("sql3b = " + sql3b);



        //5. Adım: Bağlantı ve Statement'ı kapat.

        con.close();
        st.close();


    }

}
