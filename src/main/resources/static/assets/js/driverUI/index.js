
window.addEventListener("scroll", function() {
	var navigation = document.querySelector(".t-nav");
	var scrollY = window.scrollY;

	if (scrollY > 90) {
		// Khi cuộn xuống dưới 100px
		navigation.classList.add("sticky");
	} else {
		navigation.classList.remove("sticky");
	}
});

function redirectToPage(url) {
	window.location.href = url;
}

function displayTabs() {
	var funcList = document.getElementById("func-list");
	funcList.style.display = "block";
}

function hideTabs(event) {
	var funcList1 = document.getElementById("func-list-1");
	var funcList = document.getElementById("func-list");

	if (!funcList1.contains(event.target)) {
		funcList.style.display = "none";
	}
}
