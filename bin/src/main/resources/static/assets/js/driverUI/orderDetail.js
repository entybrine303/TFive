
function displayNumberPhone() {
  var funcList = document.getElementById("func-number-phone");
  funcList.style.display = "block";
}

function displayCancelOrder() {
  var funcList = document.getElementById("func-cancel-order");
  funcList.style.display = "block";
}

function closeFunc(evt) {
  // Sử dụng event.target để lấy thẻ nút được click
  var button = evt.target;

  // Sử dụng parentNode để điều hướng lên thẻ cha <ul>
  var ul = button.parentNode.parentNode.parentNode;
  ul.style.display = "none";
}
