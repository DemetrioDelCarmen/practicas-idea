let onReady = () =>{



    let validarItems = () => {

        // let table = document.querySelector("table");
        // for(var i  =0; i<table.rows.length;i++){
        //     if(document.querySelector("input [type=text]").value!="" && document.querySelector("input[type=number]")[i-1].value!=0){
        //         var btnAdd = document.querySelector("btn btn-add m-2");
        //         btnAdd.disabled = true;
        //     }
        // }

        document.querySelectorAll("#agregar").disabled= true;
    }


    var k = 0;


    var tablaItems = document.createElement("table")
    tablaItems.setAttribute("id","tablaCompras")
    tablaItems.className = "table"


    document.querySelector("#itemPrecio").onchange = function(){

        document.querySelector("#inputTotal").value = Number(document.querySelector("#itemCantidad").value) *
            Number(document.querySelector("#itemPrecio").value);
    }










    let agregarItems = ()=>{
        k++;
        let fila  = document.createElement("tr")

        let cCodigo = document.createElement("td")
        let iCodigo = document.createElement("input")
        iCodigo.type = "text"
        iCodigo.setAttribute("class","iCodigo form-control m-2")
        cCodigo.appendChild(iCodigo)

        let cNombre = document.createElement("td")
        let iNombre = document.createElement("input")
        iNombre.type = "text"
        iNombre.setAttribute("class","iNombre form-control m-2")
        cNombre.appendChild(iNombre)


        let cCantidad = document.createElement("td")
        let iCantidad = document.createElement("input")
        iCantidad.type  = "number"
        iCantidad.id = "cantidad" + k;
        iCantidad.setAttribute("class","iCantidad  form-control m-2")
        cCantidad.appendChild(iCantidad)

        let cPrecio = document.createElement("td")
        let itemPrecio = document.createElement("input")
        itemPrecio.type = "number"
        itemPrecio.id = "precio" + k;
        itemPrecio.onchange = function(){
            var id = new String(this.id).substr(6);

            document.querySelector("#total" + id).value = Number(document.querySelector("#cantidad" + id).value) *
                Number(document.querySelector("#precio" + id).value);

        }
        itemPrecio.setAttribute("class","iPrecio form-control m-2")
        cPrecio.appendChild(itemPrecio);


        let cTotal = document.createElement("td")
        let iTotal = document.createElement("input")
        iTotal.type = "number"
        iTotal.disabled = true;
        iTotal.id = "total" + k;
        iTotal.setAttribute("class","iTotal form-control m-2")
        cTotal.appendChild(iTotal)




        let cBtnAgregar = document.createElement("td")
        let iBtnAgregar = document.createElement("input")
        iBtnAgregar.type = "button"
        iBtnAgregar.id = "agregar"
        iBtnAgregar.value = "Agregar"
        iBtnAgregar.className = "btn btn-add m-2"
        iBtnAgregar.onclick = agregarItems
        cBtnAgregar.appendChild(iBtnAgregar)


        let cBtnEliminar = document.createElement("td")
        let iBtnEliminar = document.createElement("input")
        iBtnEliminar.value = "Eliminar"
        iBtnEliminar.type = "button"
        iBtnEliminar.className = "btn btn-delete m-2"
        iBtnEliminar.setAttribute("id","eliminar")
        iBtnEliminar.onclick = deleteItems
        cBtnEliminar.appendChild(iBtnEliminar)


        fila.appendChild(cCodigo)
        fila.appendChild(cNombre)
        fila.appendChild(cCantidad)
        fila.appendChild(cPrecio)
        fila.appendChild(cTotal)
        fila.appendChild(cBtnAgregar)
        fila.appendChild(cBtnEliminar)

        document.querySelector("tbody").appendChild(fila)
    }


    let deleteItems =  ()=>{

        let index, table = document.querySelector('table');
        for(let i = 1; i < table.rows.length; i++)
        {
            table.rows[i].cells[6].onclick = function()
            {
                let cEliminar = confirm("¿Deseas eliminar este producto de tu compra?");
                if(cEliminar === true)
                {
                    index = this.parentElement.rowIndex;
                    table.deleteRow(index);
                }

                console.log(index);
            };

        }


    }




    let  crearNota = () =>{
        let areaToReplace = document.querySelector("#infoDiv")

        var subtotal =0;
        var ttTotal =0;
        var resultCompra =0;
        var iva = 0;
        /* for que crea todo */
        let table = document.querySelector('table');
        let productoNombre =  document.getElementsByClassName("iNombre");
        let productoPrecio =  document.getElementsByClassName("iPrecio");

        let productoCodigo  =  document.getElementsByClassName("iCodigo");
        let productoCantidad=  document.getElementsByClassName("iCantidad");
        let productoTotal = document.getElementsByClassName("iTotal")

        for(let i = 1; i < table.rows.length; i++){

            if(productoNombre[i-1].value !="" && Number(productoPrecio[i-1].value)>0 && productoCodigo[i-1].value!=""&&
                Number(productoCantidad[i-1].value)>0){


                let fila = document.createElement("tr")

                let columnaNombre  = document.createElement("td")
                let textoNombre = document.createTextNode(productoNombre[i-1].value)


                columnaNombre.appendChild(textoNombre)

                let columnaPrecio = document.createElement("td")
                let valorPrecio = document.createTextNode(productoPrecio[i-1].value)
                columnaPrecio.appendChild(valorPrecio)



                fila.appendChild(columnaNombre)
                fila.appendChild(columnaPrecio)

                tablaItems.appendChild(fila)

                subtotal += Number(productoTotal[i-1].value)




            }else{
                alert("Todos los campos deben estar llenos")
            }
            resultCompra = subtotal *1.16;




        };
        /* end for que crea todo */




        document.querySelector("#Asubtotal").innerHTML = subtotal
        document.querySelector("#Atotal").innerHTML = resultCompra
        areaToReplace.appendChild(tablaItems)



    }



    document.querySelector("#crearNota").addEventListener("click",crearNota)
    document.querySelector("#agregar").addEventListener("click",agregarItems)
    document.querySelector("#eliminar").addEventListener("click",deleteItems)
    document.querySelector("#crearNota").addEventListener("click",crearNota)
    document.addEventListener("DOMContentLoaded",validarItems)
}

document.addEventListener("DOMContentLoaded",onReady)