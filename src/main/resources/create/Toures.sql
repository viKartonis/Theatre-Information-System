begin createTableIfNotExists('toures(
    toure_id NUMBER PRIMARY KEY,
    performance_id NUMBER NOT NULL REFERENCES performances(performance_id),
    is_local NUMBER(1),
    date_start DATE,
    date_end DATE,
    CONSTRAINT toures_unique UNIQUE (performance_id, is_local, date_start, date_end)
 )'); end;