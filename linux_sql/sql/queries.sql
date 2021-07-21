-- INSERT INTO host_info (id, hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, timestamp)
-- VALUES (1, 'spry-framework-236416.internal', 1, 'x86_64', 'Intel(R) Xeon(R) CPU @ 2.30GHz', 2300.000, 256, 601324,
--         '2019-05-29 17:49:53');
--
-- INSERT INTO host_usage ("timestamp", host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
-- VALUES ('2019-05-29 16:53:28', 1, 256, 95, 0, 0, 31220);
--
-- INSERT INTO host_usage ("timestamp", host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
-- VALUES ('2019-05-29 15:00:00.000', 1, 300000, 90, 4, 2, 3);
--
-- INSERT INTO host_usage ("timestamp", host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
-- VALUES ('2019-05-29 15:01:00.000', 1, 200000, 90, 4, 2, 3);

SELECT
    cpu_number,
    id AS "host_id",
    total_mem
FROM
    host_info
ORDER BY
    cpu_number,
    total_mem DESC;

CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;

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