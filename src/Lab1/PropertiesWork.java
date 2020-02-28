package Lab1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Андрей on 19.02.2020.
 */
public class PropertiesWork {

    private Properties propertyVar = new Properties();

    private static PropertiesWork propertiesWork;



    public PropertiesWork() {}


    public Properties getPropertyVal() throws IOException {

        if(propertyVar.size() != 0){
            return propertyVar;
        }
        else {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            Properties property = new Properties();
//          FileOutputStream fileOutputStream = new FileOutputStream("config.properties2");
//          property.store(fileOutputStream, "ffdfd");


            property.load(fileInputStream);


            String login = property.getProperty("login");
            String password = property.getProperty("password");
            String config = property.getProperty("config");
            String car1 = property.getProperty("car1");
            String car2 = property.getProperty("car2");
            String car3 = property.getProperty("car3");

            propertyVar.setProperty("login", login);
            propertyVar.setProperty("password", password);
            propertyVar.setProperty("config", config);
            propertyVar.setProperty("car1", car1);
            propertyVar.setProperty("car2", car2);
            propertyVar.setProperty("car3", car3);

            setPropertyVar(propertyVar);


            fileInputStream.close();


            return propertyVar;
        }
    }

        String getStringProperties(Properties prop) {

            String allProps = "";

            String login = prop.getProperty("login");
            String password = prop.getProperty("password");
            String config = prop.getProperty("config");
            String car1 = prop.getProperty("car1");
            String car2 = prop.getProperty("car2");
            String car3 = prop.getProperty("car3");

            if (!login.equals("") && !password.equals("") && !config.equals("") && !car1.equals("") && !car2.equals("") && !car3.equals(""))
                allProps += login + "  " + password + "\n" + config + "\n" + car1 + "  " + car2 + "  " + car3;

            return allProps;

        }

        private synchronized void setPropertyVar(Properties prop) {
            propertyVar = prop;
        }

        public static PropertiesWork getPropertiesWork() {
            if(propertiesWork == null) propertiesWork = new PropertiesWork();
            return propertiesWork;
        }




}
