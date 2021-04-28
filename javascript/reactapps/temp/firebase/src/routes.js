import {BrowserRouter, Switch, Route} from 'react-router-dom' 
import Menu from './components/Menu'
import Home from './components/Home'
import Login from './components/Login'
import Usuarios from './components/Usuarios'
function Rotas(){
    return(
        <BrowserRouter>
            <Menu/>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/login" component={Login}/>
                <Route exact path="/usuarios" component={Usuarios}/>
            </Switch>
        </BrowserRouter>
    );
}
export default Rotas;