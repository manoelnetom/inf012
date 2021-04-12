import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Social from './componentes/Social'
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <Social nome="Manoel" idade="43" facebook="www.meuface" instagram="@manoelnetom" />
    <Social nome="Maria" idade="23" facebook="www.meuface" instagram="@Maria" />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();