var req;
var mozillus = 0;
var server = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + "/";

function get_documents(caller) {
	initialize();
	
	id=document.getElementById('id').value;
	name=document.getElementById('name').value;
	description=document.getElementById('description').value;
	last_name=document.getElementById('last_name').value;
	doc_catalog_name=document.getElementById('doc_catalog_name').value;
	doc_status=document.getElementById('doc_status').value;
	doc_type=document.getElementById('doc_type').value;
	
	var url = server + "documentSearch?id=" + id + "&name=" + name + "&description=" + description + "&last_name=" + last_name + "&doc_catalog_name=" + doc_catalog_name + "&doc_status=" + doc_status + "&doc_type=" + doc_type;
	
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
	if (documents.length > 0) {
		table.innerHTML = "";
		var tableContent = "<tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;'' nowrap>Dok.nr.</td><td bgcolor='#cccccc' style='padding:2px;' nowrap>Dokumendi nimi</td></tr>"
		for (var i=0; i<documents.length; i++) {
			tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + documents[i].document + "</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><a href='s?id=" + documents[i].document + "'>" + documents[i].name + "</a></td></tr>";
		}
		table.innerHTML = tableContent;
		show_documents_list();
	} else {
		table.innerHTML = "<tr bgcolor='#ffffff'><td colspan='4' bgcolor='#ffffff'>Dokumente ei leitud</td></tr>";
		show_documents_list();
	}
}

function show_documents_list() {
	document.getElementById("documents_list").style.visibility="visible";
}

function hide_documents_list() {
	document.getElementById("documents_list").style.visibility="hidden";
}