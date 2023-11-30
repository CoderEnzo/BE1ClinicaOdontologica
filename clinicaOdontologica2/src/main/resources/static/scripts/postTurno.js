window.onload = () => {
    const formulario = document.getElementById("formularioTurno");
    formulario.addEventListener("submit", event => {
        event.preventDefault();
        agregarTurno();
    });
}

async function buscarOdontologo(id) { 
    const response = await fetch("http://localhost:8080/odontologos/" + id)
    return response.json();
}
console.log(buscarOdontologo(1));

async function buscarPaciente(id) {
    const response = await fetch("http://localhost:8080/pacientes/" + id)
    return response.json();
}
console.log(buscarPaciente(1));

async function agregarTurno() {
    
    const idOdontologo = document.getElementById("idOdontologo");
    const idPaciente = document.getElementById("idPaciente");
    const fecha = document.getElementById("fecha");
    const hora = document.getElementById("hora");
    

    const formData = {
      paciente: await buscarPaciente(idPaciente.value),
      odontologo: await buscarOdontologo(idOdontologo.value),
      date : `${fecha.value}T${hora.value}`
    };
    console.log(formData);

    const settings = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    };

    await fetch("http://localhost:8080/turnos/", settings)
      .then((response) => response.json())
      .then(() => alert("Se creó el turno"))
      .catch((e) => {
      console.log(e);
      alert("No se pudo crear el turno")})
      .finally(() => {
          idOdontologo.value = "";
          idPaciente.value = "";
          fecha.value = "";
          hora.value = "";
      })
}