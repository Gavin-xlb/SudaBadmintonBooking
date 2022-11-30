var xmlHttp;
function check() {
    var status=document.College_ManagerForm.signInfo_Search_status.value;
    var scope=document.College_ManagerForm.signInfo_Search_scope.value;
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
                if(document.College_ManagerForm.number.value==""){
                    alert("工号不能为空！");
                    clearTable()
                    return false;
                }
                else return true;
            }
        else return true;
        }

    else{
            if(scope=="按班级查询"){
                if(document.College_ManagerForm.class_name.value==""||document.College_ManagerForm.major_name.value==""){
                    alert("专业和班级不能为空！");
                    clearTable()
                    return false;
                }
                else return true;
            }
            else if(scope=="按专业查询"){
                if(document.College_ManagerForm.major_name.value==""){
                    alert("专业不能为空！");
                    clearTable()
                    return false;
                }
                else return true;
            }
            else if(scope=="按个人查询"){
                if(document.College_ManagerForm.number.value==""){
                    alert("学号不能为空！");
                    clearTable()
                    return false;
                }
                 else return true;
            }
            else return true;
    }
}
function createXMLHttpRequest() {
    if(window.ActiveXObject){
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }
}
function displaySign_Info(){
    var flag=check();
    //alert(flag);
    if(flag===true){ //alert("111");
        var collegeName=document.getElementById("collegeName").value;//alert(collegeName);
        var status1=document.College_ManagerForm.signInfo_Search_status.value;//alert(status);
        var content=document.College_ManagerForm.search_content.value;
        var scope=document.College_ManagerForm.signInfo_Search_scope.value;
        var major_name=document.College_ManagerForm.major_name.value;
        var class_name=document.College_ManagerForm.class_name.value;
        var number=document.College_ManagerForm.number.value;
        //alert(collegeName+" "+status1+" "+content+" "+scope+" "+major_name+" "+class_name+" "+number);
        //alert(collegeName);
        var url="Controller.do?action=College_ManagerForm"+createQueryString(collegeName,status1,content,scope,major_name,class_name,number);
        createXMLHttpRequest();
        xmlHttp.onreadystatechange=handleStateChange;
        xmlHttp.open("GET",url,true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(null);
    }

}
function createQueryString(collegeName,status1,content,scope,major_name,class_name,number){
    var queryString="&collegeName="+collegeName+"&status="+status1
        +"&content="+content +"&scope="+scope+"&major_name="+major_name
        +"&class_name="+class_name +"&number="+number;
    //alert(queryString);
    return queryString;
}
function handleStateChange() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
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
            //document.getElementById("newpart").innerHTML="<p>"+"查询结果如下:"+"</p><br/>";
        }
    }
}
function clearTable() {
    var tableList=document.getElementById("tableList");
    while(tableList.childNodes.length>0) tableList.removeChild(tableList.childNodes[0]);
}

function displayCollegeInfo() {
    var option=document.College_ManagerForm.collegeInfo_Search.value;
    var collegeName=document.getElementById("collegeName").value;
    //alert(option+" "+collegeName);
    var url="Controller.do?action=College_ManagerForm2&option="+option+"&collegeName="+collegeName;
    createXMLHttpRequest();
    xmlHttp.onreadystatechange=handleStateChange;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(null);
}