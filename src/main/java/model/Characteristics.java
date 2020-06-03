package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Characteristics {
    private int characteristic_id;
    private byte gender;
    private Date db;
    private String voice;
    private float height;
    private Date beginning_of_work;
    private int child;
    private double salary;
}
