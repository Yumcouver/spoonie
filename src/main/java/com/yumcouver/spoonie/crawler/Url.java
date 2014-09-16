package com.yumcouver.spoonie.crawler;

import java.net.MalformedURLException;
import java.net.URL;

class Url {

    private URL url;

    Url(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean match(String regex) {
//        TODO fill in later
        return true;
    }
}