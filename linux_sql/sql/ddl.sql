-- connect to "host_agent" database
\c host_agent

-- define "host_info" table
CREATE TABLE IF NOT EXISTS host_info
(
    id               SERIAL    NOT NULL PRIMARY KEY,
    hostname         VARCHAR   NOT NULL,
    cpu_number       INT       NOT NULL,
    cpu_architecture VARCHAR   NOT NULL,
    cpu_model        VARCHAR   NOT NULL,
    cpu_mhz          FLOAT     NOT NULL,
    L2_cache         INT       NOT NULL,
    total_mem        INT       NOT NULL,
    "timestamp"      TIMESTAMP NOT NULL
);

-- define "host_usage" table
CREATE TABLE IF NOT EXISTS host_usage
(
    "timestamp"    TIMESTAMP NOT NULL,
    host_id        SERIAL    NOT NULL,
    memory_free    INT       NOT NULL,
    cpu_idle       INT       NOT NULL,
    cpu_kernel     INT       NOT NULL,
    disk_io        INT       NOT NULL,
    disk_available INT       NOT NULL,
    CONSTRAINT host_info_id FOREIGN KEY (host_id) REFERENCES host_info (id)
);
