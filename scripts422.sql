CREATE TABLE human (
    name VARCHAR PRIMARY KEY,
    age INTEGER,
    driver BOOLEAN,
    car_id INTEGER REFERENCES car(id)
);
-- DROP TABLE human;
CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    brand VARCHAR,
    model VARCHAR,
    cost money
);
-- DROP TABLE car CASCADE;
SELECT h.name, h.driver, h.age, c.brand, c.model
FROM human h INNER JOIN car c on c.id = h.car_id;