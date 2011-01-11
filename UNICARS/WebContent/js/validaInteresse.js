/**
 * JavaScript che controlla l'inserimento di tutti i campi
 */

function validaInteresse() {
     // Variabili associate ai campi del modulo
     var nome = document.interesse.nome.value;
     var cognome = document.interesse.cognome.value;
     var contatto = document.interesse.contatto.value;
     
     var nome_reg_exp = /^[a-zA-Z]{3,30}$/;
     var contatto_reg_exp = /^[a-zA-Z0-9.@,:;\"'-_ ]*$/;
    	 //Effettua il controllo sul campo NOME
        if (nome == null || nome == "" || !nome_reg_exp.test(nome) ) {
           alert("Il campo Nome deve avere almeno 3 lettere e non contenere numeri.");
           document.interesse.nome.focus();
           return false;
        }
        //Effettua il controllo sul campo COGNOME
        else if (cognome == null || cognome == "" || !nome_reg_exp.test(cognome) ) {
           alert("Il campo Cognome deve avere almeno 3 lettere e non contenere numeri.");
           document.interesse.cognome.focus();
           return false;
        }
     	//Effettua il controllo sul campo CONTATTO
        else if (contatto == null || contatto == "" || !contatto_reg_exp.test(contatto) ) {
            alert("Il campo Contatto è obbligatorio.");
            document.interesse.contatto.focus();
            return false;
         }
         document.interesse.action = "SegnalaInteresse";
	     document.interesse.submit();
  }