DROP TABLE IF EXISTS DistrictDetails;


CREATE TABLE UserSessionManagementDetails (
	  Id INT AUTO_INCREMENT,
    KeyId VARCHAR(100) NOT NULL,
    UserId INT NOT NULL,
    Created LONG,
    Updated LONG,
    Flag INT,
    PRIMARY KEY(Id)
);