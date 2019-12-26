DROP TABLE IF EXISTS UserSessionManagementDetails;


CREATE TABLE UserSessionManagementDetails (
	  Id INT AUTO_INCREMENT,
    Key VARCHAR(100) NOT NULL,
    UserId INT NOT NULL,
    Created LONG,
    Updated LONG,
	  Flag INT
);