import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Social from './components/Social';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
   <Social nome="Manoel" idade="43" facebook="@mano" instagram="@manoel"/>
   <Social nome="Maria" idade="23" facebook="@mari" instagram="@Maria"/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
