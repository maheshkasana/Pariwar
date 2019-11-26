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


//check the login credentials
function check_login_user()
{
    /* get data from login form */
    var username=document.getElementById('login_username').value;
    var password=document.getElementById('login_password').value;
    var xhttp = new XMLHttpRequest();

    requestJSON = new LoginRequestBody(username,password);

    /*
    xhttp.onreadystatechange = function()
    {
  	    if(this.readyState<4)
  	    {
//  	   	document.getElementById('loading').innerHTML="<img src='img/loading3.gif' style='width:30%; height:100%; border-radius: 60%;'>";
  	    }
        else if(this.readyState==4)
            {
        	    if (this.status == 200)
    		    {
      		        if(this.responseText==1)
                    {
                        alert(this.responseText);
//                      document.getElementById('loading').innerHTML="<p style='color: green;'><b>Login successful, and im redirecting you wait......</b></p>";
                        setCookie(user_kno);
//                      window.location.href = "user_file.php";
                    }
                    else
                    {
                        alert(this.responseText);
//                      document.getElementById('loading').innerHTML="<p style='color: red;'><b>Kno or password doesnt existed</b></p>" ;
                    }
		   	    }
     		    else
     		    {
     		        alert(this.responseText);
//     		        document.getElementById('loading').innerHTML="<p style='color: red;'><b>Login Failed... </b></p>";

    		    }
		    }
    };
*/

  xhttp.open('POST', "http://localhost:8081/login/validate", false);
  xhttp.setRequestHeader("tokenfortesting","TokenForTesting");
  xhttp.setRequestHeader("Accept","application/json");
  xhttp.setRequestHeader("Content-Type","application/json");
  xhttp.send(JSON.stringify(requestJSON));
  alert(this.responseText);
  return this.responseText;
}