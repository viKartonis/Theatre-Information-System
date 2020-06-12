begin createTableIfNotExists('workers(
    worker_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    characteristic_id NUMBER NOT NULL
    REFERENCES characteristics(characteristic_id),
    CONSTRAINT worker_unique UNIQUE (name, characteristic_id)
)'); end;