package com.byd.message.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String name;
    private String content;
    private Date time;
    private String url;


}
