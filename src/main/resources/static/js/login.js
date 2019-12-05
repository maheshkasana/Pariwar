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

function checkIfAlreadyLoggedIn() {
    var userName = getCookie("pariwarUsername");
    var token = getCookie("pariwarToken");
    var status = getCookie("pariwarStatus");
    var id = getCookie("pariwarId");

    //if(userName!=null && userName.length > 0 && token!=null && token.length>0 && status==true && id>0)
        //location.replace("http://localhost:8081/home?username="+userName+"&token="+token+"&userId="+id);
}

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

//check the login credentials
function check_login_user()
{
    /* get data from login form */
    var username=document.getElementById('login_username').value;
    var password=document.getElementById('login_password').value;
    var xhttp = new XMLHttpRequest();

    requestJSON = new LoginRequestBody(username,password);

    xhttp.onreadystatechange = function()
    {
  	    if(this.readyState<4)
  	    {
     	   	document.getElementById('login_loading').innerHTML="<img src='images/loading3.gif' style='width:30%; height:100%; border-radius: 60%;'>";
  	    }
        else if(this.readyState==4)
            {
        	    if (this.status == 200)
    		    {
      		        if(this.responseText==1)
                    {
                        document.getElementById('login_loading').innerHTML="<p style='color: green;'><b>Login successful</b></p>";
                        responseFromLoginCheck(this.responseText);
                    }
                    else
                    {
                        document.getElementById('login_loading').innerHTML="<p style='color: red;'><b>Failed to validate</b></p>" ;
                        responseFromLoginCheck(this.responseText);
                    }
		   	    }
     		    else
     		    {
     		        document.getElementById('login_loading').innerHTML="<p style='color: red;'><b>Login Failed... </b></p>";
    		    }
		    }
    };

    xhttp.open('POST', "http://localhost:8081/login/validate", true);
    xhttp.setRequestHeader("tokenfortesting","TokenForTesting");
    xhttp.setRequestHeader("Accept","application/json");
    xhttp.setRequestHeader("Content-Type","application/json");
    xhttp.send(JSON.stringify(requestJSON));
    //location.replace("http://localhost:8081/index")
    return this.responseText;
}


/**
* This Function is to Toggle the State of the SubDiv in Registration form.
*
*/
function ToppleTheRegisterDiv(divName) {
   var div = document.getElementById("RegisterDevId"+divName);
   if (div.style.display === "block") {
         div.style.display = "none";
         document.getElementById('RegisterDevButtonIcon'+divName).innerHTML='<i class="fa fa-plus" style="font-size:20px;color:white;vertical-align: middle;">      Personal Details</i>'
       } else {
         div.style.display = "block";
         document.getElementById('RegisterDevButtonIcon'+divName).innerHTML='<i class="fa fa-minus" style="font-size:20px;color:white;vertical-align: middle;">      Personal Details</i>'
       }
}