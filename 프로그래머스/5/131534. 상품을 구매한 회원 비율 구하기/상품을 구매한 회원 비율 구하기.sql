WITH USER2021 AS(
    SELECT USER_ID
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
),
PURCHASE AS(
    SELECT YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH, COUNT(DISTINCT S.USER_ID) AS PURCHASED_USERS
    FROM ONLINE_SALE S
    JOIN USER2021 U ON S.USER_ID = U.USER_ID
    GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE)
)
SELECT P.YEAR AS YEAR, P.MONTH AS MONTH, P.PURCHASED_USERS, ROUND(P.PURCHASED_USERS / (SELECT COUNT(*) FROM USER2021), 1) AS PUCHASED_RATIO
FROM PURCHASE P
ORDER BY P.YEAR, P.MONTH;