var form1 = document.getElementById("form1");
var form2 = document.getElementById("form2");
var roleToChange = document.querySelectorAll(".role");
var role = "employee";

form1.style.display = "block";
form2.style.display = "none";

roleToChange.forEach((r) => {
    r.addEventListener('change', function () {
        role = r.value;
        if (role === "employee") {
            form1.style.display = "block";
            form2.style.display = "none";
        } else if (role === "hr") {
            form2.style.display = "block";
            form1.style.display = "none";
        }
    });
});
