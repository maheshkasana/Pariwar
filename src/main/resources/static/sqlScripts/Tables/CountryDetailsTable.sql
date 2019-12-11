DROP TABLE IF EXISTS CountryDetails;


CREATE TABLE CountryDetails (
	  Id INT AUTO_INCREMENT,
    CountryName VARCHAR(30) NOT NULL,
    CountryCode VARCHAR(30),
	  Flag INT,
    About VARCHAR(256),
    PRIMARY KEY(Id)
);