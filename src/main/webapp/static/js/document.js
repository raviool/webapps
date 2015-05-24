var req;
var mozillus = 0;
var server = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + "/";

function get_documents(catalog_id) {
	initialize();
	var url = server + "catalog?id=" + catalog_id;
	document.getElementById("ajax_response").innerHTML=url;
	if(req != null) {
		req.onreadystatechange = process_documents_request;
		req.open("GET", url, true);
		req.send(null);
	}
}

function initialize() {
	try {
		req = new ActiveXObject("Msxml2.XMLHTTP");
	} catch(e) {
		try {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(oc) {
			req = null;
		}
	}
	if(!req && typeof XMLHttpRequest!="undefined") {
		req = new XMLHttpRequest();
		mozillus = 1;
	}
} 

function process_documents_request() {
	var x;
	if (req.readyState == 4) {
		if (req.status == 200) {
			if(req.responseText=="") {
				x = 1;
			}
			else {
				var documents = JSON.parse(req.responseText);
				show_documents(documents);
			}
		} else {
			document.getElementById("ajax_response").innerHTML="Viga andmete saamisel:<br>"+req.statusText;
		}
	}
}

function show_documents(documents) {
	var table = document.getElementById("documentsTable");
	table.innerHTML = "";
	var tableContent = "<tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;' nowrap>Kataloog:</td><td style='padding:2px;' colspan=3>[Kataloogi path siia]</td></tr><tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;'' nowrap>Dok.nr.</td><td bgcolor='#cccccc' style='padding:2px;' nowrap>Dokumendi nimi</td><td bgcolor='#cccccc' style='padding:2px;'' nowrap></td><td bgcolor='#cccccc' style='padding:2px;' nowrap></td></tr>"
	for (var i=0; i<documents.length; i++) {
		tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + documents[i].document + "</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><a href='s?id=" + documents[i].document + "'>" + documents[i].name + "</a></td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='button' value='Kustuta'></td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='checkbox'></td></tr>";
		/*var row = table.insertRow(-1);

		var id = row.insertCell(0);
		var name = row.insertCell(1);
		var button = row.insertCell(2);
		var checkbox = row.insertCell(3);

		id.innerHTML = documents[i].document;
		name.innerHTML = "<a href='${pageContext.request.contextPath}/s?id=" + documents[i].document + "'>" + documents[i].name + "</a>";
		button.innerHTML = "<input type='button' value='Kustuta'>";
		name.innerHTML = "<input type='checkbox'>";*/
	}
	table.innerHTML = tableContent;
	show_documents_list();
}

function show_documents_list() {
	document.getElementById("documents_list").style.visibility="visible";
}

function hide_documents_list() {
	document.getElementById("documents_list").style.visibility="hidden";
}