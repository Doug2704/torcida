const btnOpenForm = document.getElementById("btnOpenForm")
const btnHideForm = document.getElementById("btnHideForm")
const btnFindAddress = document.getElementById("btnFindAddress")

btnFindAddress.addEventListener("click", findAddress)


btnOpenForm.addEventListener("click", function createEvent() {
    document.getElementById("form-to-create-event").classList.add("card","formVisible")

})

btnHideForm.addEventListener("click", function () {
    document.getElementById("displayHidden").classList.remove("card","formVisible")
})

//TODO integrar com backend
function createEvent(event, local, address, date) {

}

async function findAddress(event) {

    event.preventDefault() // impede o submit do form

    const cep = document.getElementById("cep").value.replace(/\D/g, "")

    if (cep.length !== 8) {
        alert("CEP inválido")
        return
    }

    const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`)
    const dados = await response.json()

    document.getElementById("address").value = dados.logradouro
    document.getElementById("line2").value = dados.complemento || ""

}