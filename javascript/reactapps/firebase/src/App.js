import { useState, useEffect } from 'react'
import firebase from './firebaseConnection'


function App() {
  const [titulo, setTitulo] = useState('');
  const [autor, setAutor] = useState('');
  const [id, setId] = useState('');
  const [posts, setPosts] = useState([]);
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [user, setUser] = useState(false);
  const [logedUser, setLogedUser] = useState({});
  useEffect(() => {
    async function loadPosts() {
      await firebase.firestore().collection('posts')
        .onSnapshot((docs) => {
          let lista = [];
          docs.forEach((item) => {
            lista.push({
              id: item.id,
              titulo: item.data().titulo,
              autor: item.data().autor
            })
          })
          setPosts(lista);
        })
    }
    loadPosts();
  }, []);

  useEffect(() => {
    async function checkLogin() {
      await firebase.auth().onAuthStateChanged((user) => {
        if (user) {
          setUser(true);
          setLogedUser({
            uid: user.uid,
            email: user.email,
            photoURL: user.photoURL,
            displayName: user.displayName
          })
        } else {
          setUser(false);
          setLogedUser({});
        }
      })
    }
    checkLogin();
  }, []);
  async function addPost() {
    await firebase.firestore().collection('posts')
      .add({
        titulo: titulo,
        autor: autor
      })
      .then(() => {
        alert("Post add com sucesso");
      })
      .catch((error) => {
        alert('Gerou algume erro');
      })
  }

  async function buscarPost() {
    await firebase.firestore().collection('posts')
      .doc('aYKeoeejj5AqVQXRFg2E')
      .get()
      .then((snapshot) => {
        setTitulo(snapshot.data().titulo);
        setAutor(snapshot.data().autor);
      })
      .catch(() => {
        alert('erro');
      })
  }

  async function buscarPosts() {
    await firebase.firestore().collection('posts')
      .get()
      .then((docs) => {
        let temp = [];
        docs.forEach((doc) => {
          temp.push({
            id: doc.id,
            titulo: doc.data().titulo,
            autor: doc.data().autor
          })
        })
        setPosts(temp);
      })
      .catch(() => {
        alert('erro');
      })
  }

  async function editarPost() {
    await firebase.firestore().collection('posts')
      .doc(id)
      .update({
        autor: autor,
        titulo: titulo
      })
      .then(() => {
        alert('OK');
      })
      .catch(() => {
        alert('Erro');
      })
  }

  async function excluirPost(postId) {
    await firebase.firestore().collection('posts')
      .doc(postId)
      .delete()
      .then(() => {
        alert('Apagou!');
      })
      .catch(() => {
        alert('Erro');
      })
  }

  async function novoUsuario() {
    await firebase.auth()
      .createUserWithEmailAndPassword(email, senha)
      .then((value) => {
        console.log(value);
      })
      .catch((error) => {
        if (error.code === 'auth/weak-password') {
          alert('Senha Fraca');
        } else if (error.code === 'auth/email-already-in-use') {
          alert('Email já em uso');
        }
      })
  }

  async function logout() {
    await firebase.auth().signOut();
  }

  async function login() {
    /*await firebase.auth()
    .signInWithEmailAndPassword(email,senha)
    .then((value)=>{
      console.log(value);
    })
    .catch((error)=>{
      console.log(error);
      alert(error.message);
    })*/
    // Using a popup.
    var provider = new firebase.auth.GoogleAuthProvider();
    provider.addScope('profile');
    provider.addScope('email');
    firebase.auth().signInWithPopup(provider).then(function (result) {
      // This gives you a Google Access Token.
      var token = result.credential.accessToken;
      // The signed-in user info.
      var user1 = result.user;
      console.log(token);
      console.log(user1);
    });
  }
  return (
    <div>
      <h1>FIREBASE + REACT</h1><br />

      {user && (
        <div>
          <strong>Seja Bem-Vindo!</strong>
          <span>{logedUser.uid} - {logedUser.email} - {logedUser.displayName}</span>
          <img src={logedUser.photoURL} alt={logedUser.displayName}/>
        </div>
      )}

      <label>Email: </label>
      <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />

      <label>Senha: </label>
      <input type="password" value={senha} onChange={(e) => setSenha(e.target.value)} />

      <button onClick={() => { novoUsuario() }}>Cadastrar</button>
      <button onClick={() => { login() }}>Fazer Login</button>
      <button onClick={() => { logout() }}>Logout</button>

      <br />
      <h2>Banco de Dados</h2>
      <label>ID</label>
      <input type="text" value={id} onChange={(e) => setId(e.target.value)} />


      <label>Titulo</label>
      <textarea type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)} />

      <label>Autor</label>
      <input type="text" value={autor} onChange={(e) => setAutor(e.target.value)} />

      <button onClick={() => { addPost() }}>Cadastrar</button>
      <button onClick={() => { buscarPost() }}>Buscar Post</button>
      <button onClick={() => { buscarPosts() }}>Buscar Posts</button>
      <button onClick={() => { editarPost() }}>Editar Post</button>
      <br />
      <ul>
        {posts.map((post) => {
          return (
            <li key={post.id}>
              <span> Id: {post.id} </span> <br />
              <span> Titulo: {post.titulo} </span> <br />
              <span> Autor: {post.autor} </span><br />
              <button onClick={() => { excluirPost(post.id) }}>Excluir</button><br /><br />
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default App;
