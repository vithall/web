// JavaScript Document

function sell() {
   // var a=prompt("请输入a的值","0")
    var a = document.getElementById("aNumber").value;
    var b = document.getElementById("bNumber").value;
    var c = document.getElementById("cNumber").value;
    document.write("a为" + a +"</br>");
    document.write("b为" + b + "</br>");
    document.write("c为" + c + "</br>");
    var sum = Number(a) + Number(b) + Number(c);
    document.write("销售总额为:" + sum);
}
function Addab() {
    var a = 1,b = 2;
    document.writeln("a=1,b=2");
    document.write("a+b=");
    a+=b;
    document.writeln(a);
    document.write("a-b=");
    a-=b;
    document.writeln(a);
    document.write("a*b=");
    a*=b;
    document.writeln(a);
    document.write("a/b=");
    a/=b;
    document.writeln(a);
}
function MultiplicationTable() { //乘法表
    for (var m = 1; m <= 9; m++) {
        for (var n = 1; n <= m; n++) {
            if (m * n < 10) {
                document.write("&nbsp;")
            }
            document.write(n + "*" + m + "=");
            document.write(m * n + "&nbsp;");
        }
        document.writeln("<br>");
    }
}
function check(){
    var date=form1.dates.value;
    len=date.length;
    year=parseInt(date.substr(0,4));
    month=parseInt(date.substr(5,2));
    day=parseInt(date.substr(8,2));
    if(len==""){
        alert("日期不能为空");
    }else if(len!=10){
        alert("您输入的日期格式不正确");
    }else if(isNaN(year)){
        alert("您输入的日期格式不正确");
    }else if((year>9999)||(year<1000)){
        alert("您输入的日期格式不正确");
    }else if(isNaN(month)){
        alert("您输入的日期格式不正确");
    }else if((month>12)||(month<1)){
        alert("您输入的日期格式不正确");
    }else if(isNaN(day)){
        alert("您输入的日期格式不正确");
    }else{
        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if((day<0)||(day>31)){
                alert("您输入的日期格式不正确");
            }else{
                form1.submit();
            }break;
            case 4: case 6: case 9: case 11:
            if((day<0)||(day>30)){
                alert("您输入的日期格式不正确");
            }else{
                form1.submit();
            }break;
            default:
                if((year%100==0)&&(year%4==0)){
                    if((day<0)||(day>29)){
                        alert("您输入的日期格式不正确");
                    }else{
                        if((day<0)||(day>28)){
                            alert("您输入的日期格式不正确");
                        }else{
                            form1.submit();
                        }
                    }
                }break;
        }
    }
}
function CaculateTax(){
//起征基数
    var v1=1200;
    var v2 = document.getElementById("taxNumber").value;
//存放临时结果
    var tempTax=0;
//计算v3为月应纳税所得额
    var v3=v2-v1;
    if(v3<=0){
        tempTax=0;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=500){
        tempTax=v3*0.05;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=2000){
        tempTax=v3*0.1-25;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=5000){
        tempTax=v3*0.15-125;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=20000){
        tempTax=v3*0.2-375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=40000){
        tempTax=v3*0.25-1375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=60000){
        tempTax=v3*0.3-3375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=80000){
        tempTax=v3*0.35-6375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if(v3<=100000){
        tempTax=v3*0.4-10375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
        return;
    }
    if (v3>100000){
        tempTax=v3*0.45-15375;
        alert(v2+"元个人月收入应缴纳"+tempTax+"元个人所得税。");
    }
}//调用函数计算个人所得税

function Addn() { //计算1到n的和（计算步骤）
    var j = 0;
    var n = document.getElementById("Add").value;
    for(var i=0;i<=n;i++){
        document.write("计算步骤"+i+":"+j+"+"+i+"="+(j+i)+"<br>");
        j = i + j;
    }
}
function AddEven() { //计算0到n的偶数和
    var j = 0,k = 0;
    var n = document.getElementById("Even").value;
    for(var i=0;i<=n;i=i+2){
        document.write("计算步骤"+k+":"+j+"+"+i+"="+(j+i)+"<br>");
        j = i + j;
        k++;
    }document.write("偶数和为"+j);
}
