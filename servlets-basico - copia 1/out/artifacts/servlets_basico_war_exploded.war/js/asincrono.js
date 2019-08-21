$(document).ready(() => {


    $("body").on("click", ".btn-agregar", (evento) => {
        let formulario = document.getElementById("formUsuario");
        formulario.reset();
        $("#idRegistro").val("");
        $(".btn-registrar").html("Registrar");
        $(".modal-title").html("Registrar usuario");
    });


    $("body").on("click", ".btn-actualizar", function() {
        let formulario = document.getElementById("formUsuario");
        formulario.reset();

        let dataid = this.getAttribute("data-id");

        $("#idRegistro").val(dataid);
        $(".btn-registrar").html("Actualizar");
        $(".modal-title").html("Actualizar Registro");

        $.ajax({

            url: "UsuarioServlet",
            method: "POST",
            data: {
                id: dataid,
                accion: "cargarUsuario"
            }
        }).done((response) => {
            console.log(response);
            let persona = JSON.parse(response);
            console.log(persona);



            document.querySelector("#usuario").value =
                persona.usuario;

            document.querySelector("#contrasena").value =
                    persona.contrasena;

            document.querySelector("#rol").value = persona.idRol;



            // traer los campos en donde voy a poner la data que me llega

        }).fail(() => {
            alert("La peticion no pudo realizarse")
        });
    });

    $("body").on("click", ".btn-danger", function () {
        let dataid = this.getAttribute("data-id");
        let btnDanger = this;
        Swal.fire({
            title: 'Estás seguro?',
            text: "No puedes reagendar esta asesoría",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                eliminar(dataid)
                Swal.fire(
                    'Eliminado!',
                    'Your file has been deleted.',
                    'success'
                ).then((result) => {
                    if (result) {
                        btnDanger.parentElement.parentElement.remove();

                    }
                })

            }
        })


    });


    function eliminar(dataid) {
        $.ajax({
            method: "POST",
            url: "UsuarioServlet",
            data: {
                id: dataid,
                accion: "eliminar"
            }
        }).done((response) => {
            if (response == "true") {
                console.log("OK")
            } else {
                alert("El registro no pudo eliminarse");
            }

        }).fail(() => {
            alert("Falló la petición");
        });


    }


    $(".btn-registrar").click(function () {

        //Obtener los datos del formulario
        let formulario = document.getElementById("formUsuario");
        let datos = new FormData(formulario);


        if ($("#idRegistro").val() == "")
            datos.append("accion", "registrar");
        else
            datos.append("accion", "actualizar");


        //llamada asincrona para enviar datos a UsuarioServlet
        $.ajax({
            url: "UsuarioServlet",
            method: "POST",
            processData: false,
            contentType: false,
            data: datos
        }).done((response) => {
            console.log(response);
            if (response == "true") {


                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000
                });

                Toast.fire({
                    type: 'success',
                    title: 'El registro se hizo correctamente.'
                })


                formulario.reset();
                $("#usuario").focus();
            } else if (response == "OK") {

                $("usuario").focus();

                alert("El registro se hizo correctamente")


            } else {

                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-left',
                    showConfirmButton: false,
                    timer: 3000
                });

                Toast.fire({
                    type: 'error',
                    background: "#FADBD8",
                    title: 'No se pudo cancelar tu asesoría'
                })

            }
        }).fail(() => {
            alert("La petición no pudo realizarse");
        }).always(() => {
            $.ajax({
                url: "UsuarioServlet",
                method: "POST",
                data: {
                    accion: "cargar"
                }
            }).done((response) => {
                let tbody = document.querySelector("table tbody");
                while (hijo = tbody.lastChild) {
                    tbody.removeChild(hijo);
                }
                console.log(response);
                let arreglo = JSON.parse(response);
                //tiene tantas posiciones como registros en la
                //tabla
                for (let i in arreglo) {

                    let fila = document.createElement("tr");

                    let uCelda = document.createElement("td");
                    let rCelda = document.createElement("td");
                    let aCelda = document.createElement("td");

                    let uTexto = document.createTextNode(arreglo[i].usuario);
                    let rTexto = document.createTextNode(arreglo[i].rol);

                    let btnEliminarTexto = document.createTextNode("Eliminar");
                    let btnActualizarTexto = document.createTextNode("Actualizar");


                    let btnEliminar = document.createElement("button");
                    btnEliminar.className = "btn btn-danger";
                    btnEliminar.appendChild(btnEliminarTexto);
                    btnEliminar.setAttribute("data-id", arreglo[i].idUsuario);


                    uCelda.appendChild(uTexto);
                    rCelda.appendChild(rTexto);


                    let btnActualizar = document.createElement("button");

                    btnActualizar.className = "btn btn-primary btn-actualizar";
                    btnActualizar.setAttribute("data-toggle", "modal");
                    btnActualizar.setAttribute("data-target", "#modalRegistro");
                    btnActualizar.appendChild(btnActualizarTexto);
                    btnActualizar.setAttribute("data-id", arreglo[i].idUsuario);

                    aCelda.appendChild(btnEliminar);
                    aCelda.appendChild(btnActualizar);


                    fila.appendChild(uCelda);
                    fila.appendChild(rCelda);
                    fila.appendChild(aCelda);

                    tbody.appendChild(fila);


                }
            });
        })
    });


})
;


