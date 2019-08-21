let onReady = () => {
    fetch("EstadoServlet")
        .then(function (response) {
            return response.json();
        })
        .then(function (json) {
            json.forEach((element) => {
                let texto = document.createTextNode(element.nombre);
                let opcion = document.createElement("option");
                opcion.value = element.idEstado;
                opcion.appendChild(texto);
                document.querySelector("#estado").appendChild(opcion);
            });
        });

    let municipios = () => {

        let datos = {idEstado: document.querySelector("#estado").value};

        fetch("MunicipioServlet", {
            method: 'POST',
            body: JSON.stringify(datos)
        })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                while (hijo = document.querySelector("#municipio").lastChild) {
                    document.querySelector("#municipio").removeChild(hijo);
                }

                let texto = document.createTextNode("Selecciona una opción");
                let opcion = document.createElement("option");
                opcion.value = 0;
                opcion.appendChild(texto);
                document.querySelector("#municipio").appendChild(opcion);

                json.forEach((element) => {
                    let texto = document.createTextNode(element.nombre);
                    let opcion = document.createElement("option");
                    opcion.value = element.idMunicipio;
                    opcion.appendChild(texto);
                    document.querySelector("#municipio").appendChild(opcion);
                });
            });
    }
    document.querySelector("#estado").addEventListener("change", municipios);

}

addEventListener("DOMContentLoaded", onReady);