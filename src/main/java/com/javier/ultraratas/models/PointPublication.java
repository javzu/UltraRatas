package com.javier.ultraratas.models;

import com.javier.ultraratas.enums.PublicationState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="publication")
public class PointPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private PublicationState publicationState;

    private LocalDate publishedDate;
    @ManyToOne
    @JoinColumn(name = "point_type")
    private PointType pointType;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public PointPublication() {
    }

    public PointPublication(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PointType getPointType() {
        return pointType;
    }

    public void setPointType(PointType pointType) {
        this.pointType = pointType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PublicationState getPublicationState() {
        return publicationState;
    }

    public void setPublicationState(PublicationState publicationState) {
        this.publicationState = publicationState;
    }



    @PreUpdate
    public void updatePublicationDate() {
        this.publishedDate = LocalDate.from(LocalDateTime.now());
    }
}

