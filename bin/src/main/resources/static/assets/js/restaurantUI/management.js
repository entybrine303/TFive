function displayTabs() {
  var listTabsOn = document.getElementById("list-tabs-on");
  listTabsOn.style.display = "block";
  var listTabsOff = document.getElementById("list-tabs-off");
  listTabsOff.style.display = "none";
}

function hideTabs(event) {
  var listTabsOn = document.getElementById("list-tabs-on");
  var listTabsOff = document.getElementById("list-tabs-off");

  if (!listTabsOn.contains(event.target)) {
    listTabsOn.style.display = "none";
    listTabsOff.style.display = "flex";
  }
}
