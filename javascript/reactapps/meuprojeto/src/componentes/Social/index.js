import React from 'react';


function Sobre(props){
    return(
    <div>
        <h1>Olá {props.nome} você tem {props.idade}</h1>
    </div>
    );
}


function Social(props){
    return (
    <div>
        <Sobre nome={props.nome} idade={props.idade}/>
        <h1>Facebook {props.facebook}</h1>
        <h1>Instagram {props.instagram}</h1>
    </div>
    );
}
export default Social;