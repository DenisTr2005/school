ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age > 15 );
ALTER TABLE student
    ADD CONSTRAINT name_constraint UNIQUE(name);
ALTER TABLE student
    ALTER COLUMN name SET NOT NULL;
ALTER TABLE faculty
    ADD CONSTRAINT facName_constraint UNIQUE(color, name);
ALTER TABLE student
    ALTER COLUMN age SET DEFAULT(20);
SELECT * FROM student;
