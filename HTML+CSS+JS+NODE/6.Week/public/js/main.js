// Delete request.
function delRequest(index,dbtable) {
    var url = "/api/" +dbtable +"/" + index;
    var xhr = new XMLHttpRequest;
    xhr.open("delete", url);
    xhr.onload = function(ev) {
        console.log(ev.target.response);
    };
    xhr.send();
    getAll(dbtable);
}

// Update request. post, /api/club/:id, JSON.stringify(obj)
function updateRequest(obj,dbtable) {
    var url = "/api/"+dbtable+"/" + obj.Id;

    var xhr = new XMLHttpRequest;
    xhr.open("post", url);
    xhr.onload = function(ev) {
        console.log("response:"+ev.target.response);
    };
    console.log(obj);
    xhr.send(JSON.stringify(obj),dbtable);
    getAll(dbtable);
}

// Send create request.
function createRequest(obj,dbtable) {
    var url = "/api/"+dbtable;
    var xhr = new XMLHttpRequest;
    xhr.open("put", url);
    xhr.onload = function(ev) {
        console.log(JSON.stringify(obj),dbtable);
    };
    xhr.send(JSON.stringify(obj),dbtable);

    getAll(dbtable);
}

function getAll(table) {
    var url = "/api/"+table;
    var xhr = new XMLHttpRequest;
    xhr.open("get", url);
    xhr.onload = function(ev) {
        var data = JSON.parse(ev.target.response);
        fillTable(data,table);
    };
    xhr.send();
}

// Filling the table
function fillTable(rows,dbtable) {
    // Searching for HTML elements
    var table = document.querySelector("#crudTable");
    var thead = table.querySelector("thead");
    var tbody = table.querySelector("tbody");

    // Flushing table.
    thead.innerHTML = "";
    tbody.innerHTML = "";

    //Generating Headers
    for (var k in rows[0]) {
        var th = document.createElement("th");
        th.innerHTML = k;
        thead.appendChild(th);
    }
    addCreateRow(thead, rows[0],dbtable);

    // Generating table body
    for (var k in rows) {
        var tr = document.createElement('tr');
        for (var j in rows[k]) {
            var td = document.createElement("td");
            var input = document.createElement("input");
            td.appendChild(input);
            input.value = rows[k][j];
            input.key = j;
            input.className = "form-control";
            tr.appendChild(td);
        }

        // Buttons
        var td = document.createElement("td");
        var group = document.createElement("div");
        group.className = "btn-group";

        // Update button
        var btn1 = document.createElement("button");
        btn1.className = "btn btn-info";
        btn1.innerHTML = "<span class='glyphicon glyphicon-refresh'></span>";
        btn1.addEventListener("click", function(ev) {
            // TODO check error
            var parentTr = ev.target.parentElement.parentElement.parentElement.parentElement;
            
            
            var inputs = parentTr.querySelectorAll("input");
            var row = {};
            for (var k in inputs) {
                if (inputs[k].value) {
                    row[inputs[k].key] = inputs[k].value;
                }
            }
            console.log(row)
            updateRequest(row,dbtable);
        });
        
        // Delete button
        var btn2 = document.createElement("button");
        btn2.className = "btn btn-danger";
        btn2.innerHTML = "<span class='glyphicon glyphicon-trash'></span>";
        btn2.addEventListener("click", function(ev) {
            // TODO check error
            var parentTr = ev.target.parentElement.parentElement.parentElement.parentElement;
            
            
            var inputs = parentTr.querySelectorAll("input");
            var index=inputs[0].value;
            console.log(index)
            delRequest(index,dbtable);
        });
        

        group.appendChild(btn1);
        group.appendChild(btn2);
        td.appendChild(group);
        tr.appendChild(td);

        tbody.appendChild(tr);
    }
}

function addCreateRow(parent, obj,dbtable) {
    // Generating fields
    var tr = document.createElement("tr");
    for (var k in obj) {
        var input = document.createElement("input");
        var td = document.createElement("td");
        input.key = k;
        input.className = "form-control";
        td.appendChild(input);
        tr.appendChild(td);
        tr.className = "create-row";
    }

    var td = document.createElement("td");
    var btn = document.createElement("button");
    btn.className = "btn btn-success";
    btn.innerHTML = "<span class='glyphicon glyphicon-plus'></span>";
    td.appendChild(btn);
    tr.appendChild(td);

    //click event
    btn.addEventListener("click", function(ev) {
        // var btn = ev.target;
        var tr = this.parentElement.parentElement;
        var inputs = tr.querySelectorAll("input");
        var obj = {};
        for (var i = 0; i < inputs.length; i++) {
            obj[inputs[i].key] = inputs[i].value;
        }
        console.log(obj);
        createRequest(obj,dbtable); 
    });

    parent.appendChild(tr);
}