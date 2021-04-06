import React, {useState,useEffect, useMemo, useCallback} from 'react';

function TarefaHook(){
    const [texto, setTexto]= useState("");
    const [lista, setLista]= useState([]);

    useEffect(()=>{
       // localStorage.setItem('tarefa',JSON.stringify(lista));
       alert('Componente montou e esta pronto!');
    },[]);

    let tamanho = useMemo(()=>{
        return lista.length;
      },[lista]);
    

    const addTerefa = useCallback(()=>{
        setLista([...lista,texto]);
    },[texto,lista]); 


    return(
    <div>
        <ul>{lista.map((item)=><li>{item}</li>)}</ul>
        <input type="text" value={texto} onChange={(e)=>setTexto(e.target.value)}/>
        <button onClick={()=>addTerefa()}>Add Tarefa</button>
        <h1>O numero total de Tarefas é {tamanho}</h1>
    </div>
    );
}

export default TarefaHook;