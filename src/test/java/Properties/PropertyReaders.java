package Properties;

import java.io.*;
import java.util.Properties;

public class PropertyReaders
{
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/config.properties");
        FileInputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("username"));
        String timeout = properties.getProperty("timeout");
        int val = Integer.parseInt(timeout);
        System.out.println(val);
        System.out.println(properties.getProperty("password"));

        String tools = properties.getProperty("tools");
        String[] split = tools.split(",");
        for (int i = 0; i < split.length; i++)
        {
            System.out.println(split[i]);
        }
    }
}

