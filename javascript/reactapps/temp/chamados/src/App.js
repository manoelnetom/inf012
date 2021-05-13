import { BrowserRouter } from "react-router-dom";
import Rotas from './routes/index';
import AuthProvider from './contexts/auth';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
function App() {
  return (
    <AuthProvider>
      <ToastContainer autoClose={3000}/>
      <BrowserRouter>
        <Rotas/>
      </BrowserRouter>
    </AuthProvider>   
  );
}

export default App;
