-- group hosts by hardware info
SELECT
    cpu_number,
    id AS "host_id",
    total_mem
FROM
    host_info
ORDER BY
    cpu_number,
    total_mem DESC;

-- returns timestamps 5 mins apart
CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;

-- average memory usage
SELECT
    host_id,
    hostname AS host_name,
    round5(host_usage.timestamp) AS timestamp,
    avg(
        100 * (total_mem - memory_free) / total_mem
    ) AS avg_used_mem_percentage
FROM
    host_info INNER JOIN host_usage
        ON host_info.id = host_usage.host_id
GROUP BY
    host_id,
    hostname,
    round5(host_usage.timestamp)
ORDER BY
    host_id,
    timestamp;

-- detect host failure
SELECT
    host_id,
    round5(timestamp) AS "ts",
    count(*)          AS "num_data_points"
FROM
    host_usage
GROUP BY
    host_id,
    ts
HAVING
    count(*) < 3
ORDER BY
    host_id,
    ts;
