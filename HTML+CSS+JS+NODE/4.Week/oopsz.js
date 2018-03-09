

var dataPanasz = {};

/* Ha a lakást választom akkor megjeleneik 
egy újabb radio button group az emelet típussal
*/
function lakasTipusMegjelenit() {


    if (document.getElementById('lakas').checked) {
        document.getElementById('tipus').style.visibility = 'visible';

    }
    else {
        document.getElementById('tipus').style.visibility = 'hidden';
        document.getElementById('foldszint').checked = false;
        document.getElementById('tetoter').checked = false;
        document.getElementById('emelet').checked = false;
    }
}

function lakasTipusEllenorzes() {
    /*
    fsz lakás:1,2,4
    tetötér lakás:1,2,3
    emelet lakás:1,2,3,4
    családi ház,1,2,5,6
    */
    var alap = ["s1", "s2", "ls1", "ls2"];
    var foldszint = ["s3", "s5", "s6", "ls3", "ls5", "ls6"];
    var tetoter = ["s4", "s5", "s6", "ls4", "ls5", "ls6"];
    var alsofelso = ["s3", "s4", , "ls3", "ls4"];
    var elsohatso = ["s5", "s6", , "ls5", "ls6"];


    document.getElementById("szomszed_div").classList.add('show');

    alap.forEach(function (element) {
        document.getElementById(element).classList.add("show");
    }, this);

    if (document.getElementById('foldszint').checked == true) {
        document.getElementById("s4").classList.add('show');
        document.getElementById("ls4").classList.add('show');

        foldszint.forEach(function (element) {
            document.getElementById(element).classList.remove("show");
        }, this);
    }
    else if (document.getElementById('tetoter').checked == true) {
        document.getElementById("s3").classList.add('show');
        document.getElementById("ls3").classList.add('show');

        tetoter.forEach(function (element) {
            document.getElementById(element).classList.remove("show");
        }, this)
    }
    else if (document.getElementById('emelet').checked == true) {
        elsohatso.forEach(function (element) {
            document.getElementById(element).classList.add("show");
        }, this)
        alsofelso.forEach(function (element) {
            document.getElementById(element).classList.remove("show");
        }, this)
    }
    else if (document.getElementById('csaladi').checked == true) {
        alsofelso.forEach(function (element) {
            document.getElementById(element).classList.add("show");
        }, this)
        elsohatso.forEach(function (element) {
            document.getElementById(element).classList.remove("show");
        }, this)

    }
}

function lakasPanaszSzovegInputMegjelenit() {
    var nodeSzomszedok = document.getElementsByName('szomszed');

    for (var i = 0; i < nodeSzomszedok.length; i++) {
        var fsName = 'FS' + (i + 1)
        var ptbName = 'ptb' + (i)
        if (nodeSzomszedok[i].checked == true) {
            document.getElementById(fsName).classList.remove('hide');
            document.getElementById(ptbName).classList.remove('hide');
        }
        else if (nodeSzomszedok[i].checked == false) {
            document.getElementById(fsName).classList.add('hide');
            document.getElementById(ptbName).classList.add('hide');
        }
    }
}

function alapallapotbaVisszaallitas() {
    nodeInputCheckbox = document.getElementsByName('szomszed');
    nodeSzomszedok = document.getElementsByName('fs');
    nodeTextArea = document.getElementsByName('ptb');
    for (var i = 0; i < nodeTextArea.length; i++) {
        nodeTextArea[i].value = '';
        nodeSzomszedok[i].classList.remove('pagebreak');
        nodeSzomszedok[i].classList.add('hide');
        nodeInputCheckbox[i].checked = false;
    }
}

function JSONKeszites() {
    if (document.getElementById('nevTextBox') != '' && document.getElementById('lakcimTextBox') != '') {
        dataPanasz.nev = document.getElementById('nevTextBox').value;
        dataPanasz.lakcim = document.getElementById('lakcimTextBox').value;
    }

    var nodeTextArea = document.getElementsByName('ptb');
    var ptomb = [];
    for (var i = 0; i < nodeTextArea.length; i++) {

        var pnum = document.getElementById('ptb' + i).value;
        ptomb.push(pnum)
    }
    dataPanasz.panasz = ptomb;
}

function ugykezelesiDijSzamitas() {
    var inputElements = document.getElementsByTagName("input"),
        count = 0;
    for (var i = 0; i < inputElements.length; i++) {
        if (inputElements[i].type === "checkbox" && inputElements[i].checked === true) {
            count++;
        }
    }
    var dij = 0;
    if (count == 1) {
        dij = 10;
    }
    else if (count > 1) {
        var tovabbiSzomszedokCount = count - 1;
        dij = 10 + tovabbiSzomszedokCount * 2;
    }
    var nodeDij = document.createElement("h2");
    var dijText = document.createTextNode('Az Ön által fizetendő benyújtási díj:' + dij + ' Zseton');
    nodeDij.appendChild(dijText);
    document.getElementById('dij').appendChild(nodeDij);
}

function printMorePages() {
    var nodeSzomszedok = document.getElementsByName('szomszed');

    for (var i = 0; i < nodeSzomszedok.length; i++) {
        var fsName = 'FS' + (i + 1);
        if (nodeSzomszedok[i].checked == true) {
            document.getElementById(fsName).classList.add('pagebreak');
            break;
        }
    }
}

/*Ha már megjelent akkor ne jelenjen meg mégegyszer amennyiben a tartalom megegyzik
 ha eltér a tartalom akkor frissitse az adatokat.

*/
function onellenorzes() {
    adatEllenorzes();
    EllenorzesForm();
    document.getElementById('onellenorzes').classList.remove('hide');
    var nodeSzomszedok = document.getElementsByName('szomszed');
    for (var i = 0; i < nodeSzomszedok.length; i++) {

        nodeSzomszedok[i].setAttribute('disabled', true)
    }
}

function EllenorzesForm() {
    JSONKeszites();
    var nodeSzomszedok = document.getElementsByName('fs');
    for (var i = 0; i < nodeSzomszedok.length; i++) {
        var hide = nodeSzomszedok[i].classList.contains('hide');
        if (hide != true) {
            var id0 = 'FS' + (i + 1);
            var szovegMezoID = 'ptb' + i;
            var ellenorzoMezoId = 'ptbe' + i;
            // van ellenorzoMezoId érték de még nem hztam létre a textArea-t
            if (!!document.getElementById(ellenorzoMezoId) == false) {
                var nodeTextarea = document.createElement('textarea');
                nodeTextarea.setAttribute('id', ellenorzoMezoId);
                var nodeText = document.createTextNode(dataPanasz.panasz[i]);
                nodeTextarea.setAttribute('disabled', true);
                nodeTextarea.appendChild(nodeText);
                document.getElementById(id0).appendChild(nodeTextarea);
            }
            else {
                //átírom a szöveget ha módosítaná a meglévő ellenőrzési adatokhoz képest

                if (document.getElementById(szovegMezoID).value != document.getElementById(ellenorzoMezoId).value) {
                    document.getElementById(ellenorzoMezoId).value = document.getElementById(szovegMezoID).value;
                }
            }
        }
    }
}
function gombEngedelyezes() {



    document.getElementById('nemGomb').setAttribute('disabled', true);
    document.getElementById('onellenorzesGomb').setAttribute('disabled', true);
    document.getElementById('benyujtas').removeAttribute('disabled');
    panaszElrejt();
}

function panaszElrejt() {
    var nodeSzomszedok = document.getElementsByName('fs');
    for (var i = 0; i < nodeSzomszedok.length; i++) {
        var id = 'ptb' + i
        document.getElementById(id).remove();
    }
}

function adatEllenorzes() {
   var panaszTartalom=panaszTartalomEllenorzes();

    if (
        document.querySelector("#nevTextBox").value != ""
        &&
        document.querySelector("#lakcimTextBox").value != ""
        &&
        (
            document.querySelector("#lakas").checked
            ||
            document.querySelector("#csaladi").checked
        )
        &&
        panaszTartalom
    ){}
    else { alert("Biztos, hogy mindent kitöltött?") }
}

function panaszTartalomEllenorzes() {
    var textArealathato = document.querySelectorAll("TextArea:not(.hide)")
    for (var i = 0; i < textArealathato.length; i++) {
        var result = true;
        if (textArealathato[i].value!="") {
            result = true;
            
        }
        else {
            result = false;
            break;
         }
        return result;
    }

}