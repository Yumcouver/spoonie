package com.yumcouver.spoonie.crawler;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class Url {

    private URL ipUrl = null;
    private URL domainUrl = null;

    Url(String url) {
        try {
            this.domainUrl = new URL(url);
        } catch (MalformedURLException e) {
        }
        if (this.domainUrl == null) {
            try {
                this.domainUrl = new URL("http://" + url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if (this.domainUrl.getPort() == -1) {
            try {
                this.domainUrl = new URL(this.domainUrl.getProtocol(), this.domainUrl.getHost(), this.domainUrl.getDefaultPort(), this.domainUrl.getFile());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        InetAddress address = null;
        try {
            address = InetAddress.getByName(domainUrl.getHost());
            this.ipUrl = new URL(this.domainUrl.getProtocol(), address.getHostAddress(), this.domainUrl.getPort(), this.domainUrl.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean match(String regex) {
//        TODO fill in later
        return true;
    }

    public String getUrlAsString() {
        return this.ipUrl.toString();
    }

    @Override
    public String toString() {
//        TODO change it later
        return this.ipUrl.toString() + "<--:-->" + this.domainUrl.toString();
    }
}