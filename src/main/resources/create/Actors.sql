begin createTableIfNotExists('actors(
    actor_id NUMBER PRIMARY KEY,
    worker_id NUMBER NOT NULL REFERENCES workers(worker_id),
    reward_id NUMBER REFERENCES rewards(reward_id),
    is_student NUMBER(1),
    CONSTRAINT actors_unique UNIQUE (worker_id, reward_id, is_student)
)'); end;