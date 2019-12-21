
/////////************///////////**********/////////************///////////**********/////////************///////////**********/////////************///////////**********

function SendHttpRequestAndReturnResponseEtrace(url, requestType, toSendFormData, formData, callback, para1)
{

    var xhttp = new XMLHttpRequest();


    xhttp.onreadystatechange = function()
    {
  	    if(this.readyState<4)
  	    {

     	}
        else if(this.readyState==4)
            {
        	    if (this.status == 200)
    		    {
      		        if(this.responseText!=null)
                    {
                        //alert(this.responseText);
                        callback( this.responseText, para1);
                    }
                    else
                    {

                        //alert(this.responseText);
                        callback(this.responseText, para1);
                    }
		   	    }
		   	    else {
		   	        alert("Failed");
		   	    }
		    }
    };

    xhttp.open(requestType, url, false);
    xhttp.withCredentials = false;
    xhttp.setRequestHeader("Accept","application/json");
    if(toSendFormData)
        xhttp.setRequestHeader("Content-Type","multipart/form-data");
    else
       xhttp.setRequestHeader("Content-Type","application/json");

    if(toSendFormData)
        xhttp.send(formData);
    else
        xhttp.send();
    //location.replace("http://localhost:8081/index")
    //alert(this.responseText);
}


class DistrictCreateBody {
    constructor(name, code, stateId) {
        this.districtName = name;
        this.districtCode = code;
        this.stateId = stateId;
    }
}


function responseFromCreating(data) {
    alert("Got Response");
    alert(data);
}

function processAllStatesAndGetDistrictAndAddThemTotables(data, para1) {
    var Districts = JSON.parse(data);
    for(i in Districts) {
        var districtCode = Districts[i].name;
        var districtName = Districts[i].slug;
        requestJSON = new DistrictCreateBody(districtName,districtCode,para1);
        body = JSON.stringify(requestJSON);
        SendHttpRequestAndReturnResponse('http://localhost:8081/register/create/district', 'POST', false, body, "", "", false, null, responseFromCreating);
        //var formData = new FormData();
        //formData.append("get", "district");
        //formData.append("state", stateCode);
    }
}

// Create the XHR object.
function createCORSRequest(method, url) {
  var xhr = new XMLHttpRequest();
  if ("withCredentials" in xhr) {
    // XHR for Chrome/Firefox/Opera/Safari.
    xhr.open(method, url, false);
  } else if (typeof XDomainRequest != "undefined") {
    // XDomainRequest for IE.
    xhr = new XDomainRequest();
    xhr.open(method, url);
  } else {
    // CORS not supported.
    xhr = null;
  }
  return xhr;
}

// Make the actual CORS request.
function makeCorsRequest(data, callback, para1) {
  // This is a sample server that supports CORS.
  var url = 'https://etrace.in/pincodes/data';
  var xhr = createCORSRequest('POST', url);
  if (!xhr) {
    alert('CORS not supported');
    return;
  }

  // Response handlers.
  xhr.onload = function() {
    var text = xhr.responseText;
    //alert(text);
    //alert('Response from CORS request to ' + url + ': ' + title);
  };

  xhr.onerror = function() {
    alert('Woops, there was an error making the request.');
    //alert(xhr.responseText);
  };

   xhr.onreadystatechange = function()
   {
        if(xhr.readyState<4)
    	{
       	}
          else if(xhr.readyState==4)
              {
          	    if (xhr.status == 200)
      		    {
        		      if(xhr.responseText!=null)
                      {
                          //alert(xhr.responseText);
                          callback(this.responseText, para1);
                      }
                      else
                      {
                          //alert(xhr.responseText);
                          callback(this.responseText, para1);
                      }
  		   	    }
  		   	    else {
  		   	        alert("Failed");
  		   	    }
  		    }
      };

  xhr.send(data);
}



function getDistrictForStatefromEtrace(data, para1) {
    var states = JSON.parse(data);
    for(i in states) {
        var stateId = states[i].id;
        var stateCode = states[i].stateCode;
        var stateName = states[i].stateName;
        //alert(stateId+stateCode+stateName);

        var formData = new FormData();
        formData.append("get", "district");
        formData.append("state", stateCode);

        /*
                var data = new FormData();
                data.append("get", "city");
                data.append("state", "haryana");
                data.append("district", "karnal");
        */
        makeCorsRequest(formData, processAllStatesAndGetDistrictAndAddThemTotables, stateId);

    }

}


class TehsilCreateBody {
    constructor(name, code, Id) {
        this.tehsilName = name;
        this.tehsilCode = code;
        this.districtId = Id;
    }
}


function responseFromCreatingTehsil(data) {
    alert("Got Response");
    alert(data);
}


function processAllTehsilForDistrictGotFromEtrace(data, distrcitId) {
    var tehsils = JSON.parse(data);
    for(i in tehsils) {
        var tehsilName = tehsils[i].name;
        var tehsilCode = tehsils[i].slug;
        requestJSON = new TehsilCreateBody(tehsilName,tehsilCode,distrcitId);
        body = JSON.stringify(requestJSON);
        //alert("Body\n" + body);
        SendHttpRequestAndReturnResponse('http://localhost:8081/register/create/tehsil', 'POST', false, body, "", "", false, null, responseFromCreatingTehsil);
    }

}

function getDistrictForStatefromLocalDatabase(data, formdata) {

    var districts = JSON.parse(data);
    for(i in districts) {
        var stateid = districts[i].stateId;
        var distrcitCode = districts[i].districtName;
        var distrcitId = districts[i].id;

        formdata.append("district", distrcitCode);
        //alert(stateid + ", " + distrcitCode + ", " + distrcitId);
        //makeCorsRequest(formdata, processAllTehsilForDistrictGotFromEtrace, distrcitId);
    }
}


function getStatefromLocalDatabase(data, para1) {

    var requestType = 'GET';
    var states = JSON.parse(data);
    for(i in states) {
        var stateId = states[i].id;
        var stateCode = states[i].stateCode;
        var stateName = states[i].stateName;

        var url = "http://localhost:8081/register/auto/districtByStateId/"+stateId;
        var formData = new FormData();
        formData.append("get", "city");
        formData.append("state", stateCode);

        /*
                var data = new FormData();
                data.append("get", "city");
                data.append("state", "haryana");
                data.append("district", "karnal");
        */
        //makeCorsRequest(formData, processAllStatesAndGetDistrictAndAddThemTotables, stateId);
        SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, getDistrictForStatefromLocalDatabase, formData);
    }

}

class VillageCreateBody {
    constructor(name, code, Id) {
        this.villageTownLocalAreaName = name;
        this.villageTownLocalAreaCode = code;
        this.tehsilId = Id;
        this.PinCode = 0;
    }
}


function responseFromCreatingVillage(data) {
    //alert("Got Response");
    //alert(data);
}

function processAllVillageForTehsilGotFromEtraceInBatch(data, teshilId) {
    var villages = JSON.parse(data);

    var villagesBatch = [];
    for(i in villages) {
        var villName = villages[i].name;
        var villCode = villages[i].slug;
        villagesBatch.push(new VillageCreateBody(villName,villCode,teshilId));
    }
    body = JSON.stringify(villagesBatch);
    SendHttpRequestAndReturnResponse('/register/create/villageTown/inBatch', 'POST', false, body, null, null, false, null, responseFromCreatingVillage);
}

function processAllVillageForTehsilGotFromEtrace(data, teshilId) {
    var villages = JSON.parse(data);
    for(i in villages) {
        var villName = villages[i].name;
        var villCode = villages[i].slug;
        requestJSON = new VillageCreateBody(villName,villCode,teshilId);
        body = JSON.stringify(requestJSON);
        SendHttpRequestAndReturnResponse('/register/create/villageTown', 'POST', false, body, null, null, false, null, responseFromCreatingVillage);
    }

}


function VillageGetTehsilForDistrictForStatefromLocalDatabase(data, formdata) {

    var tehsils = JSON.parse(data);
    for(i in tehsils) {
        var tehsilCode = tehsils[i].tehsilCode;
        var teshilId = tehsils[i].id;

        if(teshilId > 3191) {
            formdata.append("city", tehsilCode);
            //alert(stateid + ", " + distrcitCode + ", " + distrcitId);
            makeCorsRequest(formdata, processAllVillageForTehsilGotFromEtraceInBatch, teshilId);
        }

    }
}




function VillageGetDistrictForStatefromLocalDatabase(data, formdata) {

     var requestType = 'GET';
    var districts = JSON.parse(data);
    for(i in districts) {
        var distrcitCode = districts[i].districtName;
        var distrcitId = districts[i].id;
        var url = "http://localhost:8081/register/auto/allTehsilByDistrictId/"+distrcitId;

        formdata.append("district", distrcitCode);
        //alert(stateid + ", " + distrcitCode + ", " + distrcitId);
        SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, VillageGetTehsilForDistrictForStatefromLocalDatabase, formdata);

    }
}



function VillageGetStatefromLocalDatabase(data, para1) {

    var requestType = 'GET';
    var states = JSON.parse(data);
    for(i in states) {
        var stateId = states[i].id;
        var stateCode = states[i].stateCode;
        var stateName = states[i].stateName;

        var url = "http://localhost:8081/register/auto/districtByStateId/"+stateId;
        var formData = new FormData();
        formData.append("get", "loc");
        formData.append("state", stateCode);

        /*
                var data = new FormData();
                data.append("get", "city");
                data.append("state", "haryana");
                data.append("district", "karnal");
        */
        //makeCorsRequest(formData, processAllStatesAndGetDistrictAndAddThemTotables, stateId);
        SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, VillageGetDistrictForStatefromLocalDatabase, formData);
    }

}


//Getting called from HTML
function makeHttpRequestToGetAllStates() {
        var url = "http://localhost:8081/register/auto/allStates";
        var requestType = 'GET';

        //SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, getDistrictForStatefromEtrace, 0);
        //SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, getStatefromLocalDatabase, 0);
        //SendHttpRequestAndReturnResponseEtrace(url, requestType, false, null, VillageGetStatefromLocalDatabase, 0);
}
