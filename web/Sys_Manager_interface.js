var xmlHttp;
function createXMLHttpRequest() {
    if(window.ActiveXObject){
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }
}
function clearTable() {
    var tableList=document.getElementById("tableList");
    while(tableList.childNodes.length>0) tableList.removeChild(tableList.childNodes[0]);
}
function  updatepsw() {
    var username=document.getElementById("username").value;
    var psw=document.getElementById("psw").value;
    //alert(username+" "+psw);
    var url= "Controller.do?action=Sys_ManagerForm&username="+username+"&psw="+psw;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange=handleStateChange;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(null);
}
function handleStateChange() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200) {
            var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.nodeValue;
            alert(message);

        }
        else alert("error!");
    }
}
function displaySign_Info2() {
    var flag=check();
    //alert(flag);
    if(flag===true){ //alert("111");
        var status1=document.Sys_ManagerForm.signInfo_Search_status.value;//alert(status);
        var content=document.Sys_ManagerForm.search_content.value;
        var scope=document.Sys_ManagerForm.signInfo_Search_scope.value;
        var college_name=document.Sys_ManagerForm.college_name.value;
        var major_name=document.Sys_ManagerForm.major_name.value;
        var class_name=document.Sys_ManagerForm.class_name.value;
        var number=document.Sys_ManagerForm.number.value;
        //alert(collegeName+" "+status1+" "+content+" "+scope+" "+major_name+" "+class_name+" "+number);
        //alert(collegeName);
        var url="Controller.do?action=Sys_ManagerForm2"+createQueryString(status1,content,scope,college_name,major_name,class_name,number);
        createXMLHttpRequest();
        xmlHttp.onreadystatechange=handleStateChange1;
        xmlHttp.open("GET",url,true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(null);
    }
}
function handleStateChange1() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200) {
            clearTable();
            var tableList=document.getElementById("tableList");
            var results=xmlHttp.responseXML.getElementsByTagName("tr"); //<tr>?????????
            var trnodes=null;
            if(results.length==1) {
                alert("??????????????????????????????");
                clearTable();
            }
            else{
                for(var i=0;i<results.length;i++){
                    trnodes=document.createElement("tr");
                    var childnodes=results[i].childNodes; //<td>?????????
                    var collen=childnodes.length;
                    for(var j=0;j<collen;j++){
                        var tdnodes=document.createElement("td");
                        tdnodes.appendChild(document.createTextNode(childnodes[j].firstChild.nodeValue));
                        trnodes.appendChild(tdnodes);
                    }
                    tableList.appendChild(trnodes);
                }
            }
            var line=document.getElementById("newline");
            line.innerHTML="??????="+(results.length-1);
        }
    }
}
function createQueryString(status1,content,scope,college_name,major_name,class_name,number){
    var queryString="&status="+status1 +"&content="+content +"&scope="+scope+"&college_name="+college_name+"&major_name="+major_name
        +"&class_name="+class_name +"&number="+number;
    //alert(queryString);
    return queryString;
}
function check() {
    var status=document.Sys_ManagerForm.signInfo_Search_status.value;
    var scope=document.Sys_ManagerForm.signInfo_Search_scope.value;
    //alert(status+" "+scope);
    if(status=="??????"){
        if(scope=="???????????????"){
            alert("??????????????????????????????");
            clearTable();
            return false;
        }
        else if(scope=="???????????????"){
            alert("??????????????????????????????");
            clearTable();
            return false;
        }
        else if(scope=="???????????????"){
            if(document.Sys_ManagerForm.number.value==""){
                alert("?????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
        else { //???????????????
            if(document.Sys_ManagerForm.college_name.value==""){
                alert("?????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
    }

    else{
        if(scope=="???????????????"){
            if(document.Sys_ManagerForm.class_name.value==""||document.Sys_ManagerForm.major_name.value==""||document.Sys_ManagerForm.college_name.value==""){
                alert("???????????????????????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
        else if(scope=="???????????????"){
            if(document.Sys_ManagerForm.major_name.value==""||document.Sys_ManagerForm.college_name.value==""){
                alert("??????????????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
        else if(scope=="???????????????"){
            if(document.Sys_ManagerForm.number.value==""){
                alert("?????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
        else {
            if(document.Sys_ManagerForm.college_name.value==""){
                alert("?????????????????????");
                clearTable()
                return false;
            }
            else return true;
        }
    }
}
