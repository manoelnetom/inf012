import React,{ Component } from "react";

class App extends Component{
  
  constructor(props){
    super(props);
    this.state ={
      timer:"00:00:00"
    };
  }

  componentDidUpdate(){
    alert('Atualizou');
  }

  setTime(){
    this.setState({timer:new Date().toLocaleTimeString()});
  }

  render(){
      return(
        <div>
          <h1>Timer: {this.state.timer}</h1>
          <button onClick={this.setTime.bind(this)}>Atualizar</button>
        </div>
      );

  }
}
export default App;