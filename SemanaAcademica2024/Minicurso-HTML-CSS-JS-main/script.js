let count = 0
const span = document.getElementById('contador')
//span.innerText = 'OIE'

function incrementar(valor) {
    count += valor
    span.innerText = count
}