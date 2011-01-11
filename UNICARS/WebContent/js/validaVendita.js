/**
 *  JavaScript che controlla l'inserimento di tutti i campi
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
     var codFis_reg_exp = /^[A-Z]{6}[0-9]{2}[ABCDEHLMPRST]{1}[0-9]{2}([A-Z]{1}[0-9]{3})[A-Z]{1}$/;
     var telaio_reg_exp = /^[A-Z0-9]{1,17}$/;
     var note_reg_exp = /^[a-zA-Z0-9 ]*$/;
    	 //Effettua il controllo sul campo CODFIS
        if (codFis == null || codFis == "" || !codFis_reg_exp.test(codFis) ) {
           alert("Il campo Codice Fiscale deve avere il formato del codice fiscale.");
           document.vendita.codFis.focus();
           return false;
        }
        //Effettua il controllo sul campo TELAIO
        else if (telaio == null || telaio == "" || !telaio_reg_exp.test(telaio) ) {
           alert("Il campo Telaio deve avere il formato del telaio e deve essere già presente.");
           document.vendita.telaio.focus();
           return false;
        }
        //Effettua il controllo sul campo DATA
        else if (!verif_date(data)) {
            alert("Il formato del campo Data deve essere gg/mm/aaaa -" +
            		"\nAttenzione alle date bisestili.");
            document.vendita.data.focus();
            return false;
         }
     	//Effettua il controllo sul campo NOTE
        else if (data == null || !note_reg_exp.test(note) ) {
            alert("Il campo Note deve contenere solo Caratteri.");
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