package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private int actor_id;
    private int worker_id;
    private int rewards_id;
    private boolean is_student;
}
