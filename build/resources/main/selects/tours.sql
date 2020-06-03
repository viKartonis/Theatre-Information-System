SELECT
    workers.name,
    CASE
        WHEN actors.actor_id IS NULL AND producers.producer_id IS NOT NULL
        THEN 'постановщик'
        ELSE 'актёр'
    END AS job_name
FROM
    workers
        FULL OUTER JOIN (
            actors JOIN toureActor ON actors.actor_id = toureActor.actor_id
        ) ON workers.worker_id = actors.worker_id
        FULL OUTER JOIN (
            producers JOIN toureProducer ON producers.producer_id = toureProducer.producer_id
        ) ON producers.worker_id = workers.worker_id
        JOIN toures ON (toureActor.toure_id = toures.toure_id OR toureProducer.toure_id = toures.toure_id)
WHERE (actors.actor_id IS NOT NULL OR producers.producer_id IS NOT NULL)  AND toures.is_local = 1
AND toures.date_start BETWEEN