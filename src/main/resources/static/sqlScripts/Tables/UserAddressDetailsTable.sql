DROP TABLE IF EXISTS UserAddressDetails;


CREATE TABLE UserAddressDetails (
	  Id INT AUTO_INCREMENT,
	  UserId INT NOT NULL,
    firstAddress VARCHAR(256),
    VillageId INT,
    TehsilId INT,
    DistrictId INT,
    StateId INT,
	  Flag INT,
    CONSTRAINT fk_LocalAreaId_VillageTownLocalAreaDetails_Id FOREIGN KEY (LocalAreaId) REFERENCES VillageTownLocalAreaDetails(Id),
    PRIMARY KEY(Id)
);