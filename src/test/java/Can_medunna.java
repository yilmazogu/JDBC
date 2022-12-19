import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Can_medunna {

    @Test
    public void name() throws SQLException {

      JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement st= JdbcUtils.createStatement();
        String sql="select email from cmessage";
        ResultSet rst=st.executeQuery(sql);

        List<String> mail=new ArrayList<>();

        while(rst.next()){

            mail.add(rst.getString(1));
        }
        System.out.println(mail);

        Assert.assertTrue(mail.contains("zeynep05@gmail.com"));
        System.out.println("evet icerir");

        JdbcUtils.closeConnectionAndStatement();


    }
}
