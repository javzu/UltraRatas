package com.javier.ultraratas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "point_type")
public class PointType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPointType;

    private String pointName;

    @ManyToOne
    @JoinColumn(name="id_bank")
    private Bank bank;

    public PointType() {
    }

    public PointType(String pointName, Bank bank) {
        this.pointName = pointName;
        this.bank = bank;
    }

    public PointType(int idPointType, String pointName, Bank bank) {
        this.idPointType = idPointType;
        this.pointName = pointName;
        this.bank = bank;
    }

    public PointType(int idPointType) {
        this.idPointType = idPointType;
    }

    public int getIdPointType() {
        return idPointType;
    }

    public void setIdPointType(int idPointType) {
        this.idPointType = idPointType;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getIdPointType(Object idPointType) {
        return (int) idPointType;
    }
}
