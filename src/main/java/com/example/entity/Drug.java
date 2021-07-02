package com.example.entity;

/**
 药品实体，对应着drug表
 */


public class Drug {
    private Integer id;
    private String name;
    private Integer lotNum;
    private String indication;
    private Double price;

    public Drug(Integer id, String name, Integer lotNum, String indication, Double price) {
        this.id = id;
        this.name = name;
        this.lotNum = lotNum;
        this.indication = indication;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLotNum() {
        return lotNum;
    }

    public void setLotNum(Integer lotNum) {
        this.lotNum = lotNum;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
