var http = require('http') // http module
  , fs = require('fs')  // file system module
  , qs = require('querystring'); // querystring parser
var exec = require('child_process').exec, child;

function onRequestOld(request, response) {
  response.writeHead(200, {"Content-Type": "text/plain"});
  response.write("Hello World");
  response.end();
}

function onRequest(request, response) {
    if (request.method == 'POST') {
        var body = '';
        request.on('data', function (data) {
            body += data;
            // 1e6 === 1 * Math.pow(10, 6) === 1 * 1000000 ~~~ 1MB
            if (body.length > 1e2) { 
                // FLOOD ATTACK OR FAULTY CLIENT, NUKE REQUEST
                request.connection.destroy();
				console.log("Too Long");
            }
        });
        request.on('end', function () {

            var POST = qs.parse(body);
			
            // use POST
			if (typeof(POST.Mercanaries) === 'undefined' || POST.Mercanaries.length != 15){
				response.writeHead(404, {"Content-Type": "text/plain"});
				response.end();
			}
			else{
				console.log(POST.Mercanaries);
				child = exec('java -jar TrialByFire.jar',
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
