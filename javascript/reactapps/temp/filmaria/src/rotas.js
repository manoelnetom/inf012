import {BrowserRouter, Switch, Route} from 'react-router-dom'
import Header from './components/Header';
import Home from './pages/Home';

export default function Rotas(){
    return(
        <BrowserRouter>
            <Header/>
            <Switch>
                <Route exact path="/" component={Home}/>
            </Switch>
        </BrowserRouter>
    );
}