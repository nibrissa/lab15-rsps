package com.example.dev.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {
     long id;
     String fullname,shortname,city,bik,coraccount;
     Long inn,account;

    public Bank(String fullname, String shortname, String city, Long inn, String bik, String coraccount, Long account) {
        this.fullname = fullname;
        this.shortname = shortname;
        this.city = city;
        this.inn = inn;
        this.bik = bik;
        this.coraccount = coraccount;
        this.account = account;
    }
}

