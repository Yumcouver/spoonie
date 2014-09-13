package com.yumcouver.spoonie.conf;

import java.util.Map;

/**
 * configuration of database
 */
public class DatabaseConf implements DBInfo {
    private final String driver, url, typename, database, username, password;

    public DatabaseConf(Map<String, Object> conf) {
        driver = (String) (conf.get("driver"));
        url = (String) (conf.get("url"));
        typename = (String) (conf.get("typename"));
        database = (String) (conf.get("database"));
        username = (String) (conf.get("username"));
        password = (String) (conf.get("password"));
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getTypeName() {
        return typename;
    }

    public String getDatabase() {
        return database;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<configuration>\n" +
                "  <jdbc>\n" +
                "    <driver>" + getDriver() + "</driver>\n" +
                "    <url>" + getUrl() + "</url>\n" +
                "    <user>" + getUserName() + "</user>\n" +
                "    <password>" + getPassword() + "</password>\n" +
                "  </jdbc>\n" +
                "  <generator>\n" +
                "    <database>\n" +
                "      <name>" + getTypeName() + "</name>\n" +
                "      <includes>.*</includes>\n" +
                "      <excludes></excludes>\n" +
                "      <inputSchema>" + getDatabase() + "</inputSchema>\n" +
                "    </database>\n" +
                "    <generate></generate>\n" +
                "\n" +
                "    <target>\n" +
                "      <packageName>com.yumcouver.spoonie.database</packageName>\n" +
                "      <directory>src/main/java</directory>\n" +
                "    </target>\n" +
                "  </generator>\n" +
                "</configuration>";
        return xml;
    }
}
