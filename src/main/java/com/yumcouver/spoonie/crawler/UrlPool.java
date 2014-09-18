package com.yumcouver.spoonie.crawler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class UrlPool {
    private static final Log log = LogFactory.getLog(UrlPool.class);

    private static UrlPool ourInstance = new UrlPool();

    public static UrlPool getInstance() {
        return ourInstance;
    }

    private LinkedList<Url> queue;

    private UrlPool() {
        this.queue = new LinkedList<Url>();
    }

    public List<Url> fetchUrls(int length) {
        synchronized (this.queue) {
            log.info("Fetching " + String.valueOf(Math.min(this.queue.size(), length)) + " urls ...");
            List<Url> urls = new ArrayList<Url>(this.queue.subList(0, Math.min(this.queue.size(), length)));
            this.queue.removeAll(urls);
            return urls;
        }
    }

    public void addUrls(Collection<Url> urls) {
        synchronized (this.queue) {
            log.info("Adding " + String.valueOf(urls.size()) + " urls ...");
            this.queue.addAll(urls);
        }
    }
}
