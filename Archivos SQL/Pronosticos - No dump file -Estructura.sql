CREATE SCHEMA IF NOT EXISTS Pronosticos;
USE pronosticos;
CREATE TABLE IF NOT EXISTS Pronosticos(
id INT NOT NULL UNIQUE,
idUser INT NOT NULL UNIQUE,
resPartidos VARCHAR(70)
);

SELECT * from Pronosticos;