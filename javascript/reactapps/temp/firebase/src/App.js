import Rotas from './routes';
import UserProvider from './contexts/user';

function App() {
  return (
    <UserProvider>
    <div>
      <Rotas/>
    </div>
    </UserProvider>
  );
}
export default App;
