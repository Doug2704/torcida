document.getElementById("form-login").addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("name").value;
    const password = document.getElementById("password").value;

   if (username && password) {
        window.location.href = "pages/home.html";
    } else {
        alert("Preencha usuário e senha");
    }
})