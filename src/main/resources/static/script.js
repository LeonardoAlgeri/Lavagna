function httpGet(theUrl) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, false); // false for synchronous request
    xmlHttp.send(null);
    return xmlHttp.responseText;
}

function passwd(site) {
    var pass = prompt("Inserire la password per il reset");
    site = site + pass;
    document.getElementById('state').innerHTML = httpGet(site);
}