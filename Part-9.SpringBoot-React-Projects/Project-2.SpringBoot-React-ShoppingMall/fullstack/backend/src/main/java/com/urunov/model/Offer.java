package com.urunov.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class Offer {

    private byte[] image;

    @Transient
    private String imageUrl;

    @Lob
    @Column
    private String description;

    private Date startDate;

    private Date finishDate;

    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "offer_goods",
//            joinColumns = @JoinColumn(name = "offer_id"),
//            inverseJoinColumns = @JoinColumn(name = "good_id"))
//    private List<Good> goodList;

}
