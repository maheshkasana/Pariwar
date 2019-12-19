DROP TABLE IF EXISTS DistrictDetails;


CREATE TABLE DistrictDetails (
	Id INT AUTO_INCREMENT,
    StateId INT NOT NULL,
    DistrictName VARCHAR(30) NOT NULL,
    DistrictCode VARCHAR(30) NOT NULL,
    Flag INT,
    About VARCHAR(256),
    CONSTRAINT fk_StateId_StateDetails_Id FOREIGN KEY (StateId) REFERENCES StateDetails(Id),
    PRIMARY KEY(Id)
);