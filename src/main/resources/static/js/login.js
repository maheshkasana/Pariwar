class LoginRequestBody {
    constructor(username, password) {
            this.username = username;
            this.password = password;
    }
}

function sendHttpRequest()
{
    alert("in Sed HTTP");
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8081/index", false ); // false for synchronous request
    xmlHttp.send( null );
    alert(xmlHttp.responseText);
    return xmlHttp.responseText;
}


function responseFromLoginCheck(details)
{
    alert("In responseFromLoginCheck");
    alert(details);
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