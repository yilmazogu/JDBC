import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunnaTest02 {
@Test
    public void medunnaTest02() throws SQLException {

        JdbcUtils.connectToDataBase("Medunna.com", "medunna_db", "medunna_user","medunna_pass_987");
        Statement statement =JdbcUtils.createStatement();

        String sql1= "Select first_name from patient";
        ResultSet rst1= statement.executeQuery(sql1);
        List<String> first_name=new ArrayList<>();
        while(rst1.next()){
        first_name.add(rst1.getString(1));


    }
    System.out.println("first_name=" + first_name);

    Assert.assertTrue(first_name.contains("Phung"));


    }
}
