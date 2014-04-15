<%@ include file="plain_header.jsp" %>

		<h2 id="ht">Core Tests</h2>
		<div id="mydivs">
			<div class="testtext" id="hiddendiv" style="display:none">I am hidden</div>
			<div class="testtext" id="notext"></div>
			<div class="testtext" id="target">This is the target to change</div>
			<div class="testtext" id="multitext">ThisText ThisText ThisText ThisText ThisText</div>
			<div id="attributechecker" class="correctclass"></div>
		</div>

		
		<button class="btn btn-primary btn-space" id="showhiddendiv">Click and wait for div to show</button>
		<button class="btn btn-primary btn-space" id="hidehiddendiv">Click and wait for div to disappear</button>
		<button class="btn btn-primary btn-space" id="changedivtext">Change text</button>
		<button class="btn btn-primary btn-space" id="changedivtextwait">Change text and wait for element text</button>
		<button class="btn btn-primary btn-space" id="changedivtextwait2">Change text and wait for text</button>
		<button class="btn btn-primary btn-space" id="changedivtextpause">Change text with pause</button>
		<button class="btn btn-primary btn-space" id="changedivtextfired">Change text with fired event</button>
		<button class="btn btn-primary btn-space" id="createtext">Create Text</button>
		<button class="btn btn-primary btn-space" id="deleteelement">Delete Element</button>
		<button class="btn btn-primary btn-space" id="changecss">Change CSS</button>
		<button class="btn btn-primary btn-space" id="showimg">Show image</button>
		
		<div id="js_error"></div>
		<div id="js_error_span_url">setting-a-property-that-has-only-a-getter</div>
		<div id="js_error_span_msg"></div>
		<div id="js_error_span_line"></div>
		
		<span id="whichcss" class="thisone">Css Test</span>
		
		<img id="bbc" style="display:none" src="http://www.thedrum.com/uploads/drum_basic_article/102043/main_images/bbc_0.png">
		
		<style>
		
			.testtext {
				border: solid black 1px;
				padding: 4px 4px 4px 4px;
				background-color: yellow;
				margin: 7px;
			}
			
			.btn-space {
				margin: 7px;
			}
		
			.thisone {
			
				border: solid green 2px;
				padding: 4px 4px 4px 4px;
				background-color: yellow;
				margin: 7px;
			
			}
			.newclass {
				border: solid red 8px;
				padding: 4px 4px 4px 4px;
				background-color: yellow;
				margin: 7px;
			}
		
		</style>
		
		<script>
		
		
		
			$(function() {
				
				var time = 1000;
				
				$('#deleteelement').click(function() {
					setTimeout(function() {$('#target').remove();},time);
				});
				
				$('#changecss').click(function() {
					setTimeout(function() {
						$('#whichcss').removeClass('thisone');
						$('#whichcss').addClass('newclass');
					},time);
				});
				
				$('#showhiddendiv').click(function() {
					setTimeout(function() {$('#hiddendiv').show();},time);
				});
				
				$('#showimg').click(function() {
					setTimeout(function() {$('#bbc').show();},time);
				});
				$('#hidehiddendiv').click(function() {
					setTimeout(function() {$('#hiddendiv').hide();},time);
				});
				$('#changedivtext').click(function() {
					$('#target').html('Text has changed');
				});
				$('#changedivtextpause').click(function() {
					setTimeout(function() {$('#target').html('Text has changed after pause');},time);
				});
				$('#changedivtextfired').click(function() {
					$('#target').html('Text has changed after firedevent');
				});
				$('#createtext').click(function() {
					setTimeout(function() {$('#notext').html('Text is here');},time);
				});
				$('#changedivtextwait').click(function() {
					$('#target').html('You have been waiting for this');
				});
				$('#changedivtextwait2').click(function() {
					$('#target').html('You have been waiting for this 2');
				});
			});
		
		</script>

<%@ include file="plain_footer.jsp" %>