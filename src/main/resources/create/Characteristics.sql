begin createTableIfNotExists('characteristics(
    characteristic_id NUMBER PRIMARY KEY,
    gender NUMBER(1),
    date_bd DATE,
    voice VARCHAR2(512),
    height NUMBER(3),
    start_work DATE,
    child NUMBER(2),
    salary NUMBER(15,3),
    CONSTRAINT characteristics_unique UNIQUE (gender, date_bd, voice, height, start_work, child, salary)
)'); end;