SELECT 
  query_name, 
  ROUND(SUM(rating * 1.0 / position) / COUNT(*), 2) AS quality,
  ROUND((
    SELECT COUNT(*) 
    FROM Queries q2 
    WHERE q2.query_name = q1.query_name AND q2.rating < 3
  ) * 100 / COUNT(*), 2) AS poor_query_percentage
FROM Queries q1
GROUP BY query_name;
