package com.yumcouver.spoonie.conf;

import java.util.Map;

public class WorkerConf implements WorkerInfo {
    private final int threadCount;

    public WorkerConf(Map<String, Object> conf) {
        threadCount = (Integer) (conf.get("thread"));
    }

    @Override
    public int getWorkerThreadCount() {
        return threadCount;
    }
}
