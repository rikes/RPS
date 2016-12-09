  Feature: Autenticação de usuário
  	Como um cozinheiro aventureiro
  	Eu quero me logar no Receitas para Solteiros
  	Para cadastrar minhas receitas e receber recomendações
  	
  	
  	Scenario Outline: Testar Login do usuario 		
  		
  		Given Eu ( "<usuario>" ) como um usuario desejo me autenticar no sistema
  			
  		When Eu como usuario devo inserir meu email "<email>" e minha senha "<senha>"
  			  
  		Then O sistema enviará para mim uma mensagem de autenticacao: "<resultado_login>"		  
  		
  		Examples:  		
  		| usuario   | email              | senha   | resultado_login |
  		| Teste     | teste01@rps.com.br | teste01 | Login efetuado com sucesso | 
  		| Henrique  | henrique@gmail.com | 12345   | Email e/ou senha incorreto | 
  		| Teste     | teste01@rps.com.br | TESTE11 | Email e/ou senha incorreto |
  		
