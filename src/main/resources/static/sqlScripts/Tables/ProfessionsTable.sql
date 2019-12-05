DROP TABLE IF EXISTS Professions;


CREATE TABLE Professions (
	Id INT AUTO_INCREMENT,
    ProfessionsName VARCHAR(50),
    About VARCHAR(256),
	Flag INT,
    PRIMARY KEY(Id)
);