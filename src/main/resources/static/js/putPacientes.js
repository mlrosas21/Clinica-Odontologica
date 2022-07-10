window.addEventListener('load', function(){
    const form = document.querySelector('#updateFormPaciente')
    form.addEventListener('submit', function(event){
        const formData={
            id: document.getElementById('formId').value,
            dni: document.getElementById('formDni').value,
            nombre: document.getElementById('formNombre').value,
            apellido: document.getElementById('formApellido').value
        }

        const url = '/pacientes/update'
        const settings = {
            method:'PUT',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(formData)
        }
        fetch(url, settings)
        .then(response=>response.json())
    })
})

function encontrarId(id) {
    const url = '/pacientes/'+id
    const settings={
        mehthod: 'GET'
    }
    fetch(url, settings)
    .then(response => response.json())
    .then(data => {
        let paciente = data;
        document.getElementById('formId').value = paciente.id,
        document.getElementById('formDni').value = paciente.dni,
        document.getElementById('formNombre').value = paciente.nombre,
        document.getElementById('formApellido').value = paciente.apellido

        document.querySelector('#updatingFormPaciente').style.display = 'block'
    }).catch(error => {
        alert('ERROR: '+error)
    })
}

