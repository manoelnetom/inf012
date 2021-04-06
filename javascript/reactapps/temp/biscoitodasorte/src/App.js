import React, {Component} from 'react';
import biscoito from './assets/biscoito.png';
import './App.css'
class App extends Component {
  constructor(props){
    super(props);
    this.state={
        texto:""
    };
    this.frases=['A vida trará coisas boas se tiveres paciência.',
    'Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você.',
    'Não compense na ira o que lhe falta na razão.',
    'Defeitos e virtudes são apenas dois lados da mesma moeda.',
    'A maior de todas as torres começa no solo.',
    'Não há que ser forte.'
    ];
  }

  abrirBiscoito(){
    let numero = Math.floor(Math.random()* this.frases.length);
    this.setState({texto:this.frases[numero]});
  }

  render(){
  return (
    <div className="conteiner">
        <img alt="biscoito" src={biscoito} className="img"/>
        <button onClick={this.abrirBiscoito.bind(this)}>Sortear</button>
        <h1 className="textoFrase">{this.state.texto}</h1>
    </div>

  );
}
}
export default App;
