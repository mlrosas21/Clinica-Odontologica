window.addEventListener('load', function(){

  const url = '/pacientes/list';
  const settings = {
    method: 'GET'
  }

  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
    for(paciente of data){
        let tabla = document.getElementById('tablaPacientes')
        let filaPaciente = tabla.insertRow()
        let idPaciente = 'paciente_'+paciente.id;
        filaPaciente.id = idPaciente;

        let btnBorrarPaciente = '<button id='+'\"'+'btnBorrarId+'+paciente.id+'\"'+' onclick="borrarId('+paciente.id+')" class="btn btn-danger"> X </button>'

        let btnUpdatePaciente = '<button id='+'\"'+'btnUpdateId'+paciente.id+'\"'+' onclick="encontrarId('+paciente.id+')" class="btn btn-danger">'+paciente.id+'</button>'

        filaPaciente.innerHTML = '<td>'+btnUpdatePaciente+'</td>'+
                                '<td>'+paciente.nombre+'</td>'+
                                '<td>'+paciente.apellido+'</td>'+
                                '<td>'+paciente.dni+'</td>' +
                                '<td>'+btnBorrarPaciente+'</td>'
    }
  })
})