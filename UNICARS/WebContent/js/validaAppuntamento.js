/**
 * 
 */

function validaAppuntamento() {
     // Variabili associate ai campi del modulo
     var nome = document.appuntamento.nome.value;
     var cognome = document.appuntamento.cognome.value;
     var ora = document.appuntamento.ora.value;
     var data = document.appuntamento.data.value;
     var contatto = document.appuntamento.contatto.value;
     var descrizione = document.appuntamento.descrizione.value;
     
     var string = String (document.location).split('=');
     var string = string[1].split('&');
     //alert(string[0]);
     // Espressione regolare dell'email
     var nome_reg_exp = /[a-zA-Z]{3,30}/;
     var email_reg_exp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
     var data_reg_exp = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)[0-9]{2}$/;
     var ora_reg_exp = /^([0-1][0-9]|2[0-3]):([0-5][0-9])$/;
     var contatto_reg_exp = /[a-zA-Z0-9 ]*/;
    	 //Effettua il controllo sul campo NOME
        if (nome == null || nome == "" || !nome_reg_exp.test(nome) ) {
           alert("Il campo Nome deve avere almeno 3 caratteri.");
           document.appuntamento.nome.focus();
           return false;
        }
        //Effettua il controllo sul campo COGNOME
        else if (cognome == null || cognome == "" || !nome_reg_exp.test(cognome) ) {
           alert("Il campo Cognome deve avere almeno 3 caratteri.");
           document.appuntamento.cognome.focus();
           return false;
        }
        //Effettua il controllo sul campo DATA
        else if (data == null || data == "" || !data_reg_exp.test(data) ) {
            alert("Il formato del campo Data deve essere gg/mm/aaaa.");
            document.appuntamento.data.focus();
            return false;
         }
     	//Effettua il controllo sul campo ORA
        else if (ora == null || ora == "" || !ora_reg_exp.test(ora) ) {
            alert("Il formato del campo Ora deve essere hh:mm.");
            document.appuntamento.ora.focus();
            return false;
         }
     	//Effettua il controllo sul campo CONTATTO
        else if (contatto == null || contatto == "" || !contatto_reg_exp.test(contatto) ) {
            alert("Il campo Contatto è obbligatorio.");
            document.appuntamento.contatto.focus();
            return false;
         }
     	//Effettua il controllo sul campo DESCRIZIONE
        else if (descrizione == null || descrizione == "" || !contatto_reg_exp.test(descrizione) ) {
            alert("Il campo Descrizione è obbligatorio.");
            document.appuntamento.descrizione.focus();
            return false;
         }
        if(string[0] == "inserisciAppuntamento"){
	       	 document.appuntamento.action = "InserisciAppuntamento";
	       	 document.appuntamento.submit();
        }else if(string[0] == "modifica"){
	    	 document.appuntamento.action = "ModificaAppuntamento";
	    	 document.appuntamento.submit();
        }

  }