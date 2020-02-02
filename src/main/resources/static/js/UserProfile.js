
function UpdateProfileStartButton() {
	document.getElementById("profile_update_start").style.display = "none";
	document.getElementById("profile_update_submit").style.display = "block";
	document.getElementById("profile_update_submit").style.color = "#ffffff";
	document.getElementById("profileButtonToUpdatePic").style.display = "block";

	document.getElementById("profile_firstname").disabled = false;
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

function processResponseToShowUserDetails(str_response) {

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
    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processResponseToShowUserDetails);
}


//Contact details
class contactDetails {
    constructor(email_i, phone_i) {
        this.emailAddress = email_i;
        this.phone = phone_i;
     }

    setEmailAddress(i_email) {
        this.emailAddress = i_email;
    }

    setPhone(i_phone) {
        this.phone = i_phone;
    }

}


//Religious Details
class religiousDetails {
    constructor(i_religion,i_caste,i_subCaste) {
        this.religion = i_religion;
        this.caste = i_caste;
        this.subCaste = i_subCaste;
     }

    setReligion(i_religion) {
        this.religion = i_religion;
    }

    setCaste(i_caste) {
        this.caste = i_caste;
    }

    setSubCaste(i_subCaste) {
        this.subCaste = i_subCaste;
    }
}


//Address Details
class AddressDetails {
    constructor(i_locality,i_village,i_tehsil,i_district,i_state) {
        this.locality = i_locality;
        this.village = i_village;
        this.tehsil = i_tehsil;
        this.district = i_district;
        this.state = i_state;
    }

    setLocality(i_locality) {
        this.locality = i_locality;
    }

    setVillage(i_village) {
        this.village = i_village;
    }

    setDistrict(i_district) {
        this.district = i_district;
    }

    setState(i_state) {
        this.state = i_state;
    }

    setTehsil(i_tehsil) {
        this.tehsil = i_tehsil;
    }

}


//Actual Class for Registeration Details
class RegisterDetails {
    constructor() {

    }

    SetContactDetails(contact_i) {
        this.contact = contact_i;
    }

    SetReligiousDetails(religious_i) {
         this.religious = religious_i;
    }

    SetAddressDetails(address_i) {
         this.address = address_i;
    }

    setUsername(i_username) {
        this.username = i_username;
    }

    setPassword(i_password) {
        this.password = i_password;
    }

    setFirstname(i_firstname) {
        this.firstname = i_firstname;
    }

    setGender(i_gender) {
        this.gender = i_gender;
    }

    setDateofbirth(i_dateofbirth) {
        this.dateofbirth = i_dateofbirth;
    }

    setProfilepic(i_profilepic) {
        this.profilepic = i_profilepic;
    }
}

function responseFromRegisterRequest(response) {
    var resp = JSON.parse(response);
    var userId = resp.statusCode;
    var errorCode = resp.errorCode;
    var errorMsg = resp.errorMessage;

    if(0 >= userId) {
        alert("Failed to Register, Retry after sometime");
      } else {
            location.replace("http://localhost:8081/profile");
         }
}

function uploadAndShowImage(event,elementId, elementIdValue) {
    var image = document.getElementById(elementId);
	image.src = URL.createObjectURL(event.target.files[0]);
	document.getElementById("profileButtonToUpdatePic").value = "True";

}

/**
* functions are for the Progress bar for the Image
*/
function updateRegisterImageUploadProgressbar(e) {
 var progress = document.getElementById("profileImageProgressBar");
 progress.style.display="block";
 var done = e.position || e.loaded, total = e.totalSize || e.total;
 progress.value = Math.floor(done/total*1000)/10;
}



function UpdateProfileSubmitButton()
{
    detailObject = new RegisterDetails();

    //First Name + Last Name
    var _fname = document.getElementById("profile_firstname").value;
    if(_fname == null || _fname.length <=0) {
        alert("First Name Cannot be Empty");
        return;
    }
    detailObject.firstname = _fname;

    //profile pic
    var _isFile = false;
    var PicUpdate = document.getElementById("profileButtonToUpdatePic").value;
        if(PicUpdate == "True") {
        if(document.getElementById("profileButtonToUpdatePic").value.length > 0) {
            _isFile = true;
            var file = document.getElementById("getUpdateProfileImage").files[0];
            detailObject.profilepic = file.name;
        }
    }

    var _locality = document.getElementById("profile_Locality").value;
    detailObject.SetAddressDetails(new AddressDetails(_locality, 0, 0, 0, 0));


    var urlFile = "http://localhost:8081/profile/update/user/file";
    var url = "http://localhost:8081/profile/update/user";
    var requestType = 'POST';
    var elementStatus = "loading_profile";
    body = JSON.stringify(detailObject);
    console.log(body);
    if(_isFile)
        SendHttpRequestAndReturnResponse(urlFile, requestType, false, body, elementStatus, "", true, file, responseFromRegisterRequest);
    else
        SendHttpRequestAndReturnResponse(url, requestType, false, body, elementStatus, "", false, null, responseFromRegisterRequest);

}


function wait(ms)
{
    var d = new Date();
    var d2 = null;
    do { d2 = new Date(); }
    while(d2-d < ms);
}




function SendHttpRequestAndReturnResponseToSameFunction(url, requestType, isSync, body, elementStatus, elementStatusContent, isFile, fileObject)
{
    var xhttp = new XMLHttpRequest();

    var flag = false;

    var result = null;

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
                        flag = true;
                        //callback(this.responseText);
                        result = this.responseText;
                    }
                    else
                    {
                        if(elementStatus.length > 0 && elementStatus != null) {
                            document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>" ;
                        }
                        flag = true;
                        result = this.responseText;
                       // callback(this.responseText);
                    }
		   	    }
     		    else
     		    {
     		        if(elementStatus.length > 0 && elementStatus != null) {
     		            document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>";
     		        }
     		        flag = true;
     		        result = this.responseText;
    		    }
		    }
    };

    xhttp.open(requestType, url, false);
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
    var try_ = 0;
    while(flag == false && try_ < 5) {
        wait(500);
        try_ = try_ + 1;
    }
    return result;
}


function UpdateProfileSubmitButton_done() {

    var url = "/user/details/"+getCookie("authKey");;
    var requestType = 'GET';
    alert(SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null));

}

