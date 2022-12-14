SELECT B.CATEGORY, SUM(A.SALES) AS TOTAL_SALES
FROM BOOK AS B
LEFT JOIN (
    SELECT *
    FROM BOOK_SALES
    WHERE DATE_FORMAT(SALES_DATE, "%Y-%m") LIKE "2022-01"
) AS A
ON B.BOOK_ID = A.BOOK_ID
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC

