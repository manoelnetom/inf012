import React, { Component } from 'react';
import cronometro from './assets/cronometro.png';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tempo: 0.0,
      botao: 'Vai'
    };

    this.funcaoTimer = null;
  }

  vai() {
    let estado = this.state;
    if (this.funcaoTimer == null) {
      estado.botao = 'Pausar';
      this.funcaoTimer = setInterval(() => {
        estado.tempo += 0.1;
        this.setState(estado);
      }, 100);
    } else {
      estado.botao = 'Vai';
      clearInterval(this.funcaoTimer);
      this.funcaoTimer = null;
      this.setState(estado);
    }
  }

  limpar() {
    clearInterval(this.funcaoTimer);
    this.setState({ tempo: 0 });
  }

  render() {
    return (
      <div className="conteiner">
        <img alt="crono" src={cronometro} className="img" />
        <a className="timer">{this.state.tempo.toFixed(1)}</a>
        <div className="areaTexto">
          <button className="botao" onClick={this.vai.bind(this)}>{this.state.botao}</button>
          <button className="botao" onClick={this.limpar.bind(this)}>Limpar</button>
        </div>
      </div>

    );
  }
}

export default App;
