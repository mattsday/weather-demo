$("#find").on("submit", function(e) {
	e.preventDefault();
	var city = $("#search_city").val();
	window.location.href = '/city/' + city;
});