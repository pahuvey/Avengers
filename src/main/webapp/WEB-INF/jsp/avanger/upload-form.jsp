<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/avengers/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  
  <h2>Ajouter un avanger</h2>
  <form class="form-horizontal" action="/avengers/app/avanger/${id}/uploadPhoto" method="post" enctype="multipart/form-data">
  <input type="hidden" class="form-control" name="id" value="${id}">
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastName">Nom:</label>
      <div class="col-sm-10">
        <input type="file" class="form-control" id="photo" name="file" placeholder="Choisir une photo">
      </div>
    </div>
    
    
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>

