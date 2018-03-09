// Delete request.
function delRequest(table, index) {
    var url = "/api/" + table + "/" + index;
    var xhr = new XMLHttpRequest;
    xhr.open("delete", url);
    xhr.onload = function (ev) {
        console.log(ev.target.response);
    };
    xhr.send();
}


function getAll(table) {
    var url = "/api/" + table;
    var xhr = new XMLHttpRequest;
    xhr.open("get", url);
    xhr.onload = function (ev) {
        data = JSON.parse(ev.target.response);
        readJSON(data);
    };
    xhr.send();
    
}

function readJSON(dbdata) {
    var db = dbdata;
    var nodeTBody = document.querySelector('TABLE>TBODY');
    s = '';
    //Table Head
    s+='<tr><thead id=TableHead class="hide"><tr><th>ID</th><th>Name</th><th>Key</th><th>Code</th></tr></thead></tr>';
    //Üres sor létrehozása
    s += '<tr>';
        s += '<td><input></td>';
        s += '<td><input></td>';
        s += '<td><input></td>';
        s += '<td><input></td>';
        s += '<td><span class="glyphicon glyphicon-plus"></span></td>';
    //Táblázat létrehozása
    for (var i = 0; i < db.length; i++) {
        s += '<tr>';
        s += '<td><input value=' + db[i].id + '></td>';
        s += '<td><input value=' + db[i].name + '></td>';
        s += '<td><input value=' + db[i].key + '></td>';
        s += '<td><input value=' + db[i].code + '></td>';
        s += '<td><span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span></td>'
        s += '</tr>';
    }
    nodeTBody.innerHTML = s;
}
//TODO

//első sor üres hogy inserálni lehessen
// az utolsó oszlop két gomb  módosít töröl
