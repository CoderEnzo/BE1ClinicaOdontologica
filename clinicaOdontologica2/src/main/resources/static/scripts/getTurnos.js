window.onload = () => {
  fetch("http://localhost:8080/turnos/")
      .then((response) => response.json())
      .then((data) => cargarInformacionTurnos(data))
      .catch(e => console.log(e))
};

function cargarInformacionTurnos(turnos) {
  console.log(turnos);
  const tablaTurnos = document
  
    .getElementById("tablaTurnos")
    .getElementsByTagName("tbody")[0];
    
  turnos.forEach((turno) => {
    const fecha = turno.date.slice(0,-13).split("T");
    const mensaje = "Día: "+fecha[0]+"\nHora: "+fecha[1];
    tablaTurnos.innerHTML += `
        <tr>
            <td>${turno.id}</td>
            <td>${turno.paciente.id}</td>
            <td>${turno.odontologo.id}</td>
            <td>${mensaje}</td> 
        </tr>
    `;
  });
}