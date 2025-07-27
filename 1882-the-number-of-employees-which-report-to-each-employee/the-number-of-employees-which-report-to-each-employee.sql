SELECT 
  e.employee_id,
  e.name,
  COUNT(r.employee_id) AS reports_count,
  ROUND(AVG(r.age)) AS average_age
FROM employees e
JOIN employees r
  ON e.employee_id = r.reports_to
GROUP BY e.employee_id, e.name
ORDER BY e.employee_id;
