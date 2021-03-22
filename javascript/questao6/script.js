function acionarButao(){
   let botao = document.getElementById('botao');
   let lampada = document.getElementById('lampada');
   if(botao.value == 'Ligar'){
        lampada.src="./imgs/acesa.jpeg";
        botao.value = 'Desligar';
   }else{
       lampada.src="./imgs/apagada.jpeg";
       botao.value = 'Ligar';
   }
}