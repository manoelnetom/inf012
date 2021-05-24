
import { useState } from "react";
import { FiHome, FiPlus,FiSearch,FiEdit2 } from "react-icons/fi";
import { Link } from "react-router-dom";
import Header from "../../components/Header";
import Title from "../../components/Title";
import './dashboard.css';

export default function Dashboard() {
   const [chamados, setChamados]=useState([1]);
    
    return(
        <div>
            <Header/>
            <div className="content">
                <Title nome="Chamados">
                    <FiHome size={25}/>
                </Title>
            </div>
         
         {chamados.length===0 ? (
             <div className="container dashboard">
                 <span>Nenhum chamado registrado...</span>
                 <Link to="/new" className="new">
                     <FiPlus size={25} color="#FFF"/>
                     Novo Chamado
                 </Link>
             </div>
         ) : (
             <>
                 <Link to="/new" className="new">
                     <FiPlus size={25} color="#FFF"/>
                     Novo Chamado
                 </Link>
                 <table>
              <thead>
                <tr>
                  <th scope="col">Cliente</th>
                  <th scope="col">Assunto</th>
                  <th scope="col">Status</th>
                  <th scope="col">Cadastrado em</th>
                  <th scope="col">#</th>
                </tr>
              </thead>
              <tbody>
                    <tr>
                    <td data-label="Cliente">Manoel</td>
                    <td data-label="Assunto">Qualqyer</td>
                    <td data-label="Status">Em progresso</td>
                    <td data-label="data">24/03/2021</td>
                    <td data-label="#">
                    <button className="action"  style={{backgroundColor: '#3583f6' }}>
                      <FiSearch color="#FFF" size={17} />
                    </button>
                    <button className="action" style={{backgroundColor: '#F6a935' }}>
                      <FiEdit2 color="#FFF" size={17} />
                    </button>
                    </td>
                    
                    </tr>
              </tbody>
              </table>
             </>
         )}
        </div>
    );
}