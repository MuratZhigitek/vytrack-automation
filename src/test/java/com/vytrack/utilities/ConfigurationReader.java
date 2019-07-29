package com.vytrack.utilities;

import java.io.FileInputStream;
import java.util.Properties;


    import java.io.FileInputStream;
    import java.util.Properties;

    public class ConfigurationReader {

        private static Properties configFile;

        static{

            try {

                //path to our .properties file
                String path = "configuration.properties";
                // we create object of input stream to access file
                // provides access to the file
                FileInputStream input = new FileInputStream(path);
                //initialize configFile
                configFile = new Properties();
                //load properties file
                configFile.load(input);
                //to close  input
                input.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public static String getProperty(String key){

            return configFile.getProperty(key);
        }

    }


