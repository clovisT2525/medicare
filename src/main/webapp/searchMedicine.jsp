<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
		    <link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" >
	
			<title>User - Search Medicine</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<p class="display-6"><strong>Search for Medicines</strong></p><br/>
				<%@ page import="java.util.Map, java.util.HashMap, model.*" %>
				<%
				
					Map<Integer, Medicine> medicineMap = (HashMap<Integer, Medicine>)request.getAttribute("medicineMap");
					Map<Integer, Tag> tagMap = (HashMap<Integer, Tag>)request.getAttribute("tagMap");
					Map<Integer, Seller> sellerMap = (HashMap<Integer, Seller>)request.getAttribute("sellerMap");
					Map<Integer, Offer> offerMap = (HashMap<Integer, Offer>)request.getAttribute("offerMap");

					String responseString = "<table class='display' id='medicineTable' style='width:100%'>";
					responseString += "<thead><tr><th>Name</th><th>Description</th><th>Seller</th>";
					responseString += "<th>Price</th><th></th><th>Offer</th><th>Tag</th><th></th><th></th><th>Qty in Cart</th>";
					responseString += "</tr></thead><tbody>";
					
					for(Map.Entry<Integer,Medicine> entry : medicineMap.entrySet()) {
						Medicine medicine = (Medicine)entry.getValue();
						int  medicineId = (Integer)medicine.getId();
						if(medicine.isActive()==true) {
							responseString += "<tr><td>" + medicine.getName() + "</td>";
							responseString += "<td>" + medicine.getDescription() + "</td>";
							responseString += "<td>" + sellerMap.get(medicine.getSellerId()).getName() + "</td>";
							responseString += "<td>" + medicine.getPrice() + "</td>";
							responseString += "<td>" + "<img height='100' width='100' src='" + medicine.getImageUrl() + "' />" + "</td>";
							responseString += "<td>" + offerMap.get(medicine.getOfferId()).getName() + "</td>";
							responseString += "<td>" + tagMap.get(medicine.getTagId()).getName() + "</td>";
							responseString += "<td><input class='btn btn-outline-primary' type='submit' value='Add' onclick='addToCart("+medicineId+")' /></td>";
							responseString += "<td><input class='btn btn-outline-primary' type='submit' value='Remove' onclick='removefromCart("+medicineId+")' /></td>";
							responseString += "<td id='qty"+medicine.getId()+"'>0</td>";
							responseString += "</tr>";							
						}
					}
					
					responseString += "</tbody></table>";
					out.print(responseString);

				%>
				<br/><br/>
	
				<form action="DisplayCart" method="post">
					<input type="hidden" name="cart" id="cart"/> <br /> <br /> 				
					<input class="btn btn-outline-primary" type="submit" value="Submit"/>
				</form>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
	    <script>
	    	var cart={};
		    $(document).ready(function() {
		        $('#medicineTable').DataTable();
		    });
		    function addToCart(medicineId) {
		    	var currentQty = parseInt($("#qty"+medicineId).html());
		    	var newQty = currentQty+1;
		    	$("#qty"+medicineId).html(newQty);
		    	cart[medicineId]=newQty;
		    	$("#cart").val(JSON.stringify({cart:cart}));
		    }
		    function removefromCart(medicineId) {
		    	var currentQty = parseInt($("#qty"+medicineId).html());
		    	var newQty = Math.max(currentQty-1,0);
		    	$("#qty"+medicineId).html(newQty);
		    	cart[medicineId]=newQty;
		    	$("#cart").val(JSON.stringify({cart:cart}));
		    }
	    </script>
	</body>
</html>