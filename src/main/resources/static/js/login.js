
class LoginRequestBody {
    constructor(username, password) {
            this.username = username;
            this.password = password;
    }
}

class LoginResponseBody {
    constructor(i_username, i_authKey, i_userId, i_status) {
        this.username = i_username;
        this.authKey = i_authKey;
        this.userId = i_userId;
        this.status = i_status;
    }
}


function TestsendHttpRequest()
{
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


function showCookies()
{
    alert("got Cookies username : "+ getCookie("username"));
    alert("got Cookies Token : "+ getCookie("authKey"));
    alert("got Cookies status : "+ getCookie("pariwarStatus"));
    alert("got Cookies id : "+ getCookie("userId"));

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
    var userName = getCookie("username");
    var token = getCookie("authKey");
    var status = getCookie("pariwarStatus");
    var id = getCookie("userId");
    if(userName!=null && userName.length > 0 && token!=null && token.length>0 && status==true && id>0)
        location.replace("http://localhost:8081/home?username="+userName+"&token="+token+"&userId="+id);
}


/**
*Call back Function for the Login validation check and it do redirect the as the the status.
*/
function responseFromLoginCheck(details)
{
    alert(details);
    var response = JSON.parse(details);
    if(response.status==true) {
        document.getElementById('login_loading').innerHTML="<p style='color: green;'><b>Login successful</b></p>";
        setCookie(response.username,response.authKey,response.userId,5*60);
        location.replace("http://localhost:8081/home?username="+response.username+"&token="+response.authKey+"&userId="+response.userId);
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




/**
 This Function if for Checking the User Credentials

*/
function check_login_user() {

    /* get data from login form */
    var username=document.getElementById('login_username').value;
    var password=btoa(document.getElementById('login_password').value);

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

function resetDetailsAndGoBackToMainAfterRegistreation() {

    //location.replace("http://localhost:8081");
    return ;
}


function responseFromRegisterRequest(response) {
     var resp = JSON.parse(response);
     var userId = resp.statusCode;
     var errorCode = resp.errorCode;
     var errorMsg = resp.errorMessage;

     if(0 >= userId) {
        alert("Failed to Register, Retry after sometime");
     } else {
        document.getElementById('RegistredSuccessful').style.display='block';
        document.getElementById('username_RegistredSuccessful').innerHTML = "Username : <b><u>" + document.getElementById('register_username').value + "</u></b>";
        //resetDetailsAndGoBackToMainAfterRegistreation(userId);
     }
}


function RegisterSubmitButton() {

    detailObject = new RegisterDetails();

    //username
    var status = new userNameStatusCode();
    var usernameEle = document.getElementById("register_username");
    if(usernameEle.name != status.GETAVAILABLE()) {
        alert("Invalid Or Already Used username, please Validate");
        return;
    }
    detailObject.username = usernameEle.value;

    //Password
    var passEle = document.getElementById("register_password");
    if(passEle.name != status.GETVALID()) {
         alert("Invalid Or Password Does not Match");
         return;
    }
    detailObject.password = btoa(passEle.value);

    //First Name + Last Name
    var _fname = document.getElementById("register_firstname").value;
    if(_fname == null || _fname.length <=0) {
        alert("First Name Cannot be Empty");
        return;
    }

    //last name
    var _lname = document.getElementById("register_lastname").value;
    if(_lname != null && _lname.length >0) {
        _fname += " "+_lname;
    }
    detailObject.firstname = _fname;


    // Gender
    detailObject.gender = document.getElementById("register_gender").value;

    //Date of Birth
    var dobEle = document.getElementById("register_dateOfBirth");
    detailObject.dateofbirth = dobEle.value;


    //profile pic
    var _isFile = false;

    if(document.getElementById("getProfileImage").value.length > 0) {
        _isFile = true;
        var file = document.getElementById("getProfileImage").files[0];
        detailObject.profilepic = file.name;
    }

    //Email
    var _email = null;
    var emailEle =  document.getElementById("register_email");
    if(emailEle.name != -1) {
       if(emailEle.name != status.GETVALID()) {
             alert("Invalid Email, please correct");
             return;
       }
       _email = emailEle.value;
    }

    //Phone Number
    var _phone = document.getElementById("register_phone").value;
    if(_phone !=null && _phone.length!=0 && _phone.length !=10) {
        alert("Please Enter Valid Phone number");
        return;
    }
    detailObject.SetContactDetails( new contactDetails(_email, _phone));


    //Religion related
    var _religion = document.getElementById("register_Religion").name;
    var _subcaste = 0;
    var _caste = 0;
    if(_religion > 0) {
        _caste = document.getElementById("register_Caste").name;
        if(_caste > 0)
        {
            _subcaste = document.getElementById("register_SubCaste").name;
        }
    }
    detailObject.SetReligiousDetails( new religiousDetails(_religion,_caste, _subcaste));

    var _locality = document.getElementById("register_Locality").value;
    var _state = document.getElementById("register_State").name;
    var _village = 0;
    var _district = 0;
    var _tehsil = 0;
    if(_state > 0) {
        _district = document.getElementById("register_District").name;
        if(_district > 0) {
            _tehsil = document.getElementById("register_Tehsil").name;
            if(_tehsil > 0) {
                _village = document.getElementById("register_Village").name;
            }
        }
    }
    detailObject.SetAddressDetails(new AddressDetails(_locality, _village, _tehsil, _district, _state));


    var urlFile = "http://localhost:8081/register/user/file";
    var url = "http://localhost:8081/register/user";
    var requestType = 'POST';
    var elementStatus = "loading_register";
    body = JSON.stringify(detailObject);
    console.log(body);
    if(_isFile)
        SendHttpRequestAndReturnResponse(urlFile, requestType, false, body, elementStatus, "", true, file, responseFromRegisterRequest);
    else
        SendHttpRequestAndReturnResponse(url, requestType, false, body, elementStatus, "", false, null, responseFromRegisterRequest);
}

/**
*
* Validation of the Resister Form.
*/

function validatePasswordToReEntred() {

    vpass = document.getElementById("register_verify_password");
    pass = document.getElementById("register_password");
    vset =  document.getElementById("valid_register_verify_password");

    var status = new userNameStatusCode();

    if(vpass.value === pass.value) {
        vset.innerHTML = "<b>Re-Enter Password *</b>";
        vpass.style.borderColor="green";
        vpass.style.borderWidth="1px";
        pass.name = status.GETVALID();
    } else {
        vset.innerHTML = "<b>Re-Enter Password *</b><b style='color:red;'> (Not Matched)</b>";
        vpass.style.borderColor="red";
        vpass.style.borderWidth="4px";
        pass.name = status.GETINVALID();
    }
}

function validateRegisterDate() {
    var status = new userNameStatusCode();
    var d = document.getElementById("register_dateOfBirth").value;
    var d1 = new Date(d).getTime();
    var d2 = new Date().getTime();
    var ele = document.getElementById("register_dateOfBirth");
    vset =  document.getElementById("valid_register_dateOfBirth");
    if(d1 > d2) {
         ele.style.borderColor="red";
         ele.style.borderWidth="4px";
         vset.innerHTML = "<b>Date of Birth</b><b style='color:red;'> (Invalid)</b>";
         ele.name = status.GETINVALID();
    }  else {
       ele.style.borderColor="green";
       ele.style.borderWidth="1px";
       vset.innerHTML = "<b>Date of Birth</b>";
       ele.name = status.GETVALID();
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



class userNameStatusCode {

    constructor() {
        this.INVALID = 0;
        this.VALID = 1;
        this.AVAILABLE = 2;
        this.ALREDYUSED = 3;
        this.FAILED = 4;
    }


    GETINVALID() {
        return this.INVALID;
    }

    GETVALID() {
         return this.VALID;
    }

    GETAVAILABLE() {
         return this.AVAILABLE;
    }

    GETALREDYUSED() {
        return this.ALREDYUSED;
    }

    GETFAILED() {
        return this.FAILED;
    }

}

function validateRegisterUsername() {
    var status = new userNameStatusCode();
    var d = document.getElementById("register_username").value;
    var val = document.getElementById("valid_register_username");
    if(d.length < 5) {
         val.innerHTML =  "<b>Username *</b><b style='color:red;'> (Username should more than 6 char)</b>";
         document.getElementById("register_username").name = status.GETINVALID();
    } else {
        val.innerHTML = "<b>Username *</b>";
        document.getElementById("register_username").name = status.GETVALID();
    }
}
var status = new userNameStatusCode();
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
    var ele = document.getElementById("register_email");
    var val = document.getElementById("valid_register_email");
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var d = ele.value;
    var status = new userNameStatusCode();

    if(d.match(mailformat)) {
          val.innerHTML =  "<b>Email Address</b>";
          ele.name = status.GETVALID();
    } else {
           val.innerHTML = "<b>Email Address</b><b style='color:red;'> (Invalid Email)</b>";
           ele.name = status.GETINVALID();
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

/** Search Tab Function() */

function searchUser() {

    var _state = document.getElementById("search_State").value;
    var _district = document.getElementById("search_District").value;
    var _village = document.getElementById("search_Village").value;
    var _name = document.getElementById("search_Name").value;

    if(_name.length <= 0 ) {
        document.getElementById("valid_search_Name").innerHTML = "<b>Name *</b><b style='color:red;'> (Name required)</b>";
        return;
    } else {
        document.getElementById("valid_search_Name").innerHTML = "<b>Name *</b>";
    }
}


class DivPositionOnScreen {
    constructor(left_i,top_i,right_i, bottom_i) {
        this.left = left_i;
        this.top = top_i;
        this.right = right_i;
        this.bottom = bottom_i;
    }
}

class arrClassInout {
    constructor(name_i, value_i) {
    this.name = name_i;
    this.value = value_i;
    }
}

function getPositionOfDivInScreen(element) {
    var element = document.getElementById(element); //replace elementId with your element's Id.
    var rect = element.getBoundingClientRect();
    var elementLeft,elementTop,elementRight,elementBottom; //x and y
    var scrollTop = document.documentElement.scrollTop?
                document.documentElement.scrollTop:document.body.scrollTop;
    var scrollLeft = document.documentElement.scrollLeft?
                 document.documentElement.scrollLeft:document.body.scrollLeft;

    elementTop = rect.top+scrollTop;
    elementLeft = rect.left+scrollLeft;
    elementRight =  rect.right;
    elementBottom =  rect.bottom;

    return new DivPositionOnScreen(elementLeft, elementTop, elementRight, elementBottom);
}




/********//////////***********///////////********//////////***********///////////***************//////////***********///////////***************//////////***********///////////*******/
/*--------Start----------*/
/* This Function is to generate list as per the user type, drop down and we can see the selected and Id in name of the Input*/
function registerAutoCompleteGenericFunction(inp, arr, pos) {

  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
   function addEventListenerFunction(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();

      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      a.setAttribute("z-index","5");
      a.style.position = "absolute";
      a.style.left = pos.left+'px';
      a.style.top = pos.bottom+'px';
      a.style.width = inp.offsetWidth+'px';
      a.style.maxHeight = inp.offsetWidth+'px';
      a.style.overflow = 'auto';
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);

      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (val == null || val.length == 0 || arr[i].name.substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          if(val != null) {
            b.innerHTML = "<strong>" + arr[i].name.substr(0, val.length) + "</strong>";
            b.innerHTML += arr[i].name.substr(val.length);
          } else {
            b.innerHTML = arr[i].name;
          }
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i].name + "' name='"+ arr[i].value +"' style='border: 1px solid transparent; background-color: #eeeeee; padding: 10px; font-size: 16px;'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              inp.name = this.getElementsByTagName("input")[0].name;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  }

  inp.addEventListener("input", addEventListenerFunction);
  inp.addEventListener("click", addEventListenerFunction);

  /*execute a function presses a key on the keyboard:*/
   function addEventListenerFunctionTwo(e) {

      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  }

  inp.addEventListener("keydown",addEventListenerFunctionTwo);

  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
  addEventListenerFunction(null);
}


/*--------End----------*/

function resetReligionLowerDetailsIfChanged(val) {

    if(3 <= val) {
        ele = document.getElementById("register_Religion");
        ele.value = "";
        ele.name = 0;
    }

    if(2 <= val) {
        ele = document.getElementById("register_Caste");
        ele.value = "";
        ele.name = 0;
    }

    if(1 <= val) {
        ele = document.getElementById("register_SubCaste");
        ele.value = "";
        ele.name = 0;
    }
}

function processAutoSuggestRegisterReligion(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].religionName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_Religion");
    registerAutoCompleteGenericFunction(document.getElementById("register_Religion"), listClassObjects, pos);
}

function autoSuggestRegisterReligion() {

     var url = "http://localhost:8081/register/auto/allReligions";
     var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterReligion);
}



function processAutoSuggestRegisterCaste(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].userCasteName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_Caste");
    registerAutoCompleteGenericFunction(document.getElementById("register_Caste"), listClassObjects, pos);
}

function autoSuggestRegisterCaste() {

    ele = document.getElementById("register_Religion");
    vset =  document.getElementById("valid_register_Religion");

    religionId = ele.name;

    if(religionId <= 0 || religionId.length <= 0) {
        ele.style.borderColor="red";
        ele.style.borderWidth="2px";
        vset.innerHTML = "<b>Religion</b><b style='color:red;'> (Please Select)</b>";
        return;
    } else {
        ele.style.borderColor="#d0d0d0";
        ele.style.borderWidth="1px";
        vset.innerHTML = "<b>Religion</b>";
    }

    var url = "http://localhost:8081/register/auto/religionAllCaste/" + religionId +";";
    var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterCaste);
}




function processAutoSuggestRegisterSubCaste(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].userSubCasteName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_SubCaste");
    registerAutoCompleteGenericFunction(document.getElementById("register_SubCaste"), listClassObjects, pos);
}

function autoSuggestRegisterSubCaste() {

    ele = document.getElementById("register_Caste");
    vset =  document.getElementById("valid_register_Caste");

    casteId = ele.name;

    if(casteId <= 0 || casteId.length <= 0) {
        ele.style.borderColor="red";
        ele.style.borderWidth="2px";
        vset.innerHTML = "<b>Caste</b><b style='color:red;'> (Please Select)</b>";
        return;
    } else {
        ele.style.borderColor="#d0d0d0";
        ele.style.borderWidth="1px";
        vset.innerHTML = "<b>Caste</b>";
    }

    var url = "http://localhost:8081/register/auto/casteAllSubCaste/" + casteId +";";
    var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterSubCaste);
}


function resetAddressLowerDetailsIfChanged(val) {

    if(4 <= val) {
        ele = document.getElementById("register_State");
        ele.value = "";
        ele.name = 0;
    }

    if(3 <= val) {
        ele = document.getElementById("register_District");
        ele.value = "";
        ele.name = 0;
    }

    if(2 <= val) {
        ele = document.getElementById("register_Tehsil");
        ele.value = "";
        ele.name = 0;
    }

    if(1 <= val) {
        ele = document.getElementById("register_Village");
        ele.value = "";
        ele.name = 0;
    }

}

function processAutoSuggestRegisterState(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].stateName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_State");
    registerAutoCompleteGenericFunction(document.getElementById("register_State"), listClassObjects, pos);
}

function autoSuggestRegisterState() {

     var url = "http://localhost:8081/register/auto/allStates";
     var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterState);
}




function processAutoSuggestRegisterDistrict(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].districtCode;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_District");
    registerAutoCompleteGenericFunction(document.getElementById("register_District"), listClassObjects, pos);
}

function autoSuggestRegisterDistrict() {

    ele = document.getElementById("register_State");
    vset =  document.getElementById("valid_register_State");

    stateId = ele.name;

    if(stateId <= 0 || stateId.length <= 0) {
        ele.style.borderColor="red";
        ele.style.borderWidth="2px";
        vset.innerHTML = "<b>State</b><b style='color:red;'> (Please Select)</b>";
        return;
    } else {
        ele.style.borderColor="#d0d0d0";
        ele.style.borderWidth="1px";
        vset.innerHTML = "<b>State</b>";
    }

    var url = "http://localhost:8081/register/auto/districtByStateId/" + stateId +";";
    var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterDistrict);
}




function processAutoSuggestRegisterTehsil(data) {
    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].tehsilName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_Tehsil");
    registerAutoCompleteGenericFunction(document.getElementById("register_Tehsil"), listClassObjects, pos);
}

function autoSuggestRegisterTehsil() {

    ele = document.getElementById("register_District");
    vset =  document.getElementById("valid_register_District");

    districtId = ele.name;

    if(districtId <= 0 || districtId.length <= 0) {
        ele.style.borderColor="red";
        ele.style.borderWidth="2px";
        vset.innerHTML = "<b>District</b><b style='color:red;'> (Please Select)</b>";
        return;
    } else {
        ele.style.borderColor="#d0d0d0";
        ele.style.borderWidth="1px";
        vset.innerHTML = "<b>District</b>";
    }

    var url = "http://localhost:8081/register/auto/allTehsilByDistrictId/" + districtId +";";
    var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterTehsil);
}



function processAutoSuggestRegisterVillage(data) {

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(data);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].villageTownLocalAreaName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("register_Village");
    registerAutoCompleteGenericFunction(document.getElementById("register_Village"), listClassObjects, pos);
}

function autoSuggestRegisterVillage() {

    ele = document.getElementById("register_Tehsil");
    vset =  document.getElementById("valid_register_Tehsil");

    tehsilId = ele.name;

    if(tehsilId <= 0 || tehsilId.length <= 0) {
        ele.style.borderColor="red";
        ele.style.borderWidth="2px";
        vset.innerHTML = "<b>SubDistrict/Tehsil/City</b><b style='color:red;'> (Please Select)</b>";
        return;
    } else {
        ele.style.borderColor="#d0d0d0";
        ele.style.borderWidth="1px";
        vset.innerHTML = "<b>SubDistrict/Tehsil/City</b>";
    }

    var url = "http://localhost:8081/register/auto/allVillageTownByTehsilId/" + tehsilId +";";
    var requestType = 'GET';

    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processAutoSuggestRegisterVillage);
}


//*********//////////*********//////////*********//////////*********//////////*********/

class ReturnStatus {
    constructor(status, msg, error) {
        this.statusCode = status;
        this.errorMessage = msg;
        this.errorCode = error;
    }

}


function processCheckUsernameAvailable(data) {

    var obj = JSON.parse(data);
    var returnStatus = new ReturnStatus(obj.statusCode, obj.errorMessage, obj.errorCode);
    var ele = document.getElementById("register_username");
    var ValEle = document.getElementById("valid_register_username");
    var status = new userNameStatusCode();


    if(returnStatus.statusCode == status.GETAVAILABLE()) {
        ValEle.innerHTML =  "<b>Username *</b><b style='color:green;'> (Available)</b>";
        ele.name = status.GETAVAILABLE();
        return;
    }

    if(returnStatus.statusCode == status.GETALREDYUSED()) {
        ValEle.innerHTML =  "<b>Username *</b><b style='color:red;'> (Not Available)</b>";
        ele.name = status.GETALREDYUSED();
        return;
    }

    if(returnStatus.statusCode == status.GETFAILED()) {
        ValEle.innerHTML =  "<b>Username *</b><b style='color:red;'> (Retry Availability)</b>";
        ele.name = status.GETFAILED();
        return;
    }
}


function checkUsernameAvailable() {

    var status = new userNameStatusCode();
    var ele =  document.getElementById("register_username");
    if(status.GETINVALID() == ele.name) {
            validateRegisterUsername();
            return;
    }

    var username = ele.value;
    var url = "http://localhost:8081/register/auto/validateAvailabilityUsername/" + username +";";
    var requestType = 'GET';
    SendHttpRequestAndReturnResponse(url, requestType, false, "", "", "No", false, null, processCheckUsernameAvailable);
}