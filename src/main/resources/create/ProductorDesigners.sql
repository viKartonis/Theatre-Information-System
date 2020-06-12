begin createTableIfNotExists('productor_designers(
    productor_designers_id NUMBER PRIMARY KEY,
    worker_id NUMBER NOT NULL REFERENCES workers(worker_id),
    CONSTRAINT productor_designer_unique UNIQUE (worker_id)
)'); end;