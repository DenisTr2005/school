SELECT s.name, s.age, f.name
FROM student s INNER JOIN faculty f on f.id = s.faculty_id;
SELECT s.name, s.age, a.data
FROM student s INNER JOIN avatar a on a.id = s.avatar_id;