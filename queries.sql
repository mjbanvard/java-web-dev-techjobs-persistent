## Part 1: Test it with SQL
SHOW columns FROM job;

## Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St.Louis";

## Part 3: Test it with SQL
DROP TABLE job

## Part 4: Test it with SQL
SELECT name, description
FROM techjobs.skill
WHERE id =
          ANY (SELECT skills_id
               FROM techjobs.job_skills
               WHERE jobs_id IS NOT NULL)
ORDER BY name ASC
