/**
 * 
 */

function validaVendita() {
     // Variabili associate ai campi del modulo
     var codFis = document.vendita.codFis.value;
     var telaio = document.vendita.telaio.value;
     var data = document.vendita.data.value;
     var note = document.vendita.note.value;
     
     var string = String (document.location).split('=');
     var string = string[1].split('&');
     //alert(string[0]);
     // Espressione regolare dell'email
     var codFis_reg_exp = /^[A-Z]{6}[0-9]{2}[ABCDEHLMPRST]{1}[0-9]{2}([A-Z]{1}[0-9]{3})[A-Z]{1}$/;
     var telaio_reg_exp = /[A-Z0-9]{1,17}/;
     var data_reg_exp = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)[0-9]{2}$/;
     var note_reg_exp = /[a-zA-Z0-9 ]*/;
    	 //Effettua il controllo sul campo CODFIS
        if (codFis == null || codFis == "" || !codFis_reg_exp.test(codFis) ) {
           alert("Il campo Codice Fiscale deve avere il formato del codice fiscale.");
           document.vendita.codFis.focus();
           return false;
        }
        //Effettua il controllo sul campo TELAIO
        else if (telaio == null || telaio == "" || !telaio_reg_exp.test(telaio) ) {
           alert("Il campo Telaio deve avere il formato del telaio e<br>deve essere già presente.");
           document.vendita.telaio.focus();
           return false;
        }
        //Effettua il controllo sul campo DATA
        else if (data == null || data == "" || !data_reg_exp.test(data) ) {
            alert("Il formato del campo Data deve essere gg/mm/aaaa.");
            document.vendita.data.focus();
            return false;
         }
     	//Effettua il controllo sul campo NOTE
        else if (note == null || note == "" || !note_reg_exp.test(note) ) {
            alert("Il campo Note è obbligatorio.");
            document.vendita.note.focus();
            return false;
         }
        if(string[0] == "inserisciVendita"){
	       	 document.vendita.action = "InserisciVendita";
	       	 document.vendita.submit();
        }else if(string[0] == "modifica"){
	    	 document.vendita.action = "ModificaVendita";
	    	 document.vendita.submit();
        }

  }