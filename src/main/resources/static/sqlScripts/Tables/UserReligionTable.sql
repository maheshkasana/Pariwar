DROP TABLE IF EXISTS UserReligion;


CREATE TABLE UserReligion (
	  Id INT AUTO_INCREMENT,
    ReligionName VARCHAR(30) NOT NULL,
    Flag INT,
    About VARCHAR(256),
    PRIMARY KEY(Id)
);