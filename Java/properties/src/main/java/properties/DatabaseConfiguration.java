package properties;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class DatabaseConfiguration {
        private Properties prop= new Properties();

    public DatabaseConfiguration()  {

        try {
            InputStream in =
                    getClass().getClassLoader().getResourceAsStream("test.properties");

            prop.load(new InputStreamReader(in, Charset.forName("UTF-8")));
        }
        catch (IOException E){
        }

        }

    public DatabaseConfiguration(File file) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            prop.load(new InputStreamReader(in, Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }

    }

    public String getHost() {
        return prop.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(prop.getProperty("db.port"));
    }

    public String getSchema() {
        return prop.getProperty("db.schema");
    }
}
