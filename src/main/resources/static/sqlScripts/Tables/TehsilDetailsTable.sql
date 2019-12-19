DROP TABLE IF EXISTS TehsilDetails;


CREATE TABLE TehsilDetails (
	  Id INT AUTO_INCREMENT,
    DistrictId INT NOT NULL,
    TehsilName VARCHAR(30) NOT NULL,
    TehsilCode VARCHAR(30) NOT NULL,
    Flag INT,
    About VARCHAR(256),
CONSTRAINT fk_DistrictId_DistrictDetails_Id FOREIGN KEY (DistrictId) REFERENCES DistrictDetails(Id),
PRIMARY KEY(Id)
);