package com.yumcouver.spoonie.conf;

/**
 * all information that generator need to generate sql code
 */
public interface DatabaseInfo {

    public String getDriver();

    public String getUrl();

    public String getTypeName();

    public String getDatabase();

    public String getUserName();

    public String getPassword();
}
