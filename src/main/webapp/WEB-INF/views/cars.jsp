<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Car Dealer</title>
</head>
<body>
Welcome, <br /> <br />
<h1 align = "center">The Cars available are:</h1>
<table align = "center" border = "5">
			<thead>
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Year</th>
					<th>Cost</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cars}" var="car">
					<tr>
						<td>${car.vin}</td>
						<td>${car.make}</td>
						<td>${car.model}</td>
						<td>${car.year}</td>
						<td>${car.cost}</td>
						<td><input type = "submit" value = "Buy"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>