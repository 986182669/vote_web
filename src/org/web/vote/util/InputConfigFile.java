package org.web.vote.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InputConfigFile {
    public static Properties getConfigFile(String configPath) throws IOException {
        Properties properties = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(configPath));
        //getClass().getResourceAsStream()
        properties.load(in);
        return properties;

    }
}
