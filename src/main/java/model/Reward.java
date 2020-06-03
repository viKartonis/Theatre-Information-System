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
public class Reward {
    private int reward_id;
    private String name;
    private Date date_of_delivery;

    public Reward(String name, Date date_of_delivery){
        this.name = name;
        this.date_of_delivery = date_of_delivery;
    }

}
