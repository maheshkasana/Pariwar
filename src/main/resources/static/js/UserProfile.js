function uploadAndShowImage(event,elementId, elementIdValue) {
    var image = document.getElementById(elementId);
	image.src = URL.createObjectURL(event.target.files[0]);
	document.getElementById(elementIdValue).value = "True";

}


function UpdateProfileStartButton() {
	document.getElementById("profile_update_start").style.display = "none";
	document.getElementById("profile_update_submit").style.display = "block";
	document.getElementById("profile_update_submit").style.color = "#ffffff";
	document.getElementById("profileButtonToUpdatePic").style.display = "block";

	document.getElementById("profile_firstname").disabled = false;
	document.getElementById("profile_mobile").disabled = false;
	document.getElementById("profile_email").disabled = false;
	document.getElementById("profile_Locality").disabled = false;
}



function setCookie(username, token,id, expiresminutes) {
  var d = new Date();
  d.setTime(d.getTime() + (expiresminutes*1000));
  var expires = "expires="+ d.toUTCString();
  var cookiesString= "userId=" + id.toString() + ", username=" + username + ", authKey=" + token + ", " + expires + ", pariwarStatus=1";
  document.cookie = cookiesString;
}


function resetCookie() {
  var res = document.cookie;
  var multiple = res.split(",");
  for(var i = 0; i < multiple.length; i++) {
      var key = multiple[i].split("=");
      document.cookie = key[0]+" =; expires = Thu, 01 Jan 1970 00:00:00 UTC";
      }
}


function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(',');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function checkIfNotLoggedInToSignIn() {
    var userName = getCookie("username");
    var token = getCookie("authKey");
    var status = getCookie("pariwarStatus");
    var id = getCookie("userId");
    if(userName == null || token==null || id<=0) {
        location.replace("http://localhost:8081/");
    } else {
        ShowDetailsOfUser(token);
    }
}



/**
THIS Function is Generic for sending Http Request and calling the passed callback function,

*/
function SendHttpRequestAndReturnResponse(url, requestType, isSync, body, elementStatus, elementStatusContent, isFile, fileObject, callback)
{

    var xhttp = new XMLHttpRequest();

    if(isFile) {
        var formData = new FormData();
        formData.append("Image", fileObject);
        xhttp.addEventListener('progress', updateRegisterImageUploadProgressbar, false);
        if ( xhttp.upload ) {
           xhttp.upload.onprogress = function(e) {
                    updateRegisterImageUploadProgressbar(e);
           };
        }
    }

    xhttp.onreadystatechange = function()
    {
  	    if(this.readyState<4)
  	    {
  	        if(elementStatus.length > 0 && elementStatus != null) {
     	   	    document.getElementById(elementStatus).innerHTML="<img src='images/loading3.gif' style='width:30%; height:100%; border-radius: 60%;'>";
     	   	}
  	    }
        else if(this.readyState==4)
            {
        	    if (this.status == 200)
    		    {
      		        if(this.responseText!=null)
                    {
                        if(elementStatus.length > 0 && elementStatus != null) {
                            document.getElementById(elementStatus).innerHTML="<p style='color: green;'><b>successful</b></p>";
                        }
                        callback(this.responseText);
                    }
                    else
                    {
                        if(elementStatus.length > 0 && elementStatus != null) {
                            document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>" ;
                        }
                        callback(this.responseText);
                    }
		   	    }
     		    else
     		    {
     		        if(elementStatus.length > 0 && elementStatus != null) {
     		            document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>";
     		        }
    		    }
		    }
    };

    xhttp.open(requestType, url, isSync);
    if(isFile) {
        xhttp.setRequestHeader("enctype","multipart/form-data");
        formData.append("body", body);
        xhttp.send(formData);
        console.log(formData);
    } else {
        xhttp.setRequestHeader("Accept","application/json");
        xhttp.setRequestHeader("Content-Type","application/json");
        xhttp.send(body);
    }
    //location.replace("http://localhost:8081/index")
    //return this.responseText;
}

function processAutoSuggestRegisterReligion(str_response) {

    response = JSON.parse(str_response);
    document.getElementById("profile_firstname").value = response.firstname;
    document.getElementById("profile_username").value = response.username;

    if(response.gender == 1)
        document.getElementById("profile_gender").value = "Male";
    else
        document.getElementById("profile_gender").value = "Female";

    document.getElementById("profile_dob").value = response.dateofbirth;
    document.getElementById("profile_mobile").value = response.contactDetails.phone;
    document.getElementById("profile_email").value = response.contactDetails.emailAddress;

    document.getElementById("profile_religion").value = response.userReligiousDetails.religion.religionName;
    document.getElementById("profile_caste").value = response.userReligiousDetails.caste.userCasteName;
    document.getElementById("profile_subcaste").value = response.userReligiousDetails.subCaste.userSubCasteName;

    document.getElementById("profile_Locality").value = response.userAddressDetails.locality;
    document.getElementById("profile_village").value = response.userAddressDetails.villageTown.villageTownLocalAreaName;
    document.getElementById("profile_tehsil").value = response.userAddressDetails.tehsil.tehsilName;
    document.getElementById("profile_district").value = response.userAddressDetails.district.districtCode;
    document.getElementById("profile_state").value = response.userAddressDetails.state.stateName;

    document.getElementById("profileProflePic").src = "images/userProfilePics/userProfilePic_"+response.userId + ".jpg";

}

function ShowDetailsOfUser(token) {
    var url = "/user/details/"+token;
    var requestType = 'GET';
    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterReligion);
}