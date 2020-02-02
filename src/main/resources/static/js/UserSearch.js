
/* ----- Start Global Variable ---*/
var lastListUsers = 0;
/* ----- End Global Variable ---*/



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

function UpdateProfileSubmitButton() {
    alert("Mahesh Kasana, here wait for 10 sec");
    wait(10000);
    alert("Mahesh Kasana, After");

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
        //location.replace("http://localhost:8081/");
    }
}


/********//////////***********///////////********//////////***********///////////***************//////////***********///////////***************//////////***********///////////*******/
/*--------Start----------*/


function registerAutoCompleteGenericFunction(inp, arr, pos) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      a.setAttribute("z-index","5");
      a.style.position = "absolute";
      a.style.left = (pos.left-15)+'px';
      a.style.top = (pos.top-35)+'px';
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
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
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
  });
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
}

function wait(ms)
{
    var d = new Date();
    var d2 = null;
    do { d2 = new Date(); }
    while(d2-d < ms);
}


/*--------End of Auto List----------*/


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




/** Function to reset the Below thing if we are chagnes upper in Address details */
function resetAddressLowerDetailsIfChanged(val) {

    if(4 <= val) {
        ele = document.getElementById("search_state");
        ele.value = "";
        ele.name = 0;
    }

    if(3 <= val) {
        ele = document.getElementById("search_district");

        ele.value = "";
        ele.name = 0;
    }

    if(2 <= val) {
        ele = document.getElementById("search_tehsil");

        ele.value = "";
        ele.name = 0;
    }

    if(1 <= val) {
        ele = document.getElementById("search_village");

        ele.value = "";
        ele.name = 0;
    }

}

/** Function to reset the Below thing if we are chagnes upper in religion details */
function resetReligionLowerDetailsIfChanged(val) {
    if(3 <= val) {
        ele = document.getElementById("search_religion");
        ele.value = "";
        ele.name = 0;
    }

    if(2 <= val) {
        ele = document.getElementById("search_caste");
        ele.value = "";
        ele.name = 0;
    }

    if(1 <= val) {
        ele = document.getElementById("search_subcaste");
        ele.value = "";
        ele.name = 0;
    }

}

class arrClassInout {
    constructor(name_i, value_i) {
    this.name = name_i;
    this.value = value_i;
    }
}

class testClass {
	constructor(name_, id_) {
		this.name = name_;
		this.id = id_;
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


function getListTemprory() {
	var lst = [];
	lst.push(new testClass("Mahesh", 1));
	lst.push(new testClass("Vinodi lal", 2));
	lst.push(new testClass("Prem Devi", 3));
	lst.push(new testClass("Sapna", 4));
	lst.push(new testClass("Suman", 5));
	lst.push(new testClass("Kiran", 6));
	lst.push(new testClass("Arti", 7));

	return lst;
}




function autoSuggestSearchState() {

     var url = "http://localhost:8081/register/auto/allStates";
     var requestType = 'GET';

     document.getElementById("search_state").style.borderColor="green";
     document.getElementById("search_state").style.borderWidth="1px";
    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    pos = getPositionOfDivInScreen("search_state");
    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].stateName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    registerAutoCompleteGenericFunction(document.getElementById("search_state"), listClassObjects,pos);

}




function autoSuggestSearchDistrict()
{
	var stateId = document.getElementById("search_state").name;
	if(stateId <=0 ) {
		document.getElementById("search_state").style.borderColor="red";
        document.getElementById("search_state").style.borderWidth="2px";
        return;
	} else {
		document.getElementById("search_state").style.borderColor="green";
        document.getElementById("search_state").style.borderWidth="1px";
	}
	document.getElementById("search_district").style.borderColor="green";
    document.getElementById("search_district").style.borderWidth="1px";


	pos = getPositionOfDivInScreen("search_district");

	var url = "http://localhost:8081/register/auto/districtByStateId/" + stateId +";";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].districtCode;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_district");
    registerAutoCompleteGenericFunction(document.getElementById("search_district"), listClassObjects,pos);

}




function autoSuggestSearchTehsil()
{
	var districtId = document.getElementById("search_district").name;
	if(districtId <=0 ) {
		document.getElementById("search_district").style.borderColor="red";
        document.getElementById("search_district").style.borderWidth="2px";
        return;
	} else {
		document.getElementById("search_district").style.borderColor="green";
        document.getElementById("search_district").style.borderWidth="1px";
	}
	document.getElementById("search_tehsil").style.borderColor="green";
    document.getElementById("search_tehsil").style.borderWidth="1px";

	pos = getPositionOfDivInScreen("search_tehsil");

	var url = "http://localhost:8081/register/auto/allTehsilByDistrictId/" + districtId +";";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].tehsilName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_tehsil");
    registerAutoCompleteGenericFunction(document.getElementById("search_tehsil"), listClassObjects,pos);

}




function autoSuggestSearchVillage()
{
	var tehsilId = document.getElementById("search_tehsil").name;
	if(tehsilId <=0 ) {
		document.getElementById("search_tehsil").style.borderColor="red";
        document.getElementById("search_tehsil").style.borderWidth="2px";
        return;
	} else {
		document.getElementById("search_tehsil").style.borderColor="green";
        document.getElementById("search_tehsil").style.borderWidth="1px";
	}
	document.getElementById("search_village").style.borderColor="green";
    document.getElementById("search_village").style.borderWidth="1px";

	pos = getPositionOfDivInScreen("search_village");

	var url = "http://localhost:8081/register/auto/allVillageTownByTehsilId/" + tehsilId +";";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].villageTownLocalAreaName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_village");
    registerAutoCompleteGenericFunction(document.getElementById("search_village"), listClassObjects,pos);

}




function autoSuggestSearchReligion()
{
	document.getElementById("search_religion").style.borderColor="green";
    document.getElementById("search_religion").style.borderWidth="1px";

	pos = getPositionOfDivInScreen("search_religion");

	var url = "http://localhost:8081/register/auto/allReligions";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].religionName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_religion");
    registerAutoCompleteGenericFunction(document.getElementById("search_religion"), listClassObjects,pos);
}



function autoSuggestSearchCaste()
{
	var religionId = document.getElementById("search_religion").name;
	if(religionId <=0 ) {
		document.getElementById("search_religion").style.borderColor="red";
        document.getElementById("search_religion").style.borderWidth="2px";
        return;
	} else {
		document.getElementById("search_religion").style.borderColor="green";
        document.getElementById("search_religion").style.borderWidth="1px";
	}
	document.getElementById("search_caste").style.borderColor="green";
    document.getElementById("search_caste").style.borderWidth="1px";

	pos = getPositionOfDivInScreen("search_caste");

	var url = "http://localhost:8081/register/auto/religionAllCaste/" + religionId +";";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].userCasteName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_caste");
    registerAutoCompleteGenericFunction(document.getElementById("search_caste"), listClassObjects,pos);

}



function autoSuggestSearchSubCaste()
{
	var casteId = document.getElementById("search_caste").name;
	if(casteId <=0 ) {
		document.getElementById("search_caste").style.borderColor="red";
        document.getElementById("search_caste").style.borderWidth="2px";
        return;
	} else {
		document.getElementById("search_caste").style.borderColor="green";
        document.getElementById("search_caste").style.borderWidth="1px";
	}
	document.getElementById("search_subcaste").style.borderColor="green";
    document.getElementById("search_subcaste").style.borderWidth="1px";

	pos = getPositionOfDivInScreen("search_subcaste");

	var url = "http://localhost:8081/register/auto/casteAllSubCaste/" + casteId +";";
    var requestType = 'GET';

    var lst =  SendHttpRequestAndReturnResponseToSameFunction(url, requestType, false, "", "", "No", false, null);
    //var lst = JSON.stringify(getListTemprory());

    var listClassObjects = [];
    var listOfSuggesations = JSON.parse(lst);
    for(i in listOfSuggesations) {
        var name = listOfSuggesations[i].userSubCasteName;
        var id = listOfSuggesations[i].id;
        listClassObjects.push( new arrClassInout(name,id));
    }
    pos = getPositionOfDivInScreen("search_subcaste");
    registerAutoCompleteGenericFunction(document.getElementById("search_subcaste"), listClassObjects,pos);

}

class searchParametersDetail {
	constructor(name_, state_, district_, tehsil_, village_, religion_, caste_, subcaste_) {
		this.name = name_;
		this.state = state_;
		this.district = district_;
		this.tehsil = tehsil_;
		this.village= village_;
		this.religion = religion_;
		this.caste = caste_;
		this.subcaste = subcaste_;
	}
}


function getListTemproryNumber(n) {

	var lst = [];
	for(i=0; i<n;i++) {
		lst.push(new testClass("Mahesh_"+i, i));
	}
	return lst;
}


 function addParentSubmitButton(divId, userId) {
    document.getElementById(divId).style.display="none";
    SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/add/parent/"+userId, "POST", false, "", "", "No", false, null);

 }

function addChildersSubmitButton(divId, userId) {
    document.getElementById(divId).style.display="none";
    SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/add/child/"+userId, "POST", false, "", "", "No", false, null);
 }

 function reachedLastGetMore(flag) {
 	if(flag >= lastListUsers) {
 		//alert("Reached last");
 	}
 }


function getCustomDivFOrUser(topMrg, imageSrc, name, gender, religionDetails, localaddressDetails, addressDetails, userCount, isBlock, userId) {



	var divv = "<div onmouseover ='reachedLastGetMore("+userCount +")' style='width: 100%; background-color: #ffffff; height: 20%; margin-top: " + topMrg + "%; position: relative;'>"
        		+ "<div style='width: 15%; height: 80%; top:10%; background-color: ; margin-left: 2%; position: relative; float: left;'>"
        			+ "<img src='" + imageSrc +"' style='width: 100%; height: 100%;'>"
        		+ "</div>"
				+ "<div style='width: 55%; height: 80%; top:10%; background-color: ; margin-left: 2%; position: relative;  float: left;'>"
        			+ "<div style='width: 100%; height: 32%; background-color: ; position: relative; float: left; overflow: auto;'>"
        				+ "<div style='width: 60%; height: 100%; background-color: ; position: relative; float: left; overflow: auto;'>"
        					+ "<p style='font-size: 18px'>" + name + "</p>"
        				+ "</div>"
        				+ "<div style='width: 38%; height: 100%; background-color: ;  position: relative; left:2%; float: left; overflow: auto; text-align: center;'>"
        					+ "<p style='font-size: 18px'>" + gender + "</p>"
        				+ "</div>"
        			+ "</div>"
        			+ "<div style='width: 100%; max-width:100%; height: 32%; background-color: ; top: 2px; position: relative;  float: left; overflow: auto;'>"
        				+ "<p style='font-size: 14px; white-space: pre-line; '>" + religionDetails + "</p>"
        			+ "</div>"
        			+ "<div style='width: 100%; height: 32%; background-color: ; top: 3px; position: relative; float: left; overflow: auto;'>"
        				+ "<p style='font-size: 14px; white-space: pre-line;'>" + localaddressDetails + "<br>" + addressDetails + "</p>"
        			+ "</div>"
        		+ "</div>"
  				+ "<div id='userDetailsListContailnerSearch_" + userId +"' style='width: 20%; height: 80%; top:10%; background-color: ; left: 2%; position: relative;  float: left; display:" + isBlock + ";'>"
        			+ "<div style='width: 100%; height: 40%; background-color: ; position: relative; float: left; overflow: auto; margin-top: 3%;'>"
        				+ "<button class='button-box' onclick='addParentSubmitButton(\"userDetailsListContailnerSearch_" + userId +"\"," + userId + ")' style='width: 100%; height: 100%;'>Request Add Parent</button>"
        			+ "</div>"
        			+ "<div style='width: 100%; height: 40%; background-color: ; position: relative; float: left; overflow: auto; margin-top: 5%;'>"
        				+ "<button class='button-box' onclick='addChildersSubmitButton(\"userDetailsListContailnerSearch_" + userId +"\","+ userId + ")' style='width: 100%; height: 100%;'>Request Add Childern</button>"
        			+ "</div>"
        		+ "</div>"
        	+ "</div>";

        	return divv;
}





function getListOfUserParentAndChilds(userId) {
    var parentLst = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/parent/basic/"+userId, "GET", false, "", "", "No", false, null);
    var ChildsLst = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/childs/basic/"+userId, "GET", false, "", "", "No", false, null);
    var SiblingsLst = SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/siblings/basic/"+userId, "GET", false, "", "", "No", false, null);

    var alreadyMapped = []
    if(parentLst != null) {
        prntParshed = JSON.parse(parentLst);
        for(i in prntParshed) {
            alreadyMapped.push(prntParshed[i].userId);
        }
    }

    if(ChildsLst != null) {
        ChildsLstParshed = JSON.parse(ChildsLst);
        for(i in ChildsLstParshed) {
            alreadyMapped.push(ChildsLstParshed[i].userId);
        }
    }

    if(SiblingsLst != null) {
        SiblingsLstParshed = JSON.parse(SiblingsLst);
        for(i in SiblingsLstParshed) {
            alreadyMapped.push(SiblingsLstParshed[i].userId);
        }
    }

    return alreadyMapped;
}


function isUserAlreadyCloseRelative(lstabc, userId) {
    for(i in lstabc) {
        if(userId == lstabc[i]) {
            return 1;
        }
    }
    return 0;
}



function SubmitSearchFilters() {
    lastListUsers = 0;
    var loggedInUserId = getCookie("userId");
    var closeRelativeList = getListOfUserParentAndChilds(loggedInUserId);
    if(closeRelativeList == null) {
        alert("Failed to process Request, Please try after some time");
        return;
    }
    console.log(JSON.stringify(closeRelativeList))

	var name_ = document.getElementById("search_name").value;
	var state_ = document.getElementById("search_state").name;
	var district_ = document.getElementById("search_district").name;
	var tehsil_ = document.getElementById("search_tehsil").name;
	var village_ = document.getElementById("search_village").name;

	if(state_ <=0 || district_ <=0 || tehsil_ <=0 || village_ <=0) {
		alert("Address Details Cannot be empty (State, District, Tehsil, Village)");
		return;
	}

	var religion_ = document.getElementById("search_religion").name;
	var caste_ = document.getElementById("search_caste").name;
	var subcaste_ = document.getElementById("search_subcaste").name;

	if((religion_ >0 || caste_ >0 || subcaste_ >0) && (religion_  <= 0 || caste_  <= 0 || subcaste_ <= 0)) {
		alert("Either Provide all details of dont select any (Religion, Caste, Subcaste)");
		return;
	}

	requestBody = JSON.stringify(new searchParametersDetail(name_, state_, district_, tehsil_, village_, religion_, caste_, subcaste_));
	console.log(requestBody);
	var lstResp =  SendHttpRequestAndReturnResponseToSameFunction("http://localhost:8081/user/search", "POST", false, requestBody, "", "No", false, null);
	if(lstResp == null) {
	    return;
	}
	lst = JSON.parse(lstResp);
	var parentDiv = document.getElementById("searchListResponseUsers");
	for(i in lst) {

        var isBlock = "block";

        if( loggedInUserId == lst[i].userid) {
            isBlock = "none";
        }

         for(j in closeRelativeList) {
            if(lst[i].userid == closeRelativeList[j]) {
                    isBlock = "none";
                    break;
              }
          }


		var src = "images/userProfilePics/userProfilePic_" + lst[i].userid + ".jpg;";
		var sex = "Male"
		if(lst[i].gender == 2)
			sex = "Female";

		if(lastListUsers == 0) {
			parentDiv.innerHTML = getCustomDivFOrUser(0, src, lst[i].name, sex, lst[i].religion, lst[i].localaddress,  lst[i].address, lastListUsers+1, isBlock, lst[i].userid);
		} else {
			parentDiv.innerHTML += getCustomDivFOrUser(2, src, lst[i].name, sex, lst[i].religion, lst[i].localaddress,  lst[i].address, lastListUsers+1, isBlock, lst[i].userid);
		}
		lastListUsers += 1;
	}
}

