
import './index.css'
import Rotas from './rotas.js'
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from 'react-toastify'

//https://sujeitoprogramador.com/r-api/?api=filmes
//https://sujeitoprogramador.com/r-api/?api=filmes/546
function App() {
  return (
    <div className="app">
     <Rotas/>
     <ToastContainer autoClose={3000}/>
    </div>
  );
}

export default App;
