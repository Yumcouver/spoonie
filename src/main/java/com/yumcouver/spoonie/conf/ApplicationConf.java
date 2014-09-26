package com.yumcouver.spoonie.conf;

import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

/**
 * configuration of application
 */
public class ApplicationConf implements DatabaseInfo, WorkerInfo {
    private DatabaseConf dbConf;
    private WorkerConf workerConf;

    public ApplicationConf(String env) {
        InputStream in = ApplicationConf.class.getResourceAsStream("/META-INF/application.yaml");
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(in, writer, "UTF-8");
            Yaml yaml = new Yaml();
            Map<String, Object> conf = (Map<String, Object>) (((Map<String, Object>) (yaml.load(writer.toString()))).get(env));
            dbConf = new DatabaseConf((Map<String, Object>) (conf.get("db")));
            workerConf = new WorkerConf((Map<String, Object>) (conf.get("worker")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDriver() {
        return dbConf.getDriver();
    }

    @Override
    public String getUrl() {
        return dbConf.getUrl();
    }

    @Override
    public String getTypeName() {
        return dbConf.getTypeName();
    }

    @Override
    public String getDatabase() {
        return dbConf.getDatabase();
    }

    @Override
    public String getUserName() {
        return dbConf.getUserName();
    }

    @Override
    public String getPassword() {
        return dbConf.getPassword();
    }

    @Override
    public int getWorkerThreadCount() {
        return workerConf.getWorkerThreadCount();
    }
}
