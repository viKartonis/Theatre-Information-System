begin createTableIfNotExists('toureActor(
     toureActor_id NUMBER PRIMARY KEY,
     toure_id NUMBER NOT NULL REFERENCES toures(toure_id),
     actor_id NUMBER NOT NULL REFERENCES actors(actor_id),
     CONSTRAINT toureactor_unique UNIQUE (toure_id, actor_id)
)'); end;