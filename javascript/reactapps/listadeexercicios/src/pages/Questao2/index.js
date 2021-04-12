import { useCallback, useMemo, useState } from "react";

function Questao2(){
    const [conta, setConta]= useState(0);
    const [pessoas, setPessoas]=useState(0);
    const [gorjeta, setGorjeta]=useState(0);
    const [resultado, setResultado]=useState("");
    let calcular=useCallback(()=>{
        let percentual = conta*(gorjeta/100);
        let total = parseFloat(conta) + parseFloat(percentual);
        let ttp=parseFloat(total/pessoas);
        setResultado("O Total com gorjeta foi de R$"+ parseFloat(total) 
        + " O total por pessoas foi de " + parseFloat(ttp));
    },[conta,pessoas,gorjeta]);



    return(
        <div>
            <header>Questão 2</header>
            <p>Escreva uma solução web que permita a um restaurante
emitir a conta de uma mesa. Para isso construa um form HTML
que permita ao usuário digitar o total gasto na mesa, o
numero de pessoas sentadas a mesa e o percentual pago como
gorjeta. O programa do lado servidor deve, a partir dos
parâmetros passados pelo form HTML, calcular e exibir o total
geral e o total por pessoa.</p>
            <div className="conteiner">
                <input type="text" value={conta} onChange={(e)=>setConta(e.target.value)}  placeholder="Valor Total"/>
                <input type="text" value={pessoas} onChange={(e)=>setPessoas(e.target.value)} placeholder="Numero de Pessoas"/>
                <input type="text" value={gorjeta} onChange={(e)=>setGorjeta(e.target.value)} placeholder="Percentual Gorjeta"/>
                <button onClick={()=>calcular()}>Calcular</button>
                <p>Resultado: {resultado}</p>
            </div>
        </div>
    );
}
export default Questao2;