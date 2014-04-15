$(function() {

});

var debug=false;
function log(msg) {
	if(debug) console.log(msg);
}

function showBusTutorial() {
	if(!busChosen()) {
		log('show bus tutorial');
		$("#routeId").prepend("<option value=''></option>").val('');
		$("#stopId").prepend("<option value=''></option>").val('');
		$('#no_bus_chosen').hide();
		$('#tutorial_bus').show();
		$('#maintable').hide();
		return;
	}
	log('hide bus tutorial');
}

function showNoResults(resultsFound) {
	if(!resultsFound) {
		log('show no results');
		$('#no_bus_chosen').show();
		return;
	}
	log('hide no results');
}
function showStopTutorial() {
	if(busChosen() && !stopChosen()) {
		log('show stop tutorial');
		$("#stopId").prepend("<option value=''></option>").val('');
		$('#no_bus_chosen').hide();
		$('#tutorial_stops').show();
		return;
	}
	log('hide stop tutorial');
}
function showSetDefaultTutorial(resultsFound) {
	if(hasClickedMenu() && !hasDefault() && resultsFound) {
		log('show default tutorial');
		$('#no_bus_chosen').hide();
		$('#tutorial_default').show();
		return;
	}
	log('hide default tutorial');
}
function showMenuTutorial() {
	if(busChosen() && stopChosen() && !hasClickedMenu()) {
		log('show menu tutorial');
		$('#no_bus_chosen').hide();
		$('#tutorial_menu').show();
		return;
	}
	log('hide menu tutorial');
}

function hasProperty(property) {
	var has = window.localStorage.getItem(property);
	log(property + " = " + has);
	if(has) return true;
	return false;
}

function hasClickedMenu() {
	return hasProperty("menuclicked");
}

function hasDefault() {
	return hasProperty("default");
}

function busChosen() {
	return hasProperty("bus_chosen");
}

function stopChosen() {
	return hasProperty("stop_chosen");
}