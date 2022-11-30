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
    var url= "Controller.do?action=School_ManagerForm&username="+username+"&psw="+psw;
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
function displaySchoolInfo() {
    var option=document.School_ManagerForm.schoolInfo_Search.value;
    var url="Controller.do?action=School_ManagerForm2&option="+option;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange=handleStateChange1;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(null);
}
function handleStateChange1() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200) {
            clearTable();
            var tableList=document.getElementById("tableList");
            var results=xmlHttp.responseXML.getElementsByTagName("tr"); //<tr>的数组
            var trnodes=null;
            if(results.length==1) {
                alert("没有符合条件的数据！");
                clearTable();
            }
            else{
                for(var i=0;i<results.length;i++){
                    trnodes=document.createElement("tr");
                    var childnodes=results[i].childNodes; //<td>的数组
                    var collen=childnodes.length;
                    for(var j=0;j<collen;j++){
                        var tdnodes=document.createElement("td");
                        tdnodes.appendChild(document.createTextNode(childnodes[j].firstChild.nodeValue));
                        trnodes.appendChild(tdnodes);
                    }
                    tableList.appendChild(trnodes);
                }
            }
        }
    }
}
function displaySign_Info1() {
    var flag=check();
    //alert(flag);
    if(flag===true){ //alert("111");
        var status1=document.School_ManagerForm.signInfo_Search_status.value;//alert(status);
        var content=document.School_ManagerForm.search_content.value;
        var scope=document.School_ManagerForm.signInfo_Search_scope.value;
        var college_name=document.School_ManagerForm.college_name.value;
        var major_name=document.School_ManagerForm.major_name.value;
        var class_name=document.School_ManagerForm.class_name.value;
        var number=document.School_ManagerForm.number.value;
        //alert(collegeName+" "+status1+" "+content+" "+scope+" "+major_name+" "+class_name+" "+number);
        //alert(collegeName);
        var url="Controller.do?action=School_ManagerForm3"+createQueryString(status1,content,scope,college_name,major_name,class_name,number);
        createXMLHttpRequest();
        xmlHttp.onreadystatechange=handleStateChange1;
        xmlHttp.open("GET",url,true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(null);
    }
}
function createQueryString(status1,content,scope,college_name,major_name,class_name,number){
    var queryString="&status="+status1 +"&content="+content +"&scope="+scope+"&college_name="+college_name+"&major_name="+major_name
        +"&class_name="+class_name +"&number="+number;
    //alert(queryString);
    return queryString;
}
function check() {
    var status=document.School_ManagerForm.signInfo_Search_status.value;
    var scope=document.School_ManagerForm.signInfo_Search_scope.value;
    //alert(status+" "+scope);
    if(status=="教师"){
        if(scope=="按班级查询"){
            alert("教师无法按班级查询！");
            clearTable();
            return false;
        }
        else if(scope=="按专业查询"){
            alert("教师无法按专业查询！");
            clearTable();
            return false;
        }
        else if(scope=="按个人查询"){
            if(document.School_ManagerForm.number.value==""){
                alert("工号不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
        else { //按学院查询
            if(document.School_ManagerForm.college_name.value==""){
                alert("学院不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
    }

    else{
        if(scope=="按班级查询"){
            if(document.School_ManagerForm.class_name.value==""||document.School_ManagerForm.major_name.value==""||document.School_ManagerForm.college_name.value==""){
                alert("学院和专业及班级不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
        else if(scope=="按专业查询"){
            if(document.School_ManagerForm.major_name.value==""||document.School_ManagerForm.college_name.value==""){
                alert("学院和专业不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
        else if(scope=="按个人查询"){
            if(document.School_ManagerForm.number.value==""){
                alert("学号不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
        else {
            if(document.School_ManagerForm.college_name.value==""){
                alert("学院不能为空！");
                clearTable()
                return false;
            }
            else return true;
        }
    }
}