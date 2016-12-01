var init = function(Monscope, Monhttp) {
    console.log('init()');

    var url = 'http://localhost:8080/avengers/app/rest/avengers/';
    Monhttp.get(url).then(function(resp) {
        Monscope.avengers = resp.data;
        Monscope.avenger = {};
    });

}



var getAvenger = function(id, Monscope, Monhttp) {
    console.log('init()');
    var url = 'http://localhost:8080/avengers/app/rest/avengers/'+id;
    console.log(url);
    Monhttp.get(url).then(function(resp) {
        console.log(resp.data);
        Monscope.av = resp.data;
        resp.data != null ?  Monscope.maVar = 1 :  Monscope.maVar=0;
    });
}

var deleteAvenger = function(id, Monhttp, Monscope) {
    var url = 'http://localhost:8080/avengers/app/rest/avengers/'+id;
    Monhttp.delete(url).then(function() {
        init(Monscope, Monhttp);
       
    });
}

var saveAvenger = function(Monscope, Monhttp) {
    var url = 'http://localhost:8080/avengers/app/rest/avengers/';
    Monhttp.post(url,Monscope.avenger).then(function() {
       init(Monscope,Monhttp);
       window.location.href ='#avengers1'
    });
}

var editAvenger1=function(id, Monhttp, Monscope) {
	var url = 'http://localhost:8080/avengers/app/rest/avengers/'+id;
	Monhttp.get(url).then(function(resp) {
		Monscope.avenger=resp.data;
		window.location.href='#formulaire'
	});
	
}