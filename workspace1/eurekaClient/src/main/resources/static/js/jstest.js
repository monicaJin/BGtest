/*var xhr = new XMLHttpRequest();
var url = "http://192.168.103.175:9001/home/jdbc/mcc_znjx/check_order";
xhr.open("POST", url, true);
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = function () {
	if (xhr.readyState === 4 && xhr.status === 200) {
		var json = JSON.parse(xhr.responseText);
		console.log(json);
	}
};
var data = JSON.stringify({ key: "value" });
xhr.send(data);*/


function myFunction2() {
	document.getElementById("demo2").innerHTML = "我的第二个 JavaScript 函数";
}

function myFunction3() {
	document.getElementById("demo3").innerHTML = "我的第三个 JavaScript 函数";
}

function myFunction4(myCallback) {
	var xhr = new XMLHttpRequest();
	var orderid=document.getElementById('demo4inputtext').value
	console.log("here is "+orderid)
	var url = "http://192.168.103.175:9001/home/jdbc/mcc_znjx/check_order";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
/*			var json = JSON.parse(xhr.responseText);
			console.log(json);*/
			console.log(xhr.responseText)
			//alert("document id is : "+xhr.responseText)
			myCallback(xhr.responseText)
		}
	};
	var data = JSON.stringify({ id: orderid });
	xhr.send(data);
	
}