var http = require('http') // http module
  , fs = require('fs')  // file system module
  , qs = require('querystring'); // querystring parser
var exec = require('child_process').exec, child;

function validInput(input){    
    return (typeof(input.Mercanaries) !== 'undefined')  && (typeof(input.Region) !== 'undefined') && input.Mercanaries.match(/^\d\d\d\d\d\d\d\d$/) && input.Mercanaries.length == 8 && input.Region.length <= 4;
}

function onRequest(request, response) {
    if (request.method == 'POST') {
        var body = '';
        request.on('data', function (data) {
            body += data;
            if (body.length > 32) { 
                request.connection.destroy();
				console.log("too Long");
            }
        });
        request.on('end', function () {

            var POST = qs.parse(body);
            // use POST
			if (!validInput(POST)){
				response.writeHead(404, {"Content-Type": "text/plain"});
				response.end();
			}
			else{
				child = exec('@echo ' + POST.Mercanaries + POST.Region + '|BrawlerMatchFinder.exe',
				  function (error, stdout, stderr){
					if(error !== null){
						console.log('exec error: ' + error);
						response.writeHead(404, {"Content-Type": "text/plain"});
						response.end();
					}
					else{
						response.writeHead(200, {"Content-Type": "text/plain"});
						response.write(stdout);
						response.end();
					}
				});
			}
        });
    }
	else{
		response.writeHead(404, {"Content-Type": "text/plain"});
		response.end();
	}

}

http.createServer(onRequest).listen(8888);
