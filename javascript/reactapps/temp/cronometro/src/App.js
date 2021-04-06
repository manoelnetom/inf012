import cronometro from './assets/cronometro.png';
import './App.css';
import React, {Component} from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tempo: 0.0,
      botao: 'Iniciar'
    };
    this.funcaoTimer = null;
  }

  inciar(){
    let estado = this.state;
   
    if(this.funcaoTimer==null){
      estado.botao = "Pausar";
      this.funcaoTimer = setInterval(()=>{
        estado.tempo+=0.1;
        this.setState(estado);
      }, 100);
    } else {
      estado.botao = 'Inciar';
      clearInterval(this.funcaoTimer);
      this.funcaoTimer = null;
      this.setState(estado);
    }
  }

  limpar() {
    clearInterval(this.funcaoTimer);
    this.setState({ tempo: 0 });
  }

  
  render(){
  return (
    <div className="conteiner">
      <img src={cronometro} className="img" alt="Cronômetro" />
      <a className="timer">{this.state.tempo.toFixed(1)}</a>
      <div className="areaTexto">
        <button onClick={this.inciar.bind(this)} className="botao">{this.state.botao}</button>
        <button onClick={()=>this.limpar()} className="botao">Limpar</button>
      </div>
    </div>

  );
}
}

export default App;
