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
function uploadAndShowImage(event,elementId) {
    var image = document.getElementById(elementId);
	image.src = URL.createObjectURL(event.target.files[0]);
}


/**
* these below function are used for Registration of User.
*/

class RegisterDetails {
    constructor() {
        this._username = "";
        this._password = "";
        this._firstname = "";
        this._lastname = "";
        this._gender = 0;
        this._dateofbirth = "";
        this._profilepic = "";
    }

    set username(username) {
        this._username = username;
    }

    set password(password) {
        this._password = password;
    }

    set firstname(firstname) {
        this._firstname = firstname;
    }

    set lastname(lastname) {
        this._lastname = lastname;
    }

    set gender(gender) {
        this._gender = gender;
    }

    set dateofbirth(dateofbirth) {
        this._dateofbirth = dateofbirth;
    }

    set profilepic(profilepic) {
        this._profilepic = profilepic;
    }

    get username() {
            return this._username;
    }

    get password() {
        return this._password;
    }

    get firstname() {
        return this._firstname;
    }

    get lastname() {
        return this._lastname;
    }

    get gender() {
        return this._gender;
    }

    get dateofbirth() {
        return this._dateofbirth;
    }

    get profilepic() {
        return this._profilepic;
        }

}

function responseFromRegisterRequest(response) {

}

function RegisterSubmitButton() {

    detailObject = new RegisterDetails();
    detailObject.userName = document.getElementById("register_username").value;
    detailObject.password = document.getElementById("register_password").value;
    detailObject.firstname = document.getElementById("register_firstname").value;
    detailObject.lastname = document.getElementById("register_lastname").value;
    detailObject.gender = document.getElementById("register_gender").value;
    detailObject.dateofbirth = document.getElementById("register_dateOfBirth").value;
    var file = document.getElementById("getProfleImage").files[0];
    detailObject.profilepic = file.name;

    console.log("Here Mahesh Kasana");
    console.log(detailObject.profilepic);
    console.log(JSON.stringify(detailObject))


    var url = "http://localhost:8081/register/user";
    var requestType = 'POST';
    var elementStatus = "loading_register";
    body = JSON.stringify(detailObject);
    SendHttpRequestAndReturnResponse(url, requestType, false, body, elementStatus, "Kuch Bhi nhi, abhi Generic h", true, file, responseFromRegisterRequest);
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

    if(d.length == 10 ) {
          val.innerHTML =  "<b>Phone Number</b>";
    } else {
           val.innerHTML = "<b>Phone Number</b><b style='color:red;'> (Invalid Phone Number)</b>";
    }
}


