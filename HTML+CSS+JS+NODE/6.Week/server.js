const http = require("http");
const fs = require("fs");
const apiRegex = /\/api\/(.*)/;



//mysql kapcsolat létrehozása
var mysql = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'yrproject',
  password : 'yellow',
  database : 'yrproject'
}); 
connection.connect();

// CRUD függvények létrehozása
const server = http.createServer( function(req, res) {
    console.log(req.url);
    let method = req.method.toLowerCase();
    switch(method) {
        case "get": getResponse(req, res); //READ
            break;
        case "post": postResponse(req, res); //UPDATE
            break;
        case "put": putResponse(req, res); //CREATE
            break;
        case "delete": delResponse(req, res); //DELETE
            break;
        default: res.end();
    }
});

// Get kérések kiszolgálása.
function getResponse(req, res) {
    if (req.url == "/") {
        sendFile(res, "./view/index.html"); // ha nincs mögötte semmi akkor az index oldal
    // ha van api a linkben akkor ezt futtatja
    } else if (apiRegex.test(req.url)) { 
        const urlParts = req.url.match(apiRegex)[1].split('/'); 
        // Select írása.
        // Az eredmény visszaküldése stringify formátumban. a ${urlParts[0]} az a táblanev node 
        connection.query(`SELECT * FROM ${urlParts[0]}`, function(err, results) {
            res.end(JSON.stringify(results));
        })
    } else {
        sendFile(res, "./public" + req.url);
    }
}

// TODO: delete functionality.
function delResponse(req, res) {
    req.on('end', function() {
     const urlParts = req.url.match(apiRegex)[1].split('/'); 
        

        let q =`DELETE FROM ${urlParts[0]} 
        WHERE Id="${urlParts[1]}"
         `  
        console.log(q) ;    
        ;

        connection.query(q, function(err, results){
            res.end( JSON.stringify(results)); 
        });;
    });

    res.end("Delete: "+req.url);

}

// Handle Post request. UPDATE
function postResponse(req, res) {
    var data = "";
    req.on('data', function(pack) {
        data += pack;
    });
    req.on('end', function() {
     const urlParts = req.url.match(apiRegex)[1].split('/'); 
        data = JSON.parse(data);
        console.log(data);

        let q =`UPDATE ${urlParts[0]} SET ${Object.keys(data)[1]}="${Object.values(data)[1]}",
                                          ${Object.keys(data)[2]}="${Object.values(data)[2]}",
                                          ${Object.keys(data)[3]}="${Object.values(data)[3]}",
                                          ${Object.keys(data)[4]}="${Object.values(data)[4]}",
                                          ${Object.keys(data)[5]}="${Object.values(data)[5]}"
        WHERE Id="${urlParts[1]}"
         `  
        console.log(q) ;    
        ;

        connection.query(q, function(err, results){
            res.end( JSON.stringify(results)); 
        });;
    });
}

// Create new record.

function putResponse(req, res) {
    var data = "";
    req.on('data', function(pack) {
        data += pack;
    });
    req.on('end', function() {
        
        const urlParts = req.url.match(apiRegex)[1].split('/'); 
        data = JSON.parse(data);
        console.log(data);
        let q =`INSERT INTO ${urlParts[0]} (${Object.keys(data)[1]},
                                            ${Object.keys(data)[2]},
                                            ${Object.keys(data)[3]},
                                            ${Object.keys(data)[4]},
                                            ${Object.keys(data)[5]})   
        VALUES ("${Object.values(data)[1]}",
                "${Object.values(data)[2]}",
                "${Object.values(data)[3]}",
                "${Object.values(data)[4]}",
                "${Object.values(data)[5]}")
         `         
        ;
        console.log(q) // kiirni a query-t
        connection.query(q, function(err, results){
            res.end( JSON.stringify(results)    
        ); 
        });
    });
}

// Index file kiszolgálása.
function sendFile(res, filePath) {
    fs.readFile(filePath, "utf8", function(err, data) {
        if (err) {
            console.log(err);
            return res.end("file not found");
        }
        res.end(data);
    });
}

server.listen(3333);