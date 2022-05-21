package com.study.crudrestapi.wrapper;

import com.study.crudrestapi.common.wrapper.ReferenceBaseWrapper;

public class AuthorWrapper extends ReferenceBaseWrapper {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
