DROP TABLE IF EXISTS VillagetDetails;


CREATE TABLE VillagetDetails (
	Id INT AUTO_INCREMENT,
    DistrictId INT NOT NULL,
    VillageName VARCHAR(30) NOT NULL,
    Created LONG,
    Updated LONG,
	Flag INT,
    About VARCHAR(256),
    CONSTRAINT fk_DistrictId_DistrictDetails_Id FOREIGN KEY (DistrictId) REFERENCES DistrictDetails(Id),
    PRIMARY KEY(Id)
);