<script>

	function getContextPath() {
			return '${contextpath}';
	}
	
	function loadEvent(id, url) {
		$(id).click(function() {
			location.href=url;
		});
	}


</script>