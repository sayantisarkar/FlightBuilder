DROP TABLE IF EXISTS flight;

CREATE TABLE flight (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  flight_no VARCHAR(250) NOT NULL,
  dep_airport VARCHAR(250) NOT NULL,
  arr_airport VARCHAR(250) NOT NULL,
  dep_time TIME NOT NULL,
  arr_time TIME DEFAULT NULL
);