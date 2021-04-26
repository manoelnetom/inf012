import {BrowserRouter, Switch, Route} from 'react-router-dom' 
import Menu from './components/Menu'
import Home from './components/Home'
import Login from './components/Login'
function Rotas(){
    return(
        <BrowserRouter>
            <Menu/>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/login" component={Login}/>
            </Switch>
        </BrowserRouter>
    );
}
export default Rotas;