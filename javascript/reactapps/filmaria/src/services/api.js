import axios from 'axios';

////https://sujeitoprogramador.com/r-api/?api=filmes

//Base URL: https://sujeitoprogramador.com/

//Rota TODOS OS FILMES: r-api/?api=filmes

// Filme com ID: r-api/?api=filmes/556

const api = axios.create({
    baseURL:'https://sujeitoprogramador.com'
});
export default api;