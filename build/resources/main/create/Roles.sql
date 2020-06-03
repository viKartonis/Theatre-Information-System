begin createTableIfNotExists('roles(
     role_id NUMBER PRIMARY KEY,
     name VARCHAR2(256),
     characteristic_id NUMBER NOT NULL REFERENCES characteristics(characteristic_id),
     actor_id NUMBER NOT NULL REFERENCES workers(worker_id),
     understudy_id NUMBER NOT NULL REFERENCES workers(worker_id),
     performance_is NUMBER NOT NULL REFERENCES performances(performance_id)
     )'); end;