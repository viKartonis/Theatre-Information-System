package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Performance {
    private int performance_id;
    private String name;
    private int producer_id;
    private List<Integer> actors;
    private int genre_id;
    private Date date;
    private boolean isPremier;
    private int autor_id;
    private int wasSaled;
    private Double coast;
    private int petformance_category_id;
    private int director_id;
    private int conductor_id;
    private int role_id;
}
