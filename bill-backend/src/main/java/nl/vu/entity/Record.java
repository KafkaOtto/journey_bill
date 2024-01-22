package nl.vu.entity;

import lombok.Data;

@Data
public class Record {
    private Integer recordId;
    private Integer userId;
    private String activity;
    private float totalAmount;
    private String time;
}
