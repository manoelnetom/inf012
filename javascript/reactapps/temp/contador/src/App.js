import React,{ Component } from "react";
import Feed from "./components/Feed";
import Membro from './components/Membro';

class App extends Component{

  constructor(props){
    super(props);
    this.state = {
      feed:[
        {id:1, nome:'Manoel', curtidas:34, comentarios:23},
        {id:2, nome:'Maria', curtidas:45, comentarios:12},
        {id:3, nome:'Joao', curtidas:102, comentarios:70},
        {id:3, nome:'Ricardo', curtidas:1, comentarios:0},
        ] 
    };

  }

  render(){
      return(
        <div>
          {this.state.feed.map((item)=>{
            return (
            <Feed id={item.id} nome={item.nome} 
            curtidas={item.curtidas} 
            comentarios={item.comentarios}/>);
            })}
        
            </div>
      );

  }
}
export default App;