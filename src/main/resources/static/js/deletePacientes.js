function borrarId(id){
    const url = '/pacientes/delete/' + id
    const settings = {
        method: 'DELETE'
    }
    fetch(url, settings)
    .then(response => response.json())

    let idFila = 'paciente_' + id
    document.getElementById(idFila).remove()
}