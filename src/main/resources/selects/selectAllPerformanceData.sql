SELECT producer, designer, conductor, category, performance_date, genre, role, actor_name, understudy_name
FROM performances
JOIN (
    SELECT workers.name AS producer, performances.performance_id AS p_id_prod
    FROM performances
    JOIN producers ON performances.producer_id = producers.producer_id
    JOIN workers ON producers.worker_id = workers.worker_id
)   ON performances.performance_id = p_id_prod
JOIN (
    SELECT workers.name AS designer, performances.performance_id AS p_id_des
    FROM performances
    JOIN productor_designers ON performances.productor_designer_id = productor_designers.productor_designers_id
    JOIN workers ON productor_designers.worker_id = workers.worker_id
)  ON performances.performance_id = p_id_des
JOIN (
    SELECT performance_categories.name AS category, performances.performance_id AS p_id_cat
    FROM performances
    JOIN performance_categories ON performance_categories.performance_category_id = performances.performance_category_id
) ON performances.performance_id = p_id_cat
JOIN (
    SELECT workers.name AS conductor, performances.performance_id AS p_id_con
    FROM performances
    JOIN conductors ON performances.conductor_id = conductors.conductor_id
    JOIN workers ON conductors.worker_id = workers.worker_id
) ON performances.performance_id = p_id_con
JOIN (
    SELECT performances.is_premier AS premier, performances.performance_id AS p_id_prem
    FROM performances
) ON performances.performance_id = p_id_prem
JOIN (
    SELECT performances.performance_date AS performance_date, performances.performance_id AS p_id_date
    FROM performances
)  ON performances.performance_id = p_id_date
JOIN (
    SELECT genres.name AS genre, performances.performance_id AS p_id_genre
    FROM performances
    JOIN genres ON genres.genres_id = performances.genre_id
)  ON performances.performance_id = p_id_genre
JOIN (
SELECT name AS role, actor_name, understudy_name, performances.performance_id AS p_id_ac
    FROM
        (SELECT roles.role_id AS actor_role, workers.name AS actor_name, roles.performance_is, roles.name
            FROM roles
                JOIN actors ON actors.actor_id = roles.actor_id
                JOIN workers ON actors.worker_id = workers.worker_id)
        JOIN (SELECT roles.role_id AS understudy_role, workers.name AS understudy_name
            FROM roles
                JOIN actors ON actors.actor_id = roles.understudy_id
                JOIN workers ON actors.worker_id = workers.worker_id)
            ON actor_role = understudy_role
        JOIN performances ON performances.performance_id = performance_is
)  ON performances.performance_id = p_id_ac

WHERE performances.name  LIKE