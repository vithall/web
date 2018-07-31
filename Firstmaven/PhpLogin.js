function IDFocus() { //光标移入账号内
    var usernameId = document.getElementById("usernameId");
    usernameId.className="import_prompt";
    usernameId.innerHTML="由数字组成，长度为6-16位";
}
function IDBlur() { //光标移出账号
    var username = document.getElementById("username");
    var usernameId = document.getElementById("usernameId");
    var reg=/^(\d){6,16}$/; //有待明确范围
    if(username.value==""){
        usernameId.className="error_prompt";
        usernameId.innerHTML="账号不能为空，请重新输入";
        return false;
    }
    else if(reg.test(username.value)==false){
        usernameId.className="error_prompt";
        usernameId.innerHTML="由数字组成，长度为6-16位";
        return false;
    }
    else {
        usernameId.className = "ok_prompt";
        usernameId.innerHTML = "输入正确";
        return true;
    }
}

function PwdFocus() {
    var pwdId = document.getElementById("pwdId");
    pwdId.className="import_prompt";
    pwdId.innerHTML="由字母加数字组成，长度为6-16位";
}

function PwdBlur() {
    var pwd = document.getElementById("pwd");
    var pwdId = document.getElementById("pwdId");
    var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
    if (pwd.value==""){
        pwdId.className="error_prompt";
        pwdId.innerHTML="密码不能为空";
        return false;
    }
    if (reg.test(pwd.value)==false){
        pwdId.className="error_prompt";
        pwdId.innerHTML="由字母加数字组成，长度为6-16位";
        return false;
    }
    pwdId.className="ok_prompt";
    pwdId.innerHTML="密码输入正确";
    return true;
}
function repwdBlur() {
    var repwd = document.getElementById("repwd");
    var pwd = document.getElementById("pwd");
    var repwdId = document.getElementById("repwdId");
    if (repwd.value==""){
        repwdId.className="error_prompt";
        repwdId.innerHTML="密码不能为空";
        return false;
    }
    if (pwd.value!=repwd.value){
        repwdId.className="error_prompt";
        repwdId.innerHTML="密码与上次输入的不一致"
        return false;
    }
    repwdId.className="ok_prompt";
    repwdId.innerHTML="正确";
    return true;
}
function nicknameBlur() {
    var nickname = document.getElementById("nickname");
    var nicknameId = document.getElementById("nicknameId");
    var k=0;
    var reg=/^([\u4e00-\u9fa5]|\w|[@!#$%&*])+$/;
    var chinaReg=/[\u4e00-\u9fa5]/g;
    if (nickname.value==""){
        nicknameId.className="error_prompt";
        nicknameId.innerHTML="昵称不能为空";
        return false;
    }
    if (reg.test(nickname.value)==false){
        nicknameId.className="error_prompt";
        nicknameId.innerHTML="只能由汉字、字母、数字组成";
        return false;
    }
    var len=nickname.value.replace(chinaReg,"ab").length;
    if (len<6||len>20){
        nicknameId.className="error_prompt";
        nicknameId.innerHTML="长度为6-20个字符组成";
        return false;
    }
    nicknameId.className="ok_prompt";
    nicknameId.innerHTML="输入正确";
    return true;
}
function checkForm() {
    var username = IDBlur();
    var pwd = PwdBlur();
    var repwd = repwdBlur();
    var nickname = nicknameBlur();
    IDBlur();
    PwdBlur();
    repwdBlur();
    nicknameBlur();

    if (username==true&&pwd==true&&repwd==true&&nickname==true){
        return true;
    }
    else {
        return false;
    }
}
