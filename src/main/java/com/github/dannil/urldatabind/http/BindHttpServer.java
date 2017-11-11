package com.github.dannil.urldatabind.http;

import static spark.Spark.*;

import java.util.Set;

import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class BindHttpServer {

    private Set<AbstractBind> binds;
    
    public BindHttpServer(Set<AbstractBind> binds) {
        this.binds = binds;
    }
    
    public void start(int port) {
        port(port);
        for (final AbstractBind bind : binds) {
            switch (bind.getRequestMethod()) {
                case GET:
                    get(bind.getPath(), (req, res) -> bind.getContent());
                case POST:
                    post(bind.getPath(), (req, res) -> bind.getContent());
            }
        }
    }
    
    public void stop() {
        stop();
    }
    
}
