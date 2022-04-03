<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>Admin - Menu</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<div class="py-4">
				<p class="display-4"><strong>Select an option from below</strong></p>
				<br/>
				<form action="AdminMenu" method="post">
					<div class="form-check">
						<input class="form-check-input" type="radio" id="add_medicine" name="adminOption" value="add_medicine">
						<label class="form-check-label" for="add_medicine">Add new Medicine</label><br>
						<br/> 
						<input class="form-check-input" type="radio" id="add_tag" name="adminOption" value="add_tag">
						<label class="form-check-label" for="add_tag">Add new Tag</label><br>
						<br/>
						<input class="form-check-input" type="radio" id="add_offer" name="adminOption" value="add_offer">
						<label class="form-check-label" for="add_offer">Add new Offer</label><br>
						<br/>
						<input class="form-check-input" type="radio" id="add_seller" name="adminOption" value="add_seller">
						<label class="form-check-label" for="add_seller">Add new Seller</label><br>
						<br/>
						<input class="form-check-input" type="radio" id="edit_medicine" name="adminOption" value="edit_medicine">
						<label class="form-check-label" for="edit_medicine">Edit Medicine</label><br>
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
