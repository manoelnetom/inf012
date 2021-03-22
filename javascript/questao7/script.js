function acionarButao(){
    let img = document.getElementById('lampada');
    let botao = document.getElementById('botao').value;
    if(botao==='Ligar'){
       img.src='./imgs/acesa.jpeg';
       document.getElementById('botao').value= 'Desligar';
    }else{
        img.src='./imgs/apagada.jpeg';
        document.getElementById('botao').value= 'Ligar';
    }
}