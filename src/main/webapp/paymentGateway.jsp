<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>User - Payment Gateway</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<div class="py-4">
				<p class="display-4"><strong>Payment Mechanism</strong></p>
				<br/>
				<form action="Summary" method="post">
					<div class="form-check">
						<% 
							String cartInfo = (String)request.getAttribute("cart");
						%>
						<input type="hidden" name="cartInfo" value='<%= cartInfo %>' />
						<input class="form-check-input" type="radio" id="cod" name="adminOption" value="Cash On Delivery">
						<label class="form-check-label" for="Cash On Delivery">Cash On Delivery</label><br>
						<br/> 
						<input class="form-check-input" type="radio" id="wallet" name="adminOption" value="Wallet Payment on Delivery">
						<label class="form-check-label" for="Wallet Payment on Delivery">Wallet Payment on Delivery</label><br>
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
