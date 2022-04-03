<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>User - Menu</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<div class="py-4">
				<p class="display-4"><strong>Select an option from below</strong></p>
				<br/>
				<form action="UserMenu" method="post">
					<div class="form-check">
						<input class="form-check-input" type="radio" id="search_medicine" name="adminOption" value="search_medicine">
						<label class="form-check-label" for="search_medicine">Find Medicines</label><br>
						<br/>
						<input class="btn btn-outline-primary" type="submit" value="Submit" />
					</div>
				</form>
				<br/>
			</div>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	
	</body>
</html>
