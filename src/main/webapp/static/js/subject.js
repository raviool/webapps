var req;
var mozillus = 0;
var server = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + "/";
var person;
var enterprise;
var selected_person;
var selected_enterprise;
var persons;
var enterprises;

function get_subjects(name, caller) {
	document.getElementById("subjects_list").style.visibility="hidden";
	persons=null;
	enterprises=null;
	get_persons(name, caller);
	get_enterprises(name, caller);
	console.log("persons: " + persons);
	console.log("enterprises: " + enterprises);
	show_subjects(persons, enterprises);
}

function get_persons(name, caller) {
	console.log("get_persons");
	initialize();
	var url = server + "persons?name=" + name;
	person = name;
	if (selected_person) {
		selected_person.style.fontWeight = "normal";
	}
	selected_person = caller;
	selected_person.style.fontWeight = "bold";

	document.getElementById("ajax_response").innerHTML=url;
	if(req != null) {
		console.log("get_persons: Request not null, going to process.");
		req.onreadystatechange = process_persons_request;
		req.open("GET", url, false);
		req.send(null);
	}
}

function get_enterprises(name, caller) {
	console.log("get_enterprises");
	initialize();
	var url = server + "enterprises?name=" + name;
	enterprise = name;
	if (selected_enterprise) {
		selected_enterprise.style.fontWeight = "normal";
	}
	selected_enterprise = caller;
	selected_enterprise.style.fontWeight = "bold";

	document.getElementById("ajax_response").innerHTML=url;
	if(req != null) {
		console.log("get_enterprises: Request not null, going to process.");
		req.onreadystatechange = process_enterprises_request;
		req.open("GET", url, false);
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

function process_persons_request() {
	var x;
	if (req.readyState == 4) {
		if (req.status == 200) {
			if(req.responseText=="") {
				x = 1;
			}
			else {
				console.log("process_persons_request: Parsing JSON");
				console.log("persons JSON response: " + req.responseText);
				persons = JSON.parse(req.responseText);
			}
		} else {
			document.getElementById("ajax_response").innerHTML="Viga andmete saamisel:<br>"+req.statusText;
		}
	}
}

function process_enterprises_request() {
	var x;
	if (req.readyState == 4) {
		if (req.status == 200) {
			if(req.responseText=="") {
				x = 1;
			}
			else {
				console.log("process_enterprises_request: Parsing JSON");
				console.log("enterprises JSON response: " + req.responseText);
				enterprises = JSON.parse(req.responseText);
			}
		} else {
			document.getElementById("ajax_response").innerHTML="Viga andmete saamisel:<br>"+req.statusText;
		}
	}
}

function show_subjects(persons, enterprises) {
	console.log("show_subjects: persons: " + persons);
	console.log("show_subjects: enterprises: " + enterprises);
	var table = document.getElementById("subjectsTable");
	if (persons != null && enterprises != null) {
		table.innerHTML = "";
		var tableContent = "<tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti nimi</td><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti tuup</td><td bgcolor='#cccccc' style='padding:2px;' nowrap></td></tr>"
		for (var i=0; i<persons.length; i++) {
			tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + persons[i].lastName + "</td><td style='padding:2px;'>&nbsp;Person</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='button' value='Loo seos'></td></tr>";
		}
		for (var i=0; i<enterprises.length; i++) {
			tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + enterprises[i].name + "</td><td style='padding:2px;'>&nbsp;Enterprise</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='button' value='Loo seos'></td></tr>";
		}
		table.innerHTML = tableContent;
		show_subjects_list();
	} else if (persons == null && enterprises != null) {
		table.innerHTML = "";
		var tableContent = "<tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti nimi</td><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti tuup</td><td bgcolor='#cccccc' style='padding:2px;' nowrap></td></tr>"
		for (var i=0; i<enterprises.length; i++) {
			tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + enterprises[i].name + "</td><td style='padding:2px;'>&nbsp;Enterprise</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='button' value='Loo seos'></td></tr>";
		}
		table.innerHTML = tableContent;
		show_subjects_list();
	} else if (enterprises == null && persons != null) {
		table.innerHTML = "";
		var tableContent = "<tr bgcolor='#ffffff'><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti nimi</td><td bgcolor='#cccccc' style='padding:2px;' nowrap>Subjekti tuup</td><td bgcolor='#cccccc' style='padding:2px;' nowrap></td></tr>"
		for (var i=0; i<persons.length; i++) {
			tableContent += "<tr bgcolor='#ffffff'><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'>" + persons[i].lastName + "</td><td style='padding:2px;'>&nbsp;Person</td><td style='padding:2px;'>&nbsp;<b><font color='#0000ff'><input type='button' value='Loo seos'></td></tr>";
		}
		table.innerHTML = tableContent;
		show_subjects_list();
	} else {
		table.innerHTML = "<tr bgcolor='#ffffff'><td colspan='4' bgcolor='#ffffff'>Subjekte ei leitud</td></tr>";
		show_subjects_list();
	}
}

function show_subjects_list() {
	document.getElementById("subjects_list").style.visibility="visible";
}

function hide_subjects_list() {
	document.getElementById("subjects_list").style.visibility="hidden";
}