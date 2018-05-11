// Problem link: https://leetcode.com/problems/big-countries/description/
// Status: Accepted

SELECT w.name, w.population, w.area
FROM World w
WHERE w.area > 3000000 OR w.population > 25000000;
