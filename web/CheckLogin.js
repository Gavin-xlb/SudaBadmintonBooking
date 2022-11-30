    function check() {
        if(document.loginform.status.value=="学生"||document.loginform.status.value=="普通教师"){
            var array=document.getElementById("op");
            var index=array.selectedIndex;
            var value=array.options[index].value;
            //alert("111");
            //alert("222"+value);
            if(value=="管理员登录"){
                alert("学生和普通教师不能选择管理员登录！");
                return  false;
            }
            else{
                if(document.loginform.username.value==""||document.loginform.name.value==""||document.loginform.password.value==""){
                    alert("所有信息不能为空！");
                    document.loginform.username.focus();
                    return false;
                }
                else{
                    document.loginform.submit();
                    return true;
                }
            }

        }
        else{
            if(document.loginform.choices.value=="管理员登录"){
                if(document.loginform.username.value==""||document.loginform.password.value==""){
                    alert("工号和密码不能为空！");
                    document.loginform.username.focus();
                    return false;
                }
                else{
                    document.loginform.submit();
                    return true;
                }
            }
            else{
                if(document.loginform.username.value==""||document.loginform.name.value==""||document.loginform.password.value==""){
                    alert("所有信息不能为空！");
                    document.loginform.username.focus();
                    return false;
                }
                else{
                    document.loginform.submit();
                    return true;
                }
            }

        }
    }
