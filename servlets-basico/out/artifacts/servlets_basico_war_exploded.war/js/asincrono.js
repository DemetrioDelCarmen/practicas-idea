let onReady = () => {

    let borrar = function () {
        if (confirm("Estás seguro de que quieres borrar el registro?")) {

            let id = this.getAttribute("data-id");
            let btnDanger = this;
            let httpRequest = ajax();
            if (httpRequest) {
                httpRequest.onreadystatechange = () => {
                    if (httpRequest.readyState == 4) {
                        if (httpRequest.status == 200) {
                            if (httpRequest.response == "true") {
                                //elimine la fila de la tabla
                                btnDanger.parentElement.parentElement.remove();
                            } else {
                                alert("El registro no pudo eliminarse");
                            }

                        } else {
                            alert("Hubo problemas con la petición");
                        }
                    }
                }

                httpRequest.open('POST', 'UsuarioServlet', true);
                let datos = new FormData();
                datos.append("id", id);
                datos.append("accion", "eliminar");

                httpRequest.send(datos);
            }
        }
    }

    let etiquetas = document.getElementsByClassName("btn-danger");
    for (let i = 0; i < etiquetas.length; i++) {
        etiquetas[i].addEventListener("click", borrar);
    }


}

addEventListener("DOMContentLoaded", onReady);