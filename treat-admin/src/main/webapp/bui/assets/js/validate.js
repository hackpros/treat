/** ===============================================================
 *
 * 此JS包含FORM表单的验证。HTML中只需引入此JS即可。
 * 此JS包含STRING的两个方法：
 * 1、计算实际长度的方法（汉字算两个字符）
 * 2、删除字符串两头空格的方法
 *
 * =================================================================*/
String.prototype.length2 = function() {
    var cArr = this.match(/[^\x00-\xff]/ig);
    return this.length + (cArr == null ? 0 : cArr.length);
}
String.prototype.trim = function() {
	var i,b=0,e=this.length;  
    for(i=0;i<this.length;i++){
    	if(this.charAt(i)!=' '){
       		b=i;
       		break;
       	}
    }
    if(i==this.length)  
        return  "";

   	for(i=this.length-1;i>=b;i--)
 		if(this.charAt(i)!=' '){
   			e=i;
   			break;
   		}
  	return  this.substring(b,e+1);
}
var flag = "\n";
function setFlag(f){
	flag = f;
}
function alertErrorMsg(errorMsg){
	alert(errorMsg);
}
function customCheck(f){
	return "";
}
function checkForm(f) {
	var errorMsg = "";
	for (var elementIndex = 0;elementIndex < f.elements.length;elementIndex++) {
		var ele;
		try	{
			ele = f.elements[elementIndex];
			//如果元素被disabled则忽略,add at 2009-10-13
			if(ele.disabled){
				continue;
			}
			var eleTagn = ele.tagName;
			var eleType = ele.type;
			if((eleTagn == "INPUT" && (eleType == "password" ||eleType == "text" || eleType == "checkbox" || eleType == "radio")) || ele.tagName == "TEXTAREA"){
				/*检查CHECKBOX.CHECKBOX仅检查是否必须选择以及选择的项数*/
				if(eleType == "checkbox"){
					errorMsg += checkCheckBox(ele);
				}else if(eleType == "radio"){
					errorMsg += checkRadio(ele);
				}else{
					errorMsg += checkElement(ele);				
				}
			}else if(ele.tagName == "SELECT"){
				errorMsg += checkSelect(ele);
			}		
		}
		catch(e){}
	}
	errorMsg += customCheck(f);
	if(errorMsg != ""){
		alertErrorMsg(errorMsg);
		return false;
	}
	return true;
}
function checkNull(checkType , checkValue , titleValue){
	var pat = /notnull/g;
	if(pat.test(checkType) && checkValue.trim() == ""){
		return titleValue + "不能为空，请输入。" + flag;
	}
	return "";
}
function checkNumber(checkType , checkValue , titleValue){
	var pat = new RegExp("number\\(\\d+,{0,1}\\d*\\)", "g");
	if(!pat.test(checkType) || checkValue == ""){
		return "";
	}		
	pat.compile("number\\((\\d+),(\\d+)\\)", "g");
	if(pat.test(checkType)){
		var zs = RegExp.$1;	
		var xs = RegExp.$2;				
		pat.compile("^\\d{1," + zs + "}\.{0,1}\\d{0," + xs + "}$" , "g");
		if(pat.test(checkValue)){
			return "";
		}else{
			return titleValue + "有误。请输入数字，且整数部分长度不能超过" +  zs + "位，小数部分不能超过" + xs + "位。" + flag;
		}
	}		
	pat.compile("number\\((\\d+)\\)" , "g");
	if(pat.test(checkType)){				
		var zs = RegExp.$1;	
		pat.compile("^\\d{1," + zs + "}$" , "g");
		if(pat.test(checkValue)){
			return "";
		}else{
			return titleValue + "有误。请输入整数，且长度不能超过" +  zs + "位。" + flag;
		}
	}	
}
function checkDate(checkType , checkValue , titleValue){
	var pat = /date/g;
	if(!pat.test(checkType) || checkValue == ""){
		return "";
	}	
	var errMsg = __checkDate__(checkValue);
	return errMsg == "" ? "" : (titleValue + errMsg + "，请重新输入。" + flag);
}
function __checkDate__(dateValue){
	var pat = /^(\d{4})-(\d{2})-(\d{2})$/g;
	if(!pat.test(dateValue)){
		return "格式有误！标准格式如：2006-01-01";
	}
	var year = parseInt(RegExp.$1);
	var month = parseInt(RegExp.$2);
	var day = parseInt(RegExp.$3);
	var thisDay = 0;
	var errMsg = "";
	switch(month) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:thisDay = 31;break;
		case 4:case 6:case 9:case 11:thisDay = 30;break;
		case 2:(((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))) ? thisDay=29 : thisDay=28);break;
	}
	var pre = "";
	if((year > 3000 ) || (year < 1900)) {
		errMsg += pre + "格式中的年份有误";
		pre = "，";
	}
	if((month > 12 ) || (month < 1)) {
		errMsg += pre + "格式中的月有误";
		pre = "，";
	}else if((day > thisDay) || (day < 1)) {
		errMsg += pre + "格式中的日有误";
		pre = "，";
	}
	return errMsg;
}

function checkInputLength(checkType , checkValue , titleValue){
	var pat = /length(<=|=)(\d+)/g;
	if(!pat.test(checkType) || checkValue == ""){
		return "";
	}
	var opt = RegExp.$1;
	var val = parseInt(RegExp.$2);
	var len = checkValue.length2();
	var l = ((val%2)==1) ?((val-1)/2) : val/2;
	var m = "。";
	if(l != 0){
		m = "或" + l  + "位汉字。";
	}	
	if(opt == "<=" && len > val){		
		return titleValue + "过长。请输入不超过" + val + "位字符" + m + flag;
	}else if(opt == "=" && len != val){
		return titleValue + "过长。请输入" + val + "位字符" +  m + flag;
	}
	return "";
}
function checkDHHM(checkType , checkValue , titleValue){
	var pat = /dhhm/g;
	if(!pat.test(checkType) || checkValue == ""){
		return "";
	}
	pat.compile("^[\\d,\\-,\\+,\\ ]+$","g");
	if(!pat.test(checkValue)){
		return titleValue + "有误。请输入正确的号码。" + flag;
	}	
	var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	if(patrn.test(checkValue)){
		return "";
	}
	return titleValue + "有误。请输入正确的号码。" + flag;
}
function checkSFZ(checkType , checkValue , titleValue){
	var pat = /sfz/g;
	if(!pat.test(checkType) || checkValue == ""){
		return "";
	}
	var s = checkValue;	
	pat.compile("^\\d{15}|\\d{17}[0-9,X]$" , "g");
	var sfzErrMsg = titleValue + "有误。请输入15位或者18位公民身份号码！" + flag;
	if(!pat.test(s)) {
		return(sfzErrMsg);
	}
	if(s.length == 18 && s.substr(17) != getSfzLastCode(s.substring(0,17))){
		var err = "校验码有误";
		return(sfzErrMsg);
	}
	if(s.length == 15){
		s = sfz15to18(s);
	}	
	var birthErrMsg = __checkDate__(getBirth(s));
	if(birthErrMsg != "") {
		var err = "出生日期有误";
		return(sfzErrMsg);
	}		
	return "";
}
function checkAndReplaceSFZ(checkType , field , titleValue){
	var pat = /sfz/g;
	if(!pat.test(checkType) || field.value.trim() == ""){
		return "";
	}
	var s = field.value.trim();	
	if(s.length != 15 && s.length != 18){
		return("居民身份证长度不对，请输入15位或者18位居民身份号码！");
	}
	
	if(s.length == 15){
		s = sfz15to18(s);
		field.value = s;
	}	
	if(!s.substr(0,17).match(/\d{17}/)){
		return("居民身份证前17位必须是数字，请重新输入！");
	}
	
	var birth = checkBirth(s.substring(6,10), s.substring(10,12), s.substring(12,14));
	if(birth != ""){
		return("居民身份证出生日期" + birth);
	}	
	if(s.substr(17) != getSfzLastCode(s.substring(0,17))){
		return("居民身份证校验码有误，请重新输入！");
	}

	return "";
}
//判断日期是否有错误
function checkBirth(syear, smonth, sday){
	var leap = 0;
	var str1 = Number(syear);
	var str2 = Number(smonth);
	var str3 = Number(sday);

	if(str1<1900 || str1>2100){
		return("输入错误：年份范围不正确！");
	}
	if(str2<1 || str2>12){
		return("输入错误：月份范围不正确！");
	}
	if(str3<1 || str3>31){
		return("输入错误：日范围不正确！");
	}
	if((str1%4==0&&str1%100!=0)||(str1%400==0)){
		leap=1;
	}
	if(leap==0&&str2=="02"&&Number(str3)>28){
		return("输入错误：本年是平年，二月份只有二十八天！");
	}
	if(leap==1&&str2=="02"&&Number(str3)>29){
		return("输入错误：本年是闰年，二月份只有二十九天！");
	}
	if((str2=="04"||str2=="06"||str2=="09"||str2=="11")&&str3=="31"){
		return("输入错误：本月只有三十天！");
	}
	return("");
}
//身份证15位转18位
function sfz15to18(sfz) {
	if(sfz==null || (sfz.length!=15 && sfz.length!=17 && sfz.length!=18)) return "";
	var retsfz = sfz;
	if(retsfz.length==15) retsfz = retsfz.substr(0,6)+"19"+retsfz.substr(6);
	if(retsfz.length==17) retsfz = retsfz + getSfzLastCode(retsfz);
	return retsfz;
}
//身份证18位转15位
function sfz18to15(sfz){
	if(sfz==null || (sfz.length!=15 && sfz.length!=18)) return "";
   	var retsfz = sfz.substring(0,6) + sfz.substring(8,17);
   	return retsfz;
}
function getSfzLastCode(sfz){
	if(sfz==null || sfz.length<17 || sfz.length>18) return "";
	var Num=0;
	for(i=0;i<17;i++){
		Num += Math.pow(2,17-i) % 11 * Number(sfz.substr(i,1));
	}
	Num = Num % 11;
	var code = (12-Num) % 11;
	return code<10?String(code):"X";
}
//获取身份证出生日期
function getBirth(sfz) {
	if(sfz == null || sfz.length!=18) return "";
	return sfz.substring(6,10) + "-" + sfz.substring(10,12) + "-" + sfz.substring(12,14);
}
//检查身份证性别,sex:1男,2女
function checksfz_sex(sfz, sex) {
	if(sfz==null || sfz.length!=18) return false;
	if(sex=="1") return ("13579".indexOf(sfz.substr(16,1))>=0);
	if(sex=="2") return ("02468".indexOf(sfz.substr(16,1))>=0);
	return false;
}

/**
 * Add By ZongShuai at 2009-10-13
 * 通过传入元素名称组成的数组方式校验元素.
 * @param fields:元素数组
 */
function checkElements(fields){
	var errorMsg = "";
	for(var i=0;i<fields.length;i++){
		var field = document.getElementsByName(fields[i])[0];
		errorMsg += checkElement(field);
	}
	if(errorMsg != ""){
		alertErrorMsg(errorMsg);
		return false;
	}
	return true;
}
function checkElement(field){
	var titleValue = field.title;
	if(!titleValue){
		return "";
	}
	var checkValue = field.value.trim();
	var checkType = field.alt;
	if(!checkType){
		return "";
	}
	var errorMsg = "";
	/*检查空值。通过notnull标识*/
	errorMsg += checkNull(checkType , checkValue , titleValue);
	/*检查数字，包括小数点。通过number标识，如number(3,2)表示111.11、11.1合法，而1111.不合法*/
	errorMsg += checkNumber(checkType , checkValue , titleValue);
	/*检查日期。通过date标识*/
	errorMsg += checkDate(checkType , checkValue , titleValue);
	/*检查输入项的长度，汉字的长度为2。通过length<=标识*/
	errorMsg += checkInputLength(checkType , checkValue , titleValue);
	/*检查身份证。通过sfz标识*/
	//errorMsg += checkSFZ(checkType , checkValue , titleValue);
	
	/**
	 * Modify By ZongShuai at 2009-11-03
	 * 检查身份证,如果是15位的自动替换成18位.
	 */
	errorMsg += checkAndReplaceSFZ(checkType , field , titleValue);
	/*检查电话号码。通过dhhm标识*/
	errorMsg += checkDHHM(checkType , checkValue , titleValue);
	return errorMsg;
}
function checkSelect(field){
	var titleValue = field.title;	
	if(!titleValue || titleValue == ""){
		return "";
	}
	var checkType = field.alt;
	if(!checkType || checkType == ""){
		return "";
	}	
	var errorMsg = "";
	var val = field.value;
	var pat = /notnull/g;
	if(pat.test(checkType) && val == ""){
		return titleValue + "不能为空，请选择。" + flag;
	}
	return "";
}
function checkRadio(field){
	var fieldName = field.name;
	var fields = document.getElementsByName(fieldName);
	if(field != fields[0]){
		return "";
	}
	var titleValue = field.title;	
	if(!titleValue) titleValue = "";
	var checkType = field.alt;
	if(!checkType) checkType = "";	
	var errorMsg = "";
	var count = 0;
	for(var i=0;i<fields.length;i++){
		var altTmp = fields[i].alt;
		if(altTmp && altTmp.length > checkType){
			titleValue = fields[i].title;
			checkType = altTmp;
		}
		if(fields[i].checked){
			count++;
		}
	}	
	if(!titleValue){
		return "";
	}
	if(!checkType){
		return "";
	}
	var pat = /notnull/g;
	if(pat.test(checkType) && count == 0){
		return titleValue + "不能为空，请选择。" + flag;
	}
	return "";
}
function checkCheckBox(field){
	var fieldName = field.name;
	var fields = document.getElementsByName(fieldName);
	if(field != fields[0]){
		return "";
	}
	var titleValue = field.title;	
	if(!titleValue) titleValue = "";
	var checkType = field.alt;
	if(!checkType) checkType = "";	
	var errorMsg = "";
	var count = 0;
	for(var i=0;i<fields.length;i++){
		var altTmp = fields[i].alt;
		if(altTmp && altTmp.length > checkType){
			titleValue = fields[i].title;
			checkType = altTmp;
		}
		if(fields[i].checked){
			count++;
		}
	}	
	if(!titleValue){
		return "";
	}
	if(!checkType){
		return "";
	}
	/*检查CHECKBOX，如：notnull;length=3标识不能必须选择，且只能选择三项。length<=5标识可以选择，
	可以不选。但选择最多不能超过5项*/
	var pat = /notnull/g;
	if(pat.test(checkType) && count == 0){
		return titleValue + "不能为空，请选择。" + flag;
	}	
	pat = /length(<=|=)(\d+)/g;
	if(!pat.test(checkType) || count == 0){
		return "";
	}
	var opt = RegExp.$1;
	var val = parseInt(RegExp.$2);
	if(opt == "<=" && val < count){
		return titleValue + "选择了" + count+ "项，超过了最大允许的" + val + "项。请重新选择。" + flag; 
	}
	if(opt == "=" && val != count){
		return titleValue + "选择了" + count+ "项，而只允许选择" + val + "项。请重新选择。" + flag; 
	}
	return "";
}
function fromOnSubmit(){
	//treatInput();	
	var sform = event.srcElement;	
	if(!checkForm(sform)){
		return false;
	}
	if(sform.oldfun && sform.oldfun.func) {
		return sform.oldfun.func();
	}
	return true;
}
function treatForm(){
	if(document.readyState!="complete") return;
	var curforms = document.forms;
	if(curforms.length>0) {
		for(var i=0;i<curforms.length;i++) {
			var ss = new Object();
			ss.func = curforms[i].onsubmit;
			curforms[i].oldfun = ss;
			curforms[i].onsubmit= fromOnSubmit;
		}
	}
	document.body.onpaste = docPaste;
}
function treatOneInput(obj){
	var src;
	if(obj) src = obj;
	else src = event.srcElement;
	
	if(src.type=="text"){
		src.value=src.value.replace(/[$#@%~&<>;:\''\""\/\\\\]/g,'').replace(/[\,]/g,"，");
	}
}

function docPaste(){
	var src = event.srcElement;
	if(src.type=="text" || src.type=="textarea"){
		var str = window.clipboardData.getData("Text");
		window.clipboardData.setData("Text", str.replace(/[`$#@%~&*<>;:\'\"\/\\\\]/g,'').replace(/[\,]/g,"，"));
	}
}
function docKeyPress(){
	var src = event.srcElement;
	if(src.type=="text" || src.type=="textarea"){
		if(event.keyCode>=33 && event.keyCode<=41) return false;
		if(event.keyCode>=43 && event.keyCode<=44) return false;
		if(event.keyCode>=58 && event.keyCode<=61) return false;
		if(event.keyCode>=58 && event.keyCode<=64) return false;
		if(event.keyCode>=91 && event.keyCode<=96) return false;
		if(event.keyCode==126) return false;
	}
}
document.onkeypress = docKeyPress;
document.onreadystatechange = treatForm;