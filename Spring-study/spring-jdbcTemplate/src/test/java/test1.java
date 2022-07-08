import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class test1 {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Test
    public void testa(){
        String sql= "update emp set username=? where id=?";
        Object[] params = {"张三",1};
        int update = jdbcTemplate.update(sql, params);
        int count = jdbcTemplate.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){
        String to= "smilemaisui41@126.com";
        String text="长风破浪会有时，直挂云帆济沧海";
        String title="测试";
        MailUtil.sendMail(to,title,text);
    }

}
