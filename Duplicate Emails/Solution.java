// Problem link: https://leetcode.com/problems/duplicate-emails/description/
// Status: Accepted

SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1
