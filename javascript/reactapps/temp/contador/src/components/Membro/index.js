import React,{ Component } from "react";

class Membro extends Component{
  
  constructor(props){
    super(props);
    this.state ={
      nome:props.nome
    };
  }

  logar(nome){
      let state = this.state;
      state.nome=nome;
      this.setState(state);
  }

  sair(){
    let state = this.state;
    state.nome="Visitante";
    this.setState(state);
  }

  render(){
      return(
        <div>
            <h1>Seja Bem-Vindo {this.state.nome}</h1>
            <button onClick={()=> this.logar("Joao")}>Logar</button>
            <button onClick={()=> this.sair()}>Sair</button>
        </div>
      );

  }
}
export default Membro;