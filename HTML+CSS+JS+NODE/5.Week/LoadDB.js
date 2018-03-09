function readDB(db){
    document.querySelector('#TableHead').classList.remove('hide'); /* Fejléc betöltése*/
    nodeButtons=document.querySelectorAll('button');
    for(var i=0;i<nodeButtons.length;i++){ 
        // A gombok tiltásának feloldása
            nodeButtons[i].classList.remove('disabled');
            nodeButtons[i].removeAttribute('disabled'); 
      }

    var nodeTBody=document.querySelector('TABLE>TBODY');
        s='';
    //tábla létrehozás
    for(var i=0;i<db.length;i++){
       s+='<tr>';
        s+='<td>'+ db[i].id+'</td>';
        s+='<td>'+ db[i].name+'</td>';
		s+='<td>'+ db[i].tagline+'</td>';
        s+='<td>'+ db[i].first_brewed+'</td>';
        s+='<td>'+ db[i].contributed_by+'</td>';
        s+='<td> <span class="glyphicon glyphicon-eye-open" onclick="showDetails(event)"></span> <span class="glyphicon glyphicon-pencil" onclick="modifyData(event)"></span> <span class="glyphicon glyphicon-trash" onclick="deleteRecordFromDB(event)"></span></td>'
       s+='</tr>'; 
    }
    nodeTBody.innerHTML=s; 

    // takaritások
    textBoxHide("TextBoxForSearch");
    textBoxHide("TextBoxForFilter");
    formDelete();
}

function textBoxHide(Textbox){
    var textBoxId='#'+Textbox;
    var textBoxIdBtn=textBoxId+'Btn'
    document.querySelector(textBoxId).classList.add('hide');
    document.querySelector(textBoxIdBtn).classList.add('hide')
}