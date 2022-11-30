function examine() {
    const phonenum = document.applyform.phonenumber.value;
    const q1= document.applyform.option1.value;
    const q2= document.applyform.option2.value;
    const q3= document.applyform.option3.value;
    const q4= document.applyform.option4.value;
    const q5= document.getElementsByName("sickness");
    var sum=0;
    for(var i=0;i<q5.length;i++){
        if(q5[i].checked) sum++;
    }

    if(phonenum==""||q1==""||q2==""||q3==""||q4==""||sum==0){
        alert("请将信息填写完整后再提交！");
        return false;
    }
    document.applyform.submit();
    return true;
}