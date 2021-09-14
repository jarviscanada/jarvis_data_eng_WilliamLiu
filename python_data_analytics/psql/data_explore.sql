-- Show table schema 
\d+ retail;

-- Show first 10 rows
SELECT
    *
FROM
    retail
LIMIT 10;

-- Check # of records
SELECT
    count(*)
FROM
    retail;

-- Number of clients (e.g. unique client ID)
SELECT
    count(DISTINCT customer_id)
FROM
    retail;

-- Invoice date range (e.g. max/min dates)
SELECT
    max(invoice_date),
    min(invoice_date)
FROM
    retail;

-- Number of SKU/merchants (e.g. unique stock code)
SELECT
    count(DISTINCT stock_code)
FROM
    retail;

-- Calculate average invoice amount excluding invoices with a negative amount
-- (e.g. canceled orders have negative amount)
SELECT
    avg(s.total)
FROM
    (
        SELECT
            sum(unit_price * quantity) AS total
        FROM
            retail
        GROUP BY
            invoice_no
    ) AS s
WHERE
    s.total > 0;

-- Calculate total revenue (e.g. sum of unit_price * quantity)
SELECT
    sum(unit_price * quantity)
FROM
    retail;

-- Calculate total revenue by YYYYMM
SELECT
    cast(extract(YEAR FROM invoice_date) AS INTEGER) * 100 +
        cast(extract(MONTH FROM invoice_date) AS INTEGER) AS yyyymm,
    sum(unit_price * quantity)
FROM
    retail
GROUP BY
    yyyymm
ORDER BY
    yyyymm;
