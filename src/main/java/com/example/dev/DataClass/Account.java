package com.example.dev.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    long id,bank_id,aggrement_id,type_id;
    String account;
    Bank bank;
    Agreement agreement;
    Type type;

    public Account(long id, long bank_id, long aggrement_id, long type_id, String account) {
        this.id = id;
        this.bank_id = bank_id;
        this.aggrement_id = aggrement_id;
        this.type_id = type_id;
        this.account = account;
    }

    public Account(long bank_id, long aggrement_id, long type_id, String account) {
        this.bank_id = bank_id;
        this.aggrement_id = aggrement_id;
        this.type_id = type_id;
        this.account = account;
    }
}

