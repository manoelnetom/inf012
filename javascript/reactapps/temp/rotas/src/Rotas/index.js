
import { BrowserRouter, Route, Switch} from 'react-router-dom';
import Sobre from '../pages/Sobre';
import Home from '../pages/Home';
import Erro from '../pages/Erro';
import Menu from '../components/Menu';

function Rotas(){
    return(
        <BrowserRouter>
        <Menu/>
        <Switch>
          <Route exact path="/" component={Home}/>
          <Route path="/sobre" component={Sobre}/>
          <Route path="*" component={Erro}/>
        </Switch>
        </BrowserRouter>
    );

}
export default Rotas;