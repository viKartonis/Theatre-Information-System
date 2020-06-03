begin createTableIfNotExists('characteristics(
    characteristic_id NUMBER PRIMARY KEY,
    gender NUMBER(1),
    date_bd DATE,
    voice VARCHAR2(256),
    height NUMBER(3,3),
    start_work DATE,
    child NUMBER(2),
    salary NUMBER(10,3)
)'); end;