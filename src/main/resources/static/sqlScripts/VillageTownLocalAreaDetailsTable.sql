DROP TABLE IF EXISTS VillageTownLocalAreaDetails;


CREATE TABLE VillageTownLocalAreaDetails (
	Id INT AUTO_INCREMENT,
    DistrictId INT NOT NULL,
    VillageTownLocalAreaName VARCHAR(100) NOT NULL,
    Created LONG,
    Updated LONG,
	Flag INT,
    About VARCHAR(256),
    CONSTRAINT fk_DistrictId_DistrictDetails_Id FOREIGN KEY (DistrictId) REFERENCES DistrictDetails(Id),
    PRIMARY KEY(Id)
);