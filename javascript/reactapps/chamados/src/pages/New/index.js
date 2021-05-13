import { useState, useEffect } from 'react';
import Header from '../../components/Header';
import Title from '../../components/Title';
import { FiPlusCircle } from 'react-icons/fi';
import { toast } from 'react-toastify';
import './new.css';
import firebase from '../../services/firebaseConnection';

export default function New() {

    const [clientes, setClientes] = useState([]);
    const [loadingClientes, setLoadingClientes] = useState(true);
    const [clienteSelecionado, setClienteSelecionado] = useState(0);
    const [assunto, setAssunto] = useState('Suporte');
    const [status, setStatus] = useState('Aberto');
    const [complemento, setComplemento] = useState('');


    useEffect(() => {
        async function loadClientes() {
            await firebase.firestore().collection('costumers')
                .get()
                .then((snapshot) => {
                    let lista = [];
                    snapshot.forEach((doc) => {
                        lista.push({
                            id: doc.id,
                            nome: doc.data().nome
                        });
                    });
                    setClientes(lista);
                    setLoadingClientes(false);
                })
                .catch(() => {
                    setClientes([{ id: 1, nome: "Sem cliente" }]);
                    setLoadingClientes(false);
                    toast.error('Erro');
                })
        }
        loadClientes();
    }, []);

    async function handleChamado(e) {
        e.preventDefault();
        let chamado={
            cliente:clientes[clienteSelecionado].id,
            assunto: assunto,
            status:status,
            complemento:complemento
        };
        await firebase.firestore().collection('chamados')
        .add(chamado)
        .then(()=>{
            toast.success('Chamado cadastrado com sucesso');
        })
        .catch(()=>{
            toast.error('Ops!');
        }) 
    }

    return (
        <div>
            <Header />

            <div className="content">
                <Title nome="Novo chamado">
                    <FiPlusCircle size={25} />
                </Title>

                <div className="container">

                    <form onSubmit={(e) => { handleChamado(e) }} className="form-profile">
                        <label>Cliente</label>
                        {loadingClientes ?
                            <input type="text" value="Carregando..." />
                            : <select value={clienteSelecionado} onChange={(e) => setClienteSelecionado(e.target.value)}>
                                {clientes.map((item, index) => {
                                    return (<option key={item.id} value={index}>{item.nome}</option>);
                                })}
                            </select>
                        }


                        <label>Assunto</label>
                        <select value={assunto} onChange={(e) => setAssunto(e.target.value)}>
                            <option value="Suporte">Suporte</option>
                            <option value="Financeiro">Financeiro</option>
                            <option value="Visita">Visita</option>
                        </select>

                        <label>Status</label>
                        <div className="status">
                            <input
                                type="radio"
                                name="radio"
                                value="Aberto"
                                onChange={(e) => setStatus(e.target.value)}
                                checked={status === "Aberto"} />
                            <span>Em Aberto</span>

                            <input
                                type="radio"
                                name="radio"
                                value="Progresso"
                                onChange={(e) => setStatus(e.target.value)}
                                checked={status === "Progresso"} />
                            <span>Em Progresso</span>

                            <input
                                type="radio"
                                name="radio"
                                value="Atendido"
                                onChange={(e) => setStatus(e.target.value)}
                                checked={status === "Atendido"} />
                            <span>Atendido</span>
                        </div>
                        <label>Complemento</label>
                        <textarea type="text"
                            placeholder="Descreva seu problema aqui"
                            value={complemento}
                            onChange={(e) => setComplemento(e.target.value)} />

                        <button type="submit">Registrar</button>
                    </form>

                </div>

            </div>
        </div>
    );
}