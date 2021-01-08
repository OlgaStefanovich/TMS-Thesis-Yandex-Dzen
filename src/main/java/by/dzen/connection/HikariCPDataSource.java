package by.dzen.connection;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class HikariCPDataSource {

    private static Properties properties = new Properties();
    private static HikariDataSource dataSource;


   public HikariCPDataSource() {
       try {
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream("database.properties");
           properties.load(inputStream);
           dataSource = new HikariDataSource();
           dataSource.setDriverClassName(properties.getProperty("driver.class.name"));
           dataSource.setJdbcUrl(properties.getProperty("db.url"));
           dataSource.setUsername(properties.getProperty("db.username"));
           dataSource.setPassword(properties.getProperty("db.password"));

           dataSource.setMinimumIdle(100);
           dataSource.setMaximumPoolSize(2000);//The maximum number of connections, idle or busy, that can be present in the pool.
           dataSource.setAutoCommit(false);
           dataSource.setLoginTimeout(3);

       } catch (IOException | SQLException e) {
           e.printStackTrace();
       }

   }
    public static DataSource getDataSource() {
        return dataSource;
    }


}
