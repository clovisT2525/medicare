<!DOCTYPE html>
<html>
	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
		<link href="css/index.css" />
	    <!-- Bootstrap CSS -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
		<title>User - Login</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<div class="py-5">
				<p class="display-4"><strong>Welcome Guest</strong></p>
				<br/>
				<br/>
				<form action="UserLogin" method="post">
					<label class="form-label" for="username">Name:</label>
					<input class="form-control" type="text" name="username"/> <br /> <br /> 
					<label class="form-label" for="userpass">Password:</label>
					<input class="form-control" type="password" name="userpass"/><br /> <br /> 
					<input class="btn btn-outline-primary" type="submit" value="Login"/>
					<input class="btn btn-outline-primary" type="submit" value="SignUp" formaction="UserSignup"/>
				</form>
			</div>
		</div>		
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	
	</body>
</html>
