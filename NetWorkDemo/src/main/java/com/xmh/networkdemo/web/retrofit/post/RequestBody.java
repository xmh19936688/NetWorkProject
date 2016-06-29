package com.xmh.networkdemo.web.retrofit.post;

import java.io.Serializable;

/**
 * Created by mengh on 2016/6/28 028.
 */
public class RequestBody implements Serializable{

    private String client_id;
    private String client_secret;

    public RequestBody(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }
}
