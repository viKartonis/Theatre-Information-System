begin createTableIfNotExists('musician(
    musician_id NUMBER PRIMARY KEY,
    worker_id NUMBER NOT NULL REFERENCES workers(worker_id)
)'); end;