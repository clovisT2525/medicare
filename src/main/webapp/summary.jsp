<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>User - Summary</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<div class="py-4">
				<p class="display-4"><strong>Summary</strong></p>
				<br/>
					
				<%@ page import="java.util.Map, java.util.HashMap, model.Medicine, java.util.List, java.util.ArrayList" %>
				<% 
					Map<Integer, Medicine> medicineMap = (HashMap<Integer, Medicine>)request.getAttribute("medicineMap");
					Integer totalAmount = (Integer)request.getAttribute("totalAmount");
					String paymentMethod = (String)request.getAttribute("paymentMethod");
					Map<Integer,Integer> medicineQuantityMap = (HashMap<Integer, Integer>)request.getAttribute("medicineQuantityMap");
				
					String responseString = "";
					responseString += "<br/><p class='display-5'>You have ordered : </p><br/><br/><ul>";
					for(Map.Entry<Integer,Integer> entry : medicineQuantityMap.entrySet()) {
						if(entry.getValue()>0){
							responseString += "<li class='display-6'><img height='100' width='100' src='"+ medicineMap.get(entry.getKey()).getImageUrl() +"'/>" + medicineMap.get(entry.getKey()).getName()+"</li>";							
						}
					}
					responseString += "</ul></p><br/><br/><p class='display-5'>Your chosen method of payment is : </p><br/><br/><li class='display-6'>"+ paymentMethod +"</li>";
					responseString += "<br/><br/><br/><p class='display-5'>Your total payable amount is : </p><br/><br/><li class='display-6'>"+ totalAmount +"</li>";
					out.print(responseString);
				%>
				<br/>
			</div>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	
	</body>
</html>
