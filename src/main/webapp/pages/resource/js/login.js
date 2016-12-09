
 //Sem regex (Nao funcionou)
 function validateForm() {
      document.write(5 + 6);
     var x = document.forms["myForm"]["email"].value;
     var arroba = x.indexOf("@");
     var ponto = x.lastIndexOf(".");
     if (arroba !== 1 || ponto < 1) {
         alert("Not a valid e-mail address");
         return false;
     }
 }
 //Com regex
 function validaEmail(inputEmail) {
      
     var emailFormat = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
     var emailFomat2 = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
     var format = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
     if (inputEmail.value.match(emailFormat)) {
         document.formLogin.email.focus();
         return true;
     } else {
         alert("Email incorreto");
         return false;
     }  
 }

 //Falta fazer o dataGet
 function dataGet() {
     //Carrega o valor, caso não exista carrega 'usuário' como padrão
     var valorTemp = localStorage.getItem("valor") || "usuário";  
     
     //Escrevo ele
     document.getElementById("user").innerHTML = valorTemp;
 }
//Salvar o usuário logado usando LocalSotarge

 function dataSave() {
     var email = document.formLogin.email.value;
     localStorage.setItem("valor", email); // Salva o valor usando lcoalStorage
     dataGet();
    
 }

