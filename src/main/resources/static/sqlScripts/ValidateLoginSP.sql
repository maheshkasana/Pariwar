DELIMITER $$

DROP PROCEDURE IF EXISTS ValidateLogin;
 
CREATE PROCEDURE ValidateLogin(IN userDetails VARCHAR(256), OUT ResponseXML VARCHAR(256))
BEGIN
		DECLARE username VARCHAR(256);
		DECLARE passwords VARCHAR(256);
    
		SET username =	ExtractValue(userDetails, '//userdetails[1]/username');
		SET passwords = ExtractValue(userDetails, '//userdetails[1]/passwords');
		
        -- SELECT username, passwords;
        SET ResponseXML = userDetails;
        -- SET ResponseXML = '<loginResponse username="mahesh Kasana" status="1" AuthToken="123456mahesg" id="1">';
    
    
	    -- SELECT * FROM testKasana where id = 1;
END$$
DELIMITER ;