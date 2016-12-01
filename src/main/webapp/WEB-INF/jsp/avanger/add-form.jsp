<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/avengers/bootstrap/css/bootstrap.min.css">
  <script
  src="https://code.jquery.com/jquery-3.1.1.js"
  integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
  crossorigin="anonymous"></script>

  
  <style>
#makeMeDraggable { width: 300px; height: 300px; background: red; }
</style>

<script type="text/javascript">
 var mousedown=false;
 var originX;
 var originY;
$(document).ready(function(){
	
	$('#makeMeDraggable').mousemove(function(event){
		//console.log("x: "+event.pageX+" y: "+event.pageY);
		if(mousedown){
			var diffX=event.pageX-origineX;
			var diffY=event.pageY-origineY;
			var position=$("#makeMeDraggable").position();
			var topDiv=position.top;
			var leftDiv=position.left;
		$("#makeMeDraggable").css('border','5px solid');
		$("#makeMeDraggable").css('left',event.pageX);
		$("#makeMeDraggable").css('top',event.pageY);
		}
	});
	
	$('#makeMeDraggable').mousedown(function(event){
		//console.log("x: "+event.pageX+" y: "+event.pageY);
		mousedown=true;
		origineX=event.pageX;
		origineY=event.pageY;
	});
	
	$('#makeMeDraggable').mouseup(function(event){
		//console.log("x: "+event.pageX+" y: "+event.pageY);
		mousedown=false;
		
	});
	
});
 
</script>
</head>
<body>

<div class="container">
  <h2>Ajouter un Avanger</h2>
  
  
  	
    	 <form class="form-horizontal" action="/avengers/app/avanger/${id}/uploadPhoto" method="post" enctype="multipart/form-data">
  <input type="hidden" class="form-control" name="" value="${id}">
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastName">Nom:</label>
      <div class="col-sm-10">
        <input type="file" class="form-control" id="photoInput" name="file" placeholder="Choisir une photo">
      </div>
    </div>
    <div>
    	<img id="img" width="42" src="">
    </div>
   
  </form>
  
  
  
  
  
  
  
  <form class="form-horizontal" action="/avengers/app/avanger/add" method="POST" id="myForm">
    <div class="form-group">
    	
    	
    	<c:choose>
					<c:when test="${avanger==null}">
						<input type="hidden"
							 name="id" value="0">
					</c:when>
					<c:otherwise>
						<input type="hidden"
							 name="id" value="${avanger.id}">
					</c:otherwise>
					</c:choose>
  
    	
    	
    	
    	
      <label class="control-label col-sm-2" for="lastName">Nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Saisir le Nom" value="${avanger.lastName}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">Pr�nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Saisir le Prénom" value="${avanger.firstName}">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="alias">Alias:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="alias" name="alias" placeholder="Saisir l'Alias" value="${avanger.alias}">
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="power">Force:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="power" name="power"placeholder="Saisir la force" value="${avanger.power}">
      </div>
    </div>
  
       <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
        </div>
      </div>
    </div>
    
   
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    
     <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-default" id="foo">Ajouter (avec Jquery)</button>
      </div>
    </div>
     <input type="hidden" class="form-control" id="photo" name="photo" placeholder="Choisir une photo">//photo hidden
    
  </form>
  <script>
		$("#foo").click(function(){
			$("#myForm").submit();
			console.log("succès")
		});
		
		
		</script>
		
<script>



$(document).ready(function() {

$('#photoInput').change(function() {

var formData = new FormData();

formData.append('file', $('#photoInput')[0].files[0]);

console.log("data : "+formData);


$.ajax({

    url: '/avengers/app/avanger/uploadPhoto',

    data: formData,

    cache: false,

    contentType: false,

    processData: false,

    type: 'POST',

    success: function(data){

    console.log(data);
	$("#photo").val(data);
    $("#img").attr("src", "data:image/png;base64,"+data);

    }

});


});

});

</script>
  
</div>

<div id="content" style="height: 400px;">
  <div id="makeMeDraggable"> </div>
</div>

</body>
</html>

