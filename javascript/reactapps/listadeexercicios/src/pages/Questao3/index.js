import { useCallback, useEffect, useState } from "react";

function Questao3(){
    
    const[numero, setNumero]= useState(0);
    const[sorteado, setSorteado]=useState(0);
    const [resultado, setResultado]=useState("");
    useEffect(()=>{
        setSorteado(Math.floor(Math.random()*100))
    },[]);


    let calcular= useCallback(()=>{
        alert(sorteado);
        if(numero>sorteado){
            setResultado("o numero é menor");
        }else if(numero<sorteado){
            setResultado("o numero é maior");
        }else{
            setResultado("acertou");
        }
    },[numero,sorteado]);

    return(
        <div>
            <header>Questão 3</header>
            <p>Escreva uma solução web que atenda aos requisitos do jogo
"zero a cem". Construa o formulário HTML que permita ao
jogador digitar um numero para tentar adivinhar o número
sorteado pelo sistema. O programa do lado servidor deve
receber o número passado e verificar se ele coincide com o
numero sorteado. Em caso positivo, o usuário deve ser
informado com a string "parabens vc ganhou", caso contrario
as informações de “é maior” ou “é menor” devem ser passadas
para o usuário, e uma nova tentativa pode ser realizada.
OBS.: A 1º vez que rodar o programa: A) sortear o número,
B)comparar com o numero passado com o numero sorteado, e C)
"você acertou" ou "é maior" ou “é menor”.
A partir daí: repetir se necessário B) e C).</p>
            <div className="conteiner">
                <input type="text" value={numero} onChange={(e)=>setNumero(e.target.value)}  placeholder="Digite um numero"/>
                <button onClick={()=>calcular()}>Calcular</button>
                <p>Resultado: {resultado}</p>
            </div>
        </div>
    );
}
export default Questao3;