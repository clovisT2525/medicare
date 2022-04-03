<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>Admin - Add Offer</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<p class="display-6"><strong>Enter new Offer details</strong></p>
			<form action="AddOffer" method="post">
				<label class="form-label" for="name">Name:</label>
				<input class="form-control" type="text" name="name"/> <br /> <br />
				<label class="form-label" for="value_in_discount">Value in Discount:</label>
				<input class="form-control" type="number" min=0 name="value_in_discount"/><br /> <br />
				<input class="btn btn-outline-primary" type="submit" value="Submit"/>
			</form>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	</body>
</html>