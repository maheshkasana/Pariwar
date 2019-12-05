DROP TABLE IF EXISTS UserSessionManagement;


CREATE TABLE UserSessionManagement (
  Id INT AUTO_INCREMENT;
  UserId INT NOT NULL,
  Username VARCHAR(30),
  Token VARCHAR(30),
  Created INT,
  Updated INT,
  DeleteIt INT,
  Flag INT,
  PRIMARY KEY(Id)
);