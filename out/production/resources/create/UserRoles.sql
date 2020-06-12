begin createTableIfNotExists('user_roles(
    user_role_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    CONSTRAINT user_role_unique UNIQUE (name)
)'); end;