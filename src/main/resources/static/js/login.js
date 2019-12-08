
class LoginRequestBody {
    constructor(username, password) {
            this.username = username;
            this.password = password;
    }
}

class LoginResponseBody {
    constructor(username, token, status) {
        this.username = username;
        this.token = token;
        this.status = status;
    }
}


function TestsendHttpRequest()
{
    alert("in Sed HTTP");
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8081/index", false ); // false for synchronous request
    xmlHttp.send( null );
    alert(xmlHttp.responseText);
    return xmlHttp.responseText;
}

function setCookie(username, token,id, expiresminutes) {
  var d = new Date();
  d.setTime(d.getTime() + (expiresminutes*1000));
  var expires = "expires="+ d.toUTCString();
  var cookiesString= "pariwarId=" + id.toString() + ", pariwarUsername=" + username + ", pariwarToken=" + token + ", " + expires + ", pariwarStatus=1";
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


function showCookies()
{
    alert("got Cookies username : "+ getCookie("pariwarUsername"));
    alert("got Cookies Token : "+ getCookie("pariwarToken"));
    alert("got Cookies status : "+ getCookie("pariwarStatus"));
    alert("got Cookies id : "+ getCookie("pariwarId"));

}

function adjustLoginPopUpContentStyle() {
    h = screen.height;
    w = screen.width;

    if(h-w > 200) {
        document.getElementById("modal_content_login").style = "height:60vw; width:80vw; margin-top:"+h/4+"px;";
    }

}

function checkIfAlreadyLoggedIn() {

    adjustLoginPopUpContentStyle();

    var userName = getCookie("pariwarUsername");
    var token = getCookie("pariwarToken");
    var status = getCookie("pariwarStatus");
    var id = getCookie("pariwarId");

    //if(userName!=null && userName.length > 0 && token!=null && token.length>0 && status==true && id>0)
        //location.replace("http://localhost:8081/home?username="+userName+"&token="+token+"&userId="+id);
}


/**
*Call back Function for the Login validation check and it do redirect the as the the status.
*/
function responseFromLoginCheck(details)
{
    var response = JSON.parse(details);
    if(response.status==true) {
        document.getElementById('login_loading').innerHTML="<p style='color: green;'><b>Login successful</b></p>";
        setCookie(response.userName,response.authToken,response.id,5*60);
        location.replace("http://localhost:8081/home?username="+response.userName+"&token="+response.authToken+"&userId="+response.id);
    }
    else {
        document.getElementById('login_loading').innerHTML="<p style='color: red;'><b>Failed to validate</b></p>" ;
    }
}

/**
* functions are for the Progress bar for the Image
*/
function updateRegisterImageUploadProgressbar(e) {
 var progress = document.getElementById("registerImageProgressBar");
 progress.style.display="block";
 var done = e.position || e.loaded, total = e.totalSize || e.total;
 progress.value = Math.floor(done/total*1000)/10;
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
     	   	document.getElementById(elementStatus).innerHTML="<img src='images/loading3.gif' style='width:30%; height:100%; border-radius: 60%;'>";
  	    }
        else if(this.readyState==4)
            {
        	    if (this.status == 200)
    		    {
      		        if(this.responseText!=null)
                    {
                        document.getElementById(elementStatus).innerHTML="<p style='color: green;'><b>successful</b></p>";
                        callback(this.responseText);
                    }
                    else
                    {
                        document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>" ;
                        callback(this.responseText);
                    }
		   	    }
     		    else
     		    {
     		        document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>";
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




/**
 This Function if for Checking the User Credentials

*/
function check_login_user() {

    /* get data from login form */
    var username=document.getElementById('login_username').value;
    var password=document.getElementById('login_password').value;

    var url = "http://localhost:8081/login/validate";
    var requestType = 'POST';
    var elementStatus = "login_loading";
    requestJSON = new LoginRequestBody(username,password);
    body = JSON.stringify(requestJSON);

    //Passing  responseFromLoginCheck as Callback function so as per the response this will get called and will take further action required
    SendHttpRequestAndReturnResponse(url, requestType, false, body, elementStatus, "Kuch Bhi nhi, abhi Generic h", false, null, responseFromLoginCheck);

}

/**
* This Function is to Toggle the State of the SubDiv in Registration form.
*
*/
function ToppleTheRegisterDiv(divName, heading) {
   var div = document.getElementById("RegisterDevId"+divName);
   if (div.style.display === "block") {
         div.style.display = "none";
         document.getElementById('RegisterDevButtonIcon'+divName).innerHTML='<i class="fa fa-plus" style="font-size:20px;color:white;vertical-align: middle;"> '+heading+'</i>';
       } else {
         div.style.display = "block";
         document.getElementById('RegisterDevButtonIcon'+divName).innerHTML='<i class="fa fa-minus" style="font-size:20px;color:white;vertical-align: middle;"> '+heading+'</i>';
       }
}

/**
* This Function is for Uploading Image
*/
function uploadAndShowImage(event,elementId, elementIdValue) {
    var image = document.getElementById(elementId);
	image.src = URL.createObjectURL(event.target.files[0]);
	document.getElementById(elementIdValue).value = "True";

}

/**
* these below function are used for Registration of User.
*/

class contactDetails {
    constructor() {

         }

    setEmailAddress(i_email) {
        this.emailAddress = i_email;
    }

    setPhone(i_phone) {
        this.phone = i_phone;
    }

}

class religiousDetails {
    constructor() {

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

class AddressDetails {
    constructor() {

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

    setCountry(i_country) {
        this.country = i_country;
    }

}

class RegisterDetails {
    constructor() {

    }

    SetContactDetails() {
        this.contact = new contactDetails();
    }

    SetReligiousDetails() {
         this.religious = new religiousDetails();
    }

    SetAddressDetails() {
         this.address = new AddressDetails();
    }

    setEmailAddress(i_email) {
        this.contact.emailAddress = i_email;
    }

    setPhone(i_phone) {
        this.contact.phone = i_phone;
    }

 //----------

    setReligion(i_religion) {
        this.religious.religion = i_religion;
    }

    setCaste(i_caste) {
        this.religious.caste = i_caste;
    }

    setSubCaste(i_subCaste) {
        this.religious.subCaste = i_subCaste;
    }


    //------

    setLocality(i_locality) {
        this.address.locality = i_locality;
    }

    setVillage(i_village) {
        this.address.village = i_village;
    }

    setDistrict(i_district) {
        this.address.district = i_district;
    }

    setState(i_state) {
        this.address.state = i_state;
    }

    setCountry(i_country) {
        this.address.country = i_country;
    }

 //-----------
    setUsername(i_username) {
        this.username = i_username;
    }

    setPassword(i_password) {
        this.password = i_password;
    }

    setFirstname(i_firstname) {
        this.firstname = i_firstname;
    }

    setLastname(i_lastname) {
        this.lastname = i_lastname;
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

}


function RegisterSubmitButton() {

    detailObject = new RegisterDetails();

    var _username = document.getElementById("register_username").value;
    var _password = document.getElementById("register_password").value;
    var _fname = document.getElementById("register_firstname").value;
    var _lname = document.getElementById("register_lastname").value;
    var _gender = document.getElementById("register_gender").value;
    var _dob = document.getElementById("register_dateOfBirth").value;
    var _email = document.getElementById("register_email").value;
    var _phone = document.getElementById("register_phone").value;
    var _religion = document.getElementById("register_Religion").value;
    var _locality = document.getElementById("register_Locality").value;
    var _subcaste = document.getElementById("register_subcaste").value;
    var _caste = document.getElementById("register_Caste").value;
    var _village = document.getElementById("register_Village").value;
    var _district = document.getElementById("register_District").value;
    var _state = document.getElementById("register_State").value;
    var _country = document.getElementById("register_Country").value;
    var _isFile = false;

    if(_username.length > 0)
        detailObject.username = _username;
    if(_password.length > 0)
        detailObject.password = _password;
    if(_fname.length > 0)
        detailObject.firstname = _fname;
    if(_lname.length > 0)
        detailObject.lastname = _lname;
    if(_gender.length > 0)
        detailObject.gender = _gender;
    if(_dob.length > 0)
        detailObject.dateofbirth = _dob;

    if(document.getElementById("getProfileImage").value.length > 0) {
        _isFile = true;
        var file = document.getElementById("getProfileImage").files[0];
        detailObject.profilepic = file.name;
    }

    if((_email != null && _email.length > 0) || (_phone != null && _phone.length > 0)) {

        detailObject.SetContactDetails();
        if(_email.length > 0)
            detailObject.setEmailAddress(_email);
        if(_phone.length > 0)
            detailObject.setPhone(_phone);
    }

    if((_religion !=null && _religion.length>0 ) || (_subcaste !=null && _subcaste.length>0 ) || (_caste !=null && _caste.length>0 )) {

        detailObject.SetReligiousDetails();
        if(_religion.length > 0)
        detailObject.setReligion(_religion);
        if(_caste.length > 0)
        detailObject.setCaste(_caste);
        if(_subcaste.length > 0)
        detailObject.setSubCaste(_subcaste);
    }

    if(( _locality !=null && _locality.length > 0 ) || ( _village !=null && _village.length > 0 ) || ( _district !=null && _district.length > 0 ) || ( _state !=null && _state.length > 0 ) || ( _country !=null && _country.length > 0 )) {

        detailObject.SetAddressDetails();

        if(_locality.length > 0)
            detailObject.setLocality(_locality);
        if(_village.length > 0)
            detailObject.setVillage(_village);
        if(_district.length > 0)
            detailObject.setDistrict(_district);
        if(_state.length > 0)
            detailObject.setState(_state);
        if(_country.length > 0)
            detailObject.setCountry(_country);
    }

    /*
    console.log("Here Mahesh Kasana");
    console.log(detailObject.profilepic);
    console.log(JSON.stringify(detailObject))
    */

    var urlFile = "http://localhost:8081/register/user/file";
    var url = "http://localhost:8081/register/user";
    var requestType = 'POST';
    var elementStatus = "loading_register";
    body = JSON.stringify(detailObject);
    if(_isFile)
        SendHttpRequestAndReturnResponse(urlFile, requestType, false, body, elementStatus, "Kuch Bhi nhi, abhi Generic h", true, file, responseFromRegisterRequest);
    else
        SendHttpRequestAndReturnResponse(url, requestType, false, body, elementStatus, "Kuch Bhi nhi, abhi Generic h", false, null, responseFromRegisterRequest);
}

/**
*
* Validation of the Resister Form.
*/

function validatePasswordToReEntred() {

    vpass = document.getElementById("register_verify_password");
    pass = document.getElementById("register_password");
    vset =  document.getElementById("valid_register_verify_password");

    if(vpass.value === pass.value) {
        vset.innerHTML = "<b>Re-Enter Password *</b>";
        vpass.style.borderColor="green";
        vpass.style.borderWidth="1px";
    } else {
        vset.innerHTML = "<b>Re-Enter Password *</b><b style='color:red;'> (Not Matched)</b>";
        vpass.style.borderColor="red";
        vpass.style.borderWidth="4px";
    }
}

function validateRegisterDate() {
    var d = document.getElementById("register_dateOfBirth").value;
    var d1 = new Date(d).getTime();
    var d2 = new Date().getTime();
    var ele = document.getElementById("register_dateOfBirth");
    vset =  document.getElementById("valid_register_dateOfBirth");
    if(d1 > d2) {
         ele.style.borderColor="red";
         ele.style.borderWidth="4px";
         vset.innerHTML = "<b>Date of Birth</b><b style='color:red;'> (Invalid)</b>";
    }  else {
       ele.style.borderColor="green";
       ele.style.borderWidth="1px";
       vset.innerHTML = "<b>Date of Birth</b>";
    }
}

function validateRegisterGender() {
     var d = document.getElementById("register_gender");
      vset =  document.getElementById("valid_register_gender");
     if(d.value == 0) {
           d.style.borderColor="red";
           d.style.borderWidth="4px";
           vset.innerHTML = "<b>Gender</b><b style='color:red;'> (Invalid)</b>";
     }
     else {
            d.style.borderColor="green";
            d.style.borderWidth="1px";
            vset.innerHTML = "<b>Gender</b>";
     }
}

function validateRegisterUsername() {
    var d = document.getElementById("register_username").value;
    var val = document.getElementById("valid_register_username");
    if(d.length < 5) {
         val.innerHTML =  "<b>Username *</b><b style='color:red;'> (Username should more than 6 char)</b>";
    } else {
        val.innerHTML = "<b>Username *</b>";
    }
}

function validateRegisterPassword() {
    var d = document.getElementById("register_password").value;
    var val = document.getElementById("valid_register_password");
    if(d.length < 5) {
         val.innerHTML =  "<b>Password *</b><b style='color:red;'> (Password should more than 6 char)</b>";
    } else {
        val.innerHTML = "<b>Password *</b>";
    }
}


function validateRegisterEmail() {
    var d = document.getElementById("register_email").value;
    var val = document.getElementById("valid_register_email");
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if(d.match(mailformat)) {
          val.innerHTML =  "<b>Email Address</b>";
    } else {
           val.innerHTML = "<b>Email Address</b><b style='color:red;'> (Invalid Email)</b>";
    }
}


function validateRegisterPhone() {
    var d = document.getElementById("register_phone").value;
    var val = document.getElementById("valid_register_phone");

    if(d.length == 10 && !isNaN(d)) {
          val.innerHTML =  "<b>Phone Number</b>";
    } else {
           val.innerHTML = "<b>Phone Number</b><b style='color:red;'> (Invalid Phone Number)</b>";
    }
}


/* Validation are finished here  */

