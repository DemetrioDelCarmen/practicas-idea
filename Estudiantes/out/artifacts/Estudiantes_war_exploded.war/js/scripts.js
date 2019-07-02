let onReady = () =>{

        let guardar = () =>{
         /**
          * 1 Recuperar los valores de los controles y almacenarlos en variables
          *  2.- mandarlos a la tabla
          */


          let nombre = document.querySelector("#nombre").value
          let matricula = document.querySelector("#matricula").value
          let apellidos = document.querySelector("#apellidos").value
          let asignatura = document.querySelector("#asignatura").value
          let calificacion = document.querySelector("#calificacion").value

            /**
             * 2.1 Crear la fila
             */
            let fila  = document.createElement("tr")
            // 2.2 crear las columnas
            let columna1  = document.createElement("td")
            let columna2  = document.createElement("td")
            let columna3  = document.createElement("td")
            let columna4  = document.createElement("td")
            let columna5  = document.createElement("td")
            //2.3 asignar los valores  a las columnas
            let texto1 = document.createTextNode(matricula)
            let texto2 = document.createTextNode(nombre)
            let texto3 = document.createTextNode(apellidos)
            let texto4 = document.createTextNode(asignatura)
            let texto5 = document.createTextNode(calificacion)

            //2.4 ensamblar fila
            columna1.appendChild(texto1)
            columna2.appendChild(texto2)
            columna3.appendChild(texto3)
            columna4.appendChild(texto4)
            columna5.appendChild(texto5)
            
                fila.appendChild(columna1)
                fila.appendChild(columna2)
                fila.appendChild(columna3)
                fila.appendChild(columna4)
                fila.appendChild(columna5)

            //agregar la fila a la tabla

            document.querySelector("table").appendChild(fila)

            document.querySelector("form").reset();


        }
        document.querySelector("#guardar")
        .addEventListener("click",guardar)

}

addEventListener("DOMContentLoaded",onReady)