begin createTableIfNotExists('toureActor(
     toureActor_id NUMBER PRIMARY KEY,
     toure_id NUMBER NOT NULL REFERENCES toures(toure_id),
     actor_id NUMBER NOT NULL REFERENCES actors(actor_id)
     )'); end;