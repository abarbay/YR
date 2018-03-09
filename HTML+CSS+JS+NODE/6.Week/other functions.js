// Indexelő függvény
function indexer(filePath, fn) {
    fs.readFile(filePath, "utf8", function (err, data) {
        if (err) {
            return console.log(err);
        }

        let jsonData = JSON.parse(data);

        for (var i = 0; i < jsonData.data.length; i++) {
            jsonData.data[i].id = (i + 1);
        }

        // Visszaírás.        
        fs.writeFile(filePath, JSON.stringify(jsonData, null, 4), "utf8", function (err, data) {
            if (err) {
                return console.log(err);
            }
            console.log("Index done.");
            fn();
        });
    });
}