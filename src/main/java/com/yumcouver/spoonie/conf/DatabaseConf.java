package com.yumcouver.spoonie.conf;

import java.util.Map;

/**
 * configuration of database
 */
public class DatabaseConf implements DatabaseInfo {
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
}
