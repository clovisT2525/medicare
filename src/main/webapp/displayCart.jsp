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
	
			<title>User - Cart</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<p class="display-6"><strong>Cart</strong></p><br/>
				<%@ page import="java.util.Map, java.util.HashMap, model.*" %>
				<%
				
					Map<Integer, Medicine> medicineMap = (HashMap<Integer, Medicine>)request.getAttribute("medicineMap");
					Map<Integer, Tag> tagMap = (HashMap<Integer, Tag>)request.getAttribute("tagMap");
					Map<Integer, Seller> sellerMap = (HashMap<Integer, Seller>)request.getAttribute("sellerMap");
					Map<Integer, Offer> offerMap = (HashMap<Integer, Offer>)request.getAttribute("offerMap");
					Map<Integer,Integer> medicineQuantityMap = (HashMap<Integer, Integer>)request.getAttribute("medicineQuantityMap");
					String cart = (String)request.getAttribute("cart");
					String responseString = "<table class='table' id='cartTable' style='width:100%'>";
					responseString += "<thead><tr><th>Name</th><th>Description</th><th>Seller</th>";
					responseString += "<th>Price</th><th>Offer</th><th>Price After Discount</th>";
					responseString += "<th></th><th>Tag</th><th></th><th></th><th>Qty in Cart</th><th>Final Amount</th>";
					responseString += "</tr></thead><tbody>";
					
					int totalAmount = 0;
					
					for(Map.Entry<Integer,Integer> entry : medicineQuantityMap.entrySet()) {
						Medicine medicine = medicineMap.get(entry.getKey());
						int cartQuantity = entry.getValue();
						int medicineId = (Integer)medicine.getId();
						int priceBeforeOffer = medicine.getPrice();
						int priceAfterOffer = (priceBeforeOffer * (100-offerMap.get(medicine.getOfferId()).getValueInDiscount()) ) / 100;
						
						responseString += "<tr><td>" + medicine.getName() + "</td>";
						responseString += "<td>" + medicine.getDescription() + "</td>";
						responseString += "<td>" + sellerMap.get(medicine.getSellerId()).getName() + "</td>";
						responseString += "<td>" + priceBeforeOffer + "</td>";
						responseString += "<td>" + offerMap.get(medicine.getOfferId()).getName() + "</td>";
						responseString += "<td id='priceAfterOffer"+medicine.getId()+"'>" + priceAfterOffer + "</td>";
						responseString += "<td>" + "<img height='100' width='100' src='" + medicine.getImageUrl() + "' />" + "</td>";
						responseString += "<td>" + tagMap.get(medicine.getTagId()).getName() + "</td>";
						responseString += "<td><input class='btn btn-outline-primary' type='submit' value='Add' onclick='addToCart("+medicineId+")' /></td>";
						responseString += "<td><input class='btn btn-outline-primary' type='submit' value='Remove' onclick='removefromCart("+medicineId+")' /></td>";
						responseString += "<td id='qty"+medicine.getId()+"'>"+cartQuantity+"</td>";
						responseString += "<td id='finalAmount"+medicine.getId()+"'>"+(priceAfterOffer*cartQuantity)+"</td>";
						responseString += "</tr>";
						
						totalAmount+=(priceAfterOffer*cartQuantity);
					}
					
					responseString += "</tbody></table>";
					out.print(responseString);

				%>
				<br/>
				<h3>
					Total Amount : <b></b><span id="totalAmount"><% out.print("      " + totalAmount); %></span></b>
				</h3>
				<br/>
				<form action="PaymentGateway" method="post">
					<input type="hidden" name="cart" id="cart"/> <br /> <br /> 				
					<input class="btn btn-outline-primary" type="submit" value="Submit"/>
				</form>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	    <script>
	    	var cart=<%= cart %>;
	    	$(document).ready(function(){
	    		cart['totalAmount']=parseInt($("#totalAmount").html());
	    		$("#cart").val(JSON.stringify(cart));
	    	});
	    	function addToCart(medicineId) {
		    	var currentQty = parseInt($("#qty"+medicineId).html());
		    	var priceAfterOffer = parseInt($("#priceAfterOffer"+medicineId).html());
		    	var totalAmountBefore = parseInt($("#totalAmount").html());
		    	var totalAmount = totalAmountBefore + priceAfterOffer;
		    	var newQty = currentQty+1;
		    	$("#qty"+medicineId).html(newQty);
		    	$("#finalAmount"+medicineId).html(newQty * priceAfterOffer);
		    	$("#totalAmount").html(totalAmount);
		    	cart['cart'][medicineId]=newQty;
		    	cart['totalAmount'] = totalAmount;
		    	$("#cart").val(JSON.stringify(cart));
		    }
		    function removefromCart(medicineId) {
		    	var currentQty = parseInt($("#qty"+medicineId).html());
		    	var priceAfterOffer = parseInt($("#priceAfterOffer"+medicineId).html());
		    	var newQty = Math.max(currentQty-1,0);
		    	var totalAmount = parseInt($("#totalAmount").html());
				$("#qty"+medicineId).html(newQty);
		    	$("#finalAmount"+medicineId).html(newQty * priceAfterOffer);
		    	if(currentQty>0){
		    		totalAmount = totalAmount - priceAfterOffer;
			    	$("#totalAmount").html(totalAmount);		    		
		    	}
				cart['cart'][medicineId]=newQty;
				cart['totalAmount'] = totalAmount;
		    	$("#cart").val(JSON.stringify(cart));
		    }
	    </script>
	</body>
</html>