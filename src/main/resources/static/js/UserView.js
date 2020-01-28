
class user {
  constructor(name_, gender_, id_) {
  this.name = name_;
  this.gender= gender_;
  this.id = id_;
  }
}

class userLoggedIn {
  constructor(username_, token_, id_) {
  this.username = username_;
  this.token= token_;
  this.id = id_;
  }
}


/*=============================================================*/

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


function checkIfNotLoggedInToSignIn() {
    var userName = getCookie("username");
    var token = getCookie("authKey");
    var status = getCookie("pariwarStatus");
    var id = getCookie("userId");
    if(userName == null || token==null || id<=0) {
        location.replace("http://localhost:8081/");
    } else {
        var loggedInUser = new userLoggedIn(userName,token,id);
        ShowDetailsOfUser(token);
    }
}


/*================================================================*/

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




/*===========================================================*/

function getUserDetails() {
  user = new user("Mahesh", "Male", 1);
  return user;
}


function getParents()
{
  var lst = [];
  lst.push(new user("Vinodi Lal", "Male", 2));
  lst.push(new user("Prem", "Female", 3));
  return lst;
}

function getChilds() {
  var lst = [];
  lst.push(new user("Ram", "Male", 4));
  lst.push(new user("Shayam", "Male", 5));
  lst.push(new user("Seeta", "Female", 6)); 
  lst.push(new user("Ram", "Male", 4));
  lst.push(new user("Shayam", "Male", 5));
  lst.push(new user("Seeta", "Female", 6)); 
  lst.push(new user("Ram", "Male", 4));
  lst.push(new user("Shayam", "Male", 5));
  lst.push(new user("Seeta", "Female", 6)); 
  lst.push(new user("Ram", "Male", 4));
  lst.push(new user("Shayam", "Male", 5));
  lst.push(new user("Seeta", "Female", 6)); 
  return lst;
}

function getSiblings() {
  var lst = [];
  lst.push(new user("Mahesh", "Male", 9)); 
  lst.push(new user("Sapna", "Female", 7));
  lst.push(new user("Suman", "Female", 8));
  lst.push(new user("Kiran", "Female", 10)); 
  return lst;
}

function isLaptop() {
  var wdth = screen.width;
  if(wdth > 700)
    return true;
  else return false;
}

function getLeftMarginForFirst(wdth, lst) {
  var n = 100/wdth;
  if(lst >= n-1)
    return 0;
  return (100 - (lst*wdth))/2;
}

function getNewDiv(wdth,className,Id,leftPer,firstname, sex, age, imgSrc, bckcolor, brdcolor) {
  var divv = "<div class="+ className +" id="+ Id +" style='margin-left: "+ leftPer +"%;  width: "+wdth+"%; height: 100%; background-color:"+bckcolor+"; float: left; border: 5px solid "+brdcolor+"; border-radius: 10px; vertical-align: middle; position: relative;'>";
        divv += "<div style='height: 75%;'><img src='"+imgSrc+"' alt='"+firstname+"' style='width: 100%; height: 100%;'></div>";
        divv += "<div style='height: 20%; text-align: center; font-size: 16px;'><b><p style='margin:0px;'>"+firstname+"</p></b><p style='margin:0px;'>"+sex+"/"+age+"</p></div>"; 
      divv +="</div>";
  return divv;
}


function AddTheDetailsASperTheListPassedAndtoDivId(userId,prntList, DivId, male) {
  var wdth = 20;
  if(isLaptop())
    wdth = 10;

  var lftmargin = 0;
  lftmargin = getLeftMarginForFirst(wdth,prntList.length);

  var node = document.getElementById(DivId);
  var index = 1;

  var flag = false;
  for(index = 1; index <= prntList.length; index++) {
    
    var brdcolor = "#f2f2f2";
    if(userId == prntList[index-1].id)
       brdcolor = "#FFD700";

    if(flag)
      lftmargin = 0;
    else
      node.innerHTML = "";

    if(prntList[index-1].gender == "Male")
      node.innerHTML += getNewDiv(wdth,DivId+index,DivId+index,lftmargin,prntList[index-1].name, "M", 24, male, "#929292", brdcolor);
    else
      node.innerHTML += getNewDiv(wdth,DivId+index,DivId+index,lftmargin,prntList[index-1].name, "F", 20, "images/female.svg", "#929292", brdcolor);

    flag = true;

  }
}

function OnClickAddTheDetails(userId) {
  //Add Parent
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getParents(), "UserParentDiv", "images/man.svg");
  //Add Siblings and same
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getSiblings(), "UserSiblingDiv", "images/male.svg");
  //Add Childs
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getChilds(), "UserChildDiv", "images/male.svg");
  //Add Childs

  }

function getUserDetailsByTokenAndValidate(response) {
    alert(response);
    if(response == null) {
        checkIfNotLoggedInToSignIn();
    }
}

function UserParentsShowInUI(response) {
    alert("In UserParentsShowInUI");
    alert(response);
}

function UserSiblingsAndShowInUI(response) {
    alert("In UserSiblingsAndShowInUI");
    alert(response);
}

function UserChildernsAndShowInUI(response) {
    alert("In UserChildernsAndShowInUI");
    alert(response);
}


function ShowDetailsOfUser(token) {

    //Validate User Details in DB
    SendHttpRequestAndReturnResponse("http://localhost:8081/user/details/" + token +";", "GET", false, "", "", "No", false, null, getUserDetailsByTokenAndValidate);

    SendHttpRequestAndReturnResponse("http://localhost:8081/user/parent/basic/" + token +";", "GET", false, "", "", "No", false, null, UserParentsShowInUI);
    SendHttpRequestAndReturnResponse("http://localhost:8081/user/siblings/details/" + token +";", "GET", false, "", "", "No", false, null, UserSiblingsAndShowInUI);
    SendHttpRequestAndReturnResponse("http://localhost:8081/user/childerns/details/" + token +";", "GET", false, "", "", "No", false, null, UserChildernsAndShowInUI);
}


