package com.example.dev.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {
    long id;
    String number,note;
    LocalDate dataOpen, dataClose;

    public Agreement(String number, String note, LocalDate dataOpen, LocalDate dataClose) {
        this.number = number;
        this.note = note;
        this.dataOpen = dataOpen;
        this.dataClose = dataClose;
    }
}


