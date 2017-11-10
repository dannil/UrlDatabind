package com.github.dannil.urldatabind.model.bind.result;

public class JsonResult implements Action {

    private String json;
    
    public JsonResult(String json) {
        this.json = json;
    }
    
    @Override
    public Object trigger() {
        return this.json;
    }

}
