<!DOCTYPE html>
<html>
	<head>
		    <!-- Required meta tags -->
		    <meta charset="utf-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		
			<link href="css/index.css" />
		    <!-- Bootstrap CSS -->
		    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
	
			<title>Admin - Edit Medicine</title>
	</head>
	<body class="bg-light">
		<div class="container">
			<p class="display-6"><strong>Edit Medicine details</strong></p>
			<form action="ChooseMedicine" method="post">
				<%@ page import="java.util.Map, java.util.HashMap, model.*" %>
				<%
				
					Map<Integer, Medicine> medicineMap = (HashMap<Integer, Medicine>)request.getAttribute("medicineMap");
					
					String responseString = "";
	
					for(Map.Entry<Integer,Medicine> entry : medicineMap.entrySet()) {
						Medicine medicine = (Medicine)entry.getValue();
						responseString+="<div class='form-check'><input class='form-check-input' type='radio' id='" + medicine.getId() + "' name='chosenMedicine' value='" + medicine.getId() + "'>";
						responseString+="<label class='form-check-label' for='"+medicine.getId()+"'>"+medicine.getName()+"</label></div><br/>";
					}
				
					out.print(responseString);

				%>
				<input class="btn btn-outline-primary" type="submit" value="Submit"/>
			</form>
		</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
	</body>
</html>