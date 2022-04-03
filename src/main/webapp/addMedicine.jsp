<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>Admin - Add Medicine</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<p class="display-6"><strong>Enter new Medicine details</strong></p>
			<form action="AddMedicine" method="post">
				<label class="form-label" for="name">Name:</label>
				<input class="form-control" type="text" name="name"/> <br /> <br /> 
				<label class="form-label" for="description">Description:</label>
				<input class="form-control" type="text" name="description"/><br /> <br />
				<label class="form-label" for="imageUrl">Image Url:</label>
				<input class="form-control" type="text" name="imageUrl"/><br /> <br />
				<label class="form-label" for="price">Price:</label>
				<input class="form-control" type="number" min=0 name="price"/><br /> <br />
				<label class="form-label" for="seller">Seller:</label>
				<select class="form-control" name="seller">

				<%@ page import="java.util.Map, java.util.HashMap, model.*" %>
				<%

					Map<Integer, Tag> tagMap = (HashMap<Integer, Tag>)request.getAttribute("tagMap");
					Map<Integer, Seller> sellerMap = (HashMap<Integer, Seller>)request.getAttribute("sellerMap");
					Map<Integer, Offer> offerMap = (HashMap<Integer, Offer>)request.getAttribute("offerMap");
	
					String responseStringSeller = "";

					for(Map.Entry<Integer,Seller> entry : sellerMap.entrySet()) {
						Seller seller = (Seller)entry.getValue();
						responseStringSeller+="<option value='" + seller.getId() + "'>" + seller.getName() + "</option>";
					}
				
					out.print(responseStringSeller);

				%>
				</select><br/><br/>
				<label class="form-label" for="tag">Tag:</label>
				<select class="form-control" name="tag">
				<%
					String responseStringTag = "";

					for(Map.Entry<Integer,Tag> entry : tagMap.entrySet()) {
						Tag tag = (Tag)entry.getValue();
						responseStringTag+="<option value='" + tag.getId() + "'>" + tag.getName() + "</option>";
					}
				
					out.print(responseStringTag);
				
				%>
				</select><br/><br/>
				<label class="form-label" for="offer">Offer:</label>
				<select class="form-control" name="offer">
				<%
					String responseStringOffer = "";

					for(Map.Entry<Integer,Offer> entry : offerMap.entrySet()) {
						Offer offer = (Offer)entry.getValue();
						responseStringOffer+="<option value='" + offer.getId() + "'>" + offer.getName() + "</option>";
					}
				
					out.print(responseStringOffer);
				
				%>
				</select><br/><br/>
				<div class="form-check">
					<label class="form-check-label" for="active">Active:</label>
					<input class="form-check-input" type="checkbox" name="active"/> <br /> <br />
				</div>
				<input class="btn btn-outline-primary" type="submit" value="Submit"/>
			</form>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	</body>
</html>