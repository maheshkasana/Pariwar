
class user {
  constructor(name_, gender_, id_, dob_, religious_, address_) {
  this.name = name_;
  this.gender= gender_;
  this.id = id_;
  this.isSpouse = 0;
  this.dob = dob_;
  this.religious = religious_;
  this.address = address_;
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

function setCookieEmptyLogOut() {
  var cookiesString= "userId='', username='', authKey='', '', pariwarStatus=1";
  document.cookie = cookiesString;
  location.replace("http://localhost:8081/");
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

function checkIfNotLoggedInToSignIn() {
    var userName = getCookie("username");
    var token = getCookie("authKey");
    var status = getCookie("pariwarStatus");
    var id = getCookie("userId");
    if(userName == null || token==null || id<=0) {
        location.replace("http://localhost:8081/");
    } else {
        ShowDetailsOfUser(id);
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

/*---------START of the function Send HTTP request and return -----------*/

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
                        result = null;
                       // callback(this.responseText);
                    }
		   	    }
     		    else
     		    {
     		        if(elementStatus.length > 0 && elementStatus != null) {
     		            document.getElementById(elementStatus).innerHTML="<p style='color: red;'><b>Failed</b></p>";
     		        }
     		        flag = true;
     		        result = null;
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


/*---------End of the function Send HTTP request and return -----------*/




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

function getNewDiv(wdth,className,Id,leftPer,firstname, sex, age, imgSrc, bckcolor, brdcolor,imgPath, userId, hght, toptr, religious, address) {

  var divv = "<a onclick='ShowDetailsOfUser("+userId+");' style='margin-left: "+ leftPer +"%; width:"+ wdth +"%; min-width:100px; height:98%;'>" +
                "<div class="+ className +" id="+ Id +" style='  width: 100%; height: " + hght + "%; top: "+ toptr +"%; background-color:#ffffff; float: left; border: 5px solid "+brdcolor+"; border-radius: 10px; vertical-align: middle; position: relative;'>" +
                    "<div style='height: 100%; width:100%;' class='container'>" +
                        "<img src='"+imgPath+"' alt='"+firstname+"' style='width: 100%; height: 100%;'>" +
                        "<div class='overlay'>" +
                            "<div class='text'>" +
                                "<p style='font-size: 14px;'> <u>" + firstname + "</u><br>" + sex + "/" + age + "<br>" + religious + "<br>" + address + "</p>" +
                            "</div>" +
                        "</div>" +
                    "</div>" +
                "</div>" +
             "</a>";
  return divv;
}

function AddTheDetailsASperTheListPassedAndtoDivId(userId,respList, DivId, male, spouse) {
  var wdth = 20;
  if(isLaptop())
    wdth = 10;

  spouseLst = [];
  prntList = [];
  if(spouse == 1) {
    spouseLst = convertResponseToUserList(SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/spouse/basic/" + userId +";", "GET", false, "", "", "No", false, null));
  }

  for(i = 0; i < respList.length; i++) {
    prntList.push(respList[i]);
    if(respList[i].id == userId) {
        for(j = 0; j < spouseLst.length; j++) {
            spouseLst[j].isSpouse = 1;
            prntList.push(spouseLst[j]);
        }
    }
  }

  var lftmargin = 0;
  lftmargin = getLeftMarginForFirst(wdth,prntList.length);

  var node = document.getElementById(DivId);
  var index = 1;
  node.innerHTML = "";
  var flag = false;

  for(index = 1; index <= prntList.length; index++) {

    var hght = 100;

    var brdcolor = "#f2f2f2";
    if(userId == prntList[index-1].id)
       brdcolor = "#FFD700";
    if(prntList[index-1].isSpouse == 1) {
        brdcolor = "#000086";
        hght = 90;
     }

    var imgPath =  "images/userProfilePics/userProfilePic_"+prntList[index-1].id+".jpg";

    if(flag)
      lftmargin = 0;
    else
      node.innerHTML = "";
    var age_ = parseInt(moment().diff(prntList[index-1].dob,'years',true));
    if(prntList[index-1].gender == "Male")
      node.innerHTML += getNewDiv(wdth,DivId+index,DivId+index,lftmargin,prntList[index-1].name.split(" ")[0], "M",age_ , male, "#929292", brdcolor,imgPath,prntList[index-1].id, hght, 100-hght, prntList[index-1].religious, prntList[index-1].address);
    else
      node.innerHTML += getNewDiv(wdth,DivId+index,DivId+index,lftmargin,prntList[index-1].name.split(" ")[0], "F", age_, "images/female.svg", "#929292", brdcolor,imgPath,prntList[index-1].id, hght, 100-hght, prntList[index-1].religious, prntList[index-1].address);

    flag = true;

  }
}

function OnClickAddTheDetails(userId) {
  //Add Parent
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getParents(), "UserParentDiv", "images/man.svg", 0);
  //Add Siblings and same
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getSiblings(), "UserSiblingDiv", "images/male.svg", 0);
  //Add Childs
  AddTheDetailsASperTheListPassedAndtoDivId(userId, getChilds(), "UserChildDiv", "images/male.svg", 0);
  //Add Childs

  }

function getUserDetailsByTokenAndValidate(response) {
    if(response == null) {
        checkIfNotLoggedInToSignIn();
    }
}


function convertResponseToUser(response) {
    var name;
    var userId;
    var gender;
    var dob;
    var caste;
    var subCaste;
    var district;
    var village;

    try { name = response.firstname; } catch(err) { name = "" }
    try { userId = response.userId; } catch(err) { userId = -1 }
    try { gender = response.gender; } catch(err) { gender = "M" }
    try { dob = response.dateofbirth; } catch(err) { dob = "1995-07-03" }
    try { caste = response.userReligiousDetails.caste.userCasteName.split(" ")[0]; } catch(err) {  caste = null }
    try { subCaste = response.userReligiousDetails.subCaste.userSubCasteName.split(" ")[0]; } catch(err) { subCaste = null }
    try { district = response.userAddressDetails.district.districtCode.split(" ")[0]; } catch(err) { district = null }
    try { village = response.userAddressDetails.villageTown.villageTownLocalAreaName.split(" ")[0]; } catch(err) { village = null }

    var rl = "";
    if(subCaste != null || caste != null) {
        if(subCaste != null && caste != null) {
            rl = subCaste + "/" + caste;
        } else {
            if(subCaste == null) {
                rl =  caste;
            } else {
                rl = subCaste;
            }
        }
    }

    var ad = "";

    if(village != null || district != null) {
        if(village != null && district != null) {
            ad = village + "/" + district;
        } else {
            if(village == null) {
                ad =  district;
            } else {
                ad = village;
            }
        }
    }


    if(gender == 1)
        return new user(name, "Male", userId, dob, rl, ad);
    else
        return new user(name, "Female", userId, dob, rl, ad);
}

function convertResponseToUserList(str_response) {
    response = JSON.parse(str_response);
    var Lst = [];
    for(i in response) {
        Lst.push(convertResponseToUser(response[i]));
    }
    return Lst;
}

function ShowDetailsOfUser(id) {
    //Validate User Details in DB
    user_ = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/details/" + id +";", "GET", false, "", "", "No", false, null);
    getUserDetailsByTokenAndValidate(user_);

    parentLst = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/parent/basic/" + id +";", "GET", false, "", "", "No", false, null);
    AddTheDetailsASperTheListPassedAndtoDivId(id, convertResponseToUserList(parentLst), "UserParentDiv", "images/man.svg", 0);

    SiblinsLst = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/siblings/basic/" + id +";", "GET", false, "", "", "No", false, null);
    AddTheDetailsASperTheListPassedAndtoDivId(id, convertResponseToUserList(SiblinsLst), "UserSiblingDiv", "images/male.svg", 1);

    ChildsList = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/childs/basic/" + id +";", "GET", false, "", "", "No", false, null);
    AddTheDetailsASperTheListPassedAndtoDivId(id, convertResponseToUserList(ChildsList), "UserChildDiv", "images/male.svg", 0);
}


