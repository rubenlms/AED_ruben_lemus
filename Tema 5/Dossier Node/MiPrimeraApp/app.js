const fs = require('fs');
function getTabla( tabla){
let limite = 10;
let respuesta =
`---------------------------
TABLA DEL ${tabla}
---------------------------
`;

function getTabla(tabla){
    let limite=10;
    let respuesta="";
    
    for(let i=1;i<=limite;i++){
        respuesta += `${i} = ${tabla*i}\n`;
    }

    return respuesta;

}

//writeFile() es asíncrono. Así que hay un callback
fs.writeFile(
    'tabla.txt', //nombre del fichero
    getTabla(4), //información a guardar
    (err)=>{ //callback respuesta al finalizar
    if(err)
    throw err;
    else
    console.log("se ha grabado");
    }
);
