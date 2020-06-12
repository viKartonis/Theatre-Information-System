begin createTableIfNotExists('conductors(
    conductor_id NUMBER PRIMARY KEY,
    worker_id NUMBER NOT NULL REFERENCES workers(worker_id),
    CONSTRAINT conductors_unique UNIQUE (worker_id)
)'); end;