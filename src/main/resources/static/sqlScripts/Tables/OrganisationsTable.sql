DROP TABLE IF EXISTS Organisations;


CREATE TABLE Organisations (
	Id INT AUTO_INCREMENT,
    OrganisationName VARCHAR(50) NOT NULL,
    About VARCHAR(256),
    Flag INT,
    PRIMARY KEY(Id)
);