<%@ include file="plain_header.jsp" %>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

		<h2 id="ht">Form Tests</h2>
		
		<div id="fireeventresult"></div>
		
		<form>
		
			<input id="email" type="email"> Email
			<p>
			<input id="focus" type="text"> Focus
			<input type="hidden" id="iamhidden">
			<p>
			<input type="radio" name="sex" id="male" value="male">Male<br>
			<input type="radio" name="sex" id="female" value="female">Female
			<p>
			<input type="checkbox" id="vehicle1" value="Bike">I have a bike<br>
			<input type="checkbox" id="vehicle2" value="Car">I have a car
			<p>
			<select id="cars">
			  <optgroup label="Swedish Cars">
			    <option value="volvo">Volvo</option>
			    <option value="saab">Saab</option>
			  </optgroup>
			  <optgroup label="German Cars">
			    <option value="mercedes">Mercedes</option>
			    <option value="audi">Audi</option>
			  </optgroup>
			</select>
			<p>
			<textarea rows="10" cols="30">
			Car details.
			</textarea>
			<p>
			<select id="reload">
				<option value="none">Select</option>
				<option value="reloadoption">Reload</option>
			</select>
		
		</form>
		
		<div id="draggable" class="ui-widget-content">
		  <p>Drag me to my target with pause</p>
		</div>
		 
		<div id="droppable" class="ui-widget-header">
		  <p id="amidropped">Drop here with pause</p>
		</div>
		
		<div id="draggable2" class="ui-widget-content">
		  <p>Drag me to my target</p>
		</div>
		 
		<div id="droppable2" class="ui-widget-header">
		  <p id="amidropped2">Drop here</p>
		</div>

		  <style>
		  	#draggable, #draggable2 { width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0; }
		  	#droppable, #droppable2 { width: 150px; height: 150px; padding: 0.5em; float: left; margin: 10px; }
		  </style>
		<script>
		
			$(function() {
				$('#focus').focus(function() {
					$('#fireeventresult').html('focused');
				})
				$('#focus').blur(function() {
					$('#fireeventresult').html('blurred');
				})
				$('#reload').change(function() {
					location.reload();
				});
				$( "#draggable" ).draggable();
				$( "#draggable2" ).draggable();
			    $( "#droppable" ).droppable({
				      drop: function( event, ui ) {
				        $( this )
				          .addClass( "ui-state-highlight" )
				          .find( "p" )
				            .html( "Dropped!" );
				      }
				    });
			    $( "#droppable2" ).droppable({
				      drop: function( event, ui ) {
				        $( this )
				          .addClass( "ui-state-highlight" )
				          .find( "p" )
				            .html( "Dropped!" );
				      }
				    });
			});
		
		</script>

<%@ include file="plain_footer.jsp" %>