var base_url = "https://etrace.in/pincode/";
var base_urll = "https://etrace.in/pincodes/";

function redirectpincode(){
    var pincode = document.form.postcode.value;
    window.location.href="https://etrace.in/pin-code/"+pincode;
}

function fillSelect(JSON,id)
{
    alert(JSON);
    var SelectBox = document.getElementById(id);

    while (SelectBox.options.length)
    {
        SelectBox.options[0] = null;
    }
    var data = eval(JSON);
   // var slugdata = eval(slugjson);
    SelectBox.options[0] = new Option("-- Select --","");
    for (var i=0;i < data.length;i++)
    {
        SelectBox.options[SelectBox.options.length] = new Option(data[i].name, data[i].slug);
    }
}

function getStateName()
{
    alert("In Etrace get State");
    var parameters = 'get=state';
    $.ajax({
        type: "POST",
        url: base_urll+"data.php",
        data: parameters,
        success: function(data){
            alert(data);
            var slugjson = data.split('*');
            fillSelect(slugjson[0],'selectstate',slugjson[1]);
        }
    });
}

function getDistrictName(state)
{
    var parameters = 'get=district&state='+state;
    $.ajax({
        type: "POST",
        url: base_urll+"data",
        data: parameters,
        dataType: 'json',
        success: function(data){
            var slugjson = data;
            fillSelect(slugjson,'districtSelect');
        }
    });
}
function getCityName(state,district)
{
    var parameters = 'get=city&state='+state+'&district='+district;
    $.ajax({
        type: "POST",
        url: base_urll+"data",
        data: parameters,
        dataType: 'json',
        success: function(data){
            var slugjson = data;
            fillSelect(slugjson,'citySelect');
        }
    });
}

function getLocName(state,district,city)
{
    var parameters = 'get=loc&state='+state+'&district='+district+'&city='+city;
    $.ajax({
        type: "POST",
        url: base_urll+"data",
        data: parameters,
        dataType: 'json',
        success: function(data){
            var slugjson = data;
            fillSelect(slugjson,'locSelect');
        }
    });
}

function validate()
{
    valid = true;
    if ( document.form.selectstate.selectedIndex == 0 )
    {
        alert ( "Please select your State" );
        return false;
    }
    if(document.form.districtSelect.value == '-- Select --' || document.form.districtSelect.value == '')
    {
        var a=document.form.selectstate.value;
        window.location.href=base_url+a+'/';
    }

    else if(document.form.citySelect.value == '-- Select --' || document.form.citySelect.value == '')
    {
        var a=document.form.selectstate.value;
        var b=document.form.districtSelect.value;
        window.location.href=base_url+a+'/'+b+'/';
    }

    else if(document.form.locSelect.value == '-- Select --' || document.form.locSelect.value == '')
    {
        var a=document.form.selectstate.value;
        var b=document.form.districtSelect.value;
        var c=document.form.citySelect.value;
        window.location.href=base_url+a+'/'+b+'/'+c+'/';
    }
    else{

        var a=document.form.selectstate.value;
        var b=document.form.districtSelect.value;
        var c=document.form.citySelect.value;
        var d=document.form.locSelect.value;
        window.location.href=base_url+a+'/'+b+'/'+c+'/'+d+'/';
    }

}
