window.addEventListener("scroll", function () {
  var navigation = document.querySelector(".t-nav");
  var scrollY = window.scrollY;

  if (scrollY > 90) {
    // Khi cuộn xuống dưới 100px
    navigation.classList.add("sticky");
  } else {
    navigation.classList.remove("sticky");
  }
});

function displayFuncList() {
  var funcList = document.getElementById("func-list");
  funcList.style.display = "block";
}

function closeFuncList() {
    var funcList = document.getElementById("func-list");
    funcList.style.display = "none";
  }
