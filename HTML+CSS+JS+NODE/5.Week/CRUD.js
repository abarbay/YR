/*
Az alkalmazással szemben támasztott követelméyek:

CRUD funkcionalitás (Create, Read, Update, Delete)
- objektum, objektumok megjelenítése (olvasásra, módosításra)
- keresés, szűrés tetszőleges tulajdonság(ok) alapján
- csoportosítás
- sorbarendezés a felhasználó döntése alapján tetszőleges tulajdonság(ok) alapján (növekvő, csökkenő)
- új objektum felvétele felhasználótól beolvasott adatok alapján
- meglévő objektum tulajdonságainak módosítása felhasználótól beolvasott adatok alapján
- felhasználótól származó adatok validálása
- objektum törlése
- kiindulási adatok elkészítése, beszerzése (pl. JSON formátum)



Hiányzó
részletezés
vásárlás
összegzés
*/
var finalId=dataBase[dataBase.length-1].id;

var formDB=[
    {"label":"Name: ",
     "id":"name",
     "placeholder":"Enter beer name..."
    },
    {"label":"Tagline: ",
     "id":"tagline",
     "placeholder":"Enter tagline..."
    },
    {"label":"First Brewed date: ",
     "id":"brewdate",
     "placeholder":"Enter first brew date(mm/yyyy)..."
    },
    {"label":"Contributor: ",
     "id":"contributor",
     "placeholder":"Enter contributor name..."
    }
]

// kilistázom az adatbázis föbb elemeit egy táblába
function readDB(db){
    document.querySelector('#TableHead').classList.remove('hide');
    nodeButtons=document.querySelectorAll('button');
    for(var i=0;i<nodeButtons.length;i++){  
            nodeButtons[i].classList.remove('disabled');
            nodeButtons[i].removeAttribute('disabled'); 
      }
    var nodeTBody=document.querySelector('TABLE>TBODY');
        s='';
    for(var i=0;i<db.length;i++){
       s+='<tr>';
        s+='<td>'+ db[i].id+'</td>';
        s+='<td>'+ db[i].name+'</td>';
		s+='<td>'+ db[i].tagline+'</td>';
        s+='<td>'+ db[i].first_brewed+'</td>';
        s+='<td>'+ db[i].contributed_by+'</td>';
        s+='<td> <span class="glyphicon glyphicon-eye-open" onclick="showDetails(event)"></span> <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash" onclick="deleteRecordFromDB(event)"></span></td>'
       s+='</tr>'; 
    }
    nodeTBody.innerHTML=s; 
    textBoxHide("TextBoxForSearch");
    textBoxHide("TextBoxForFilter");
    formDelete();
}

function textBoxHide(Textbox){
    var textBoxId='#'+Textbox
    var textBoxIdBtn=textBoxId+'Btn'
    document.querySelector(textBoxId).classList.add('hide');
    document.querySelector(textBoxIdBtn).classList.add('hide')
}

function filterShow(){
    formDelete();
    var  nodeTextBox=document.querySelector("#TextBoxForFilter");
    nodeTextBox.placeholder="Szűrés főzés éve alapján..."
    nodeTextBox.value="";
    nodeTextBox.classList.remove('hide');
    document.querySelector("#TextBoxForFilterBtn").classList.remove('hide');
     if(document.querySelector("#TextBoxForSearch").classList.contains('hide')==false){
         textBoxHide("TextBoxForSearch");
     }

}

function searchShow(){
    formDelete();
    var nodeTextBox=document.querySelector("#TextBoxForSearch");
    nodeTextBox.placeholder="Keresés név alapján..."
    nodeTextBox.value="";
    nodeTextBox.classList.remove('hide');
    document.querySelector("#TextBoxForSearchBtn").classList.remove('hide');
      if(nodeTextBox.classList.contains('hide')==false){
         textBoxHide("TextBoxForFilter");   
        }
     
}

function filter(){
    var SzuresSzoveg=nodeTextBox.value;

    var theResult=[];
    for(var i = 0; i < dataBase.length; i++){
        year=dataBase[i].first_brewed;
        year=year.slice(3);
        if(year==SzuresSzoveg){
            theResult.push(dataBase[i])
        }
        
    }
    readDB(theResult);
    document.querySelector("#TextBoxForFilter").value="";
    document.querySelector("#TextBoxForFilter").placeholder="Filter by first brewed year..."
}

function search(){
    
    var keresesSzoveg=document.querySelector("#TextBoxForSearch").value;
    var theResult=[];
    for(var i=0;i<dataBase.length;i++){
        if(dataBase[i].name.toLowerCase().indexOf(keresesSzoveg.toLowerCase())>-1){
            theResult.push(dataBase[i]);
            break;
        }
        
    }

    if(theResult.length==0){
            alert('Sajnálom, nincs találat!!!');
        }

    readDB(theResult);
    document.querySelector("#TextBoxForFilter").value="";
    document.querySelector("#TextBoxForFilter").placeholder="Serach beer by name..."
}


function formDelete(){
    document.getElementById('addRecord').innerHTML='';
}

function createInputField(label,id,placeholder){
 var nodeTd=document.createElement("div");
 nodeTd.classList.add("form-group");
 nodeForm.appendChild(nodeTd);

 var nodeInputLbl=document.createElement("label");
 nodeInputLbl.setAttribute("for","name");
 nodeInputLbl.appendChild(document.createTextNode(label));
 nodeInputLbl.classList.add( "col-md-4","control-label");
 nodeTd.appendChild(nodeInputLbl);


 var nodeSmallDiv=document.createElement("div");
 nodeSmallDiv.classList.add("form-group", "col-md-4");
 nodeTd.appendChild(nodeSmallDiv);
 

 var nodeInput=document.createElement("input");
 nodeInput.setAttribute("name",id);
 nodeInput.setAttribute("id",id);
 nodeInput.setAttribute("placeholder", placeholder)
 nodeInput.classList.add("form-control","input-md");
 nodeSmallDiv.appendChild(nodeInput);
}
// létrehozom a form keretét
function addRecord(){
    textBoxHide("TextBoxForSearch");
    textBoxHide("TextBoxForFilter");

    var nodeAddRecord=document.querySelector("#addRecord");

    var nodeLegend =document.createElement("legend");
    nodeLegend.appendChild(document.createTextNode("Add new record to database"));
    nodeAddRecord.appendChild(nodeLegend);
    nodeForm =document.createElement("form");
    nodeForm.setAttribute("name","AddForm");
    nodeForm.setAttribute("id","AddForm");
    nodeForm.setAttribute("required",""); //miért nem megy?
    nodeForm.classList.add("form-horizontal");
    nodeAddRecord.appendChild(nodeForm); 

    for(var i=0;i<formDB.length;i++){
        createInputField(formDB[i].label,formDB[i].id,formDB[i].placeholder)
    }

    // button hozzáadás
    var nodeTd=document.createElement("div");
    nodeBigDiv.classList.add("form-group");
    nodeForm.appendChild(nodeBigDiv);

    var nodeLbl=document.createElement("label");
    nodeLbl.setAttribute("for","name");
    nodeLbl.appendChild(document.createTextNode("Add beer to database"));
    nodeLbl.classList.add("col-md-4","control-label");
    nodeBigDiv.appendChild(nodeLbl);

    var nodeSmallDiv=document.createElement("div");
    nodeSmallDiv.classList.add("form-group", "col-md-4");
    nodeBigDiv.appendChild(nodeSmallDiv);

    var nodeInput=document.createElement("button");
    nodeInput.setAttribute("name","addBtn");
    nodeInput.setAttribute("id","addBtn");
    nodeInput.setAttribute("type","button");
    nodeInput.setAttribute("onclick","addRecordToDB();");
    nodeInput.classList.add("btn","btn-success");
    nodeInput.appendChild(document.createTextNode("Add Beer"));
    nodeSmallDiv.appendChild(nodeInput);
}

function addRecordToDB(){
  var record={};
 
  var brewdate=document.querySelector('#brewdate').value;
    var re = new RegExp(/^((0[1-9])|(1[0-2]))\/(\d{4})$/);
    if(brewdate.match(re)){
        alert(" rEGEX minden oké");
    }


    record.id=finalId+1;
    finalId=finalId+1; //növelnem kell hozzáadáskor hogy ne legyen ismétlödő ID
    record.name=document.querySelector('#name').value;
    record.tagline=document.querySelector('#tagline').value;
    record.first_brewed= brewdate;
    record.contributed_by=document.querySelector('#contributor').value;
    dataBase.push(record);
    readDB(dataBase);   
}

function deleteRecordFromDB(event){
   var dbID=parseInt(event.target.parentElement.parentElement.childNodes[0].textContent); 
    event.target.parentElement.parentElement.innerHTML='';
    for(var i=0;i<dataBase.length;i++){
        if(dataBase[i].id==dbID){
           dataBase.splice(i, 1);
        }

    }
}

function showDetails(event){
    // Annak ellenőrzése hogy létezik-e már az új sor
    // hiba hogy nem azt a sort törli vissza

    if (document.querySelector(".details")) {
        document.querySelector(".detailsRow").remove();
    } 
    else {
        var dbID=parseInt(event.target.parentElement.parentElement.childNodes[0].textContent);  
        var nodeDetails=event.target.parentElement.parentElement //tr ami a target
        var nodeDetailsRow=document.createElement("tr");
        nodeDetailsRow.classList.add("detailsRow");
        nodeDetails.parentNode.insertBefore(nodeDetailsRow, nodeDetails.nextSibling) //Így szúrod be az kattintott tr után az új TR-t
        nodeDetailsRow.classList.add("details");
        var nodeTd=document.createElement("td");
        nodeTd.classList.add("row");
        nodeTd.setAttribute("colspan", "6");
        nodeDetailsRow.appendChild(nodeTd);

        var nodeLeftDiv=document.createElement("div");
        //nodeLeftDiv.classList.add("left");
        nodeLeftDiv.classList.add("col-md-4");
        nodeTd.appendChild(nodeLeftDiv);

        var nodeIMG=document.createElement("img");
        nodeIMG.src=dataBase[dbID-1].image_url;
        nodeIMG.setAttribute('width','35%');
        nodeLeftDiv.appendChild(nodeIMG);

        var nodeMiddleDiv=document.createElement("div");
        //nodeMiddleDiv.classList.add("middle");
        nodeMiddleDiv.classList.add("col-md-4");
        nodeTd.appendChild(nodeMiddleDiv);

        var nodeDescriptionLbl=document.createElement("h4");
        nodeDescriptionLbl.appendChild(document.createTextNode('Description:'));
        nodeMiddleDiv.appendChild(nodeDescriptionLbl); 

        var nodeDescription=document.createElement("p");
        var description= dataBase[dbID-1].description;
        nodeDescription.appendChild(document.createTextNode(description));
        nodeMiddleDiv.appendChild(nodeDescription);

        var nodeRightDiv=document.createElement("div");
    // nodeRightDiv.classList.add("right");
        nodeRightDiv.classList.add("col-md-4");
        nodeTd.appendChild(nodeRightDiv);

        var nodeFoodPairingLbl=document.createElement("h4");
        nodeFoodPairingLbl.appendChild(document.createTextNode('Food Pairing:'));
        nodeRightDiv.appendChild(nodeFoodPairingLbl); 

        var nodeFoodPairing=document.createElement("p");
        var FoodPairing= dataBase[dbID-1].food_pairing;
        nodeFoodPairing.appendChild(document.createTextNode(FoodPairing));
        nodeRightDiv.appendChild(nodeFoodPairing);

        var nodeABVLbl=document.createElement("h5");
        nodeABVLbl.appendChild(document.createTextNode('ABV:'));
        nodeRightDiv.appendChild(nodeABVLbl); 

        var nodeABV=document.createElement("p");
        var ABV= dataBase[dbID-1].abv;
        nodeABV.appendChild(document.createTextNode(ABV+'%'));
        nodeRightDiv.appendChild(nodeABV);
    }
}

