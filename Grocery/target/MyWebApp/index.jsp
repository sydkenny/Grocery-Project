<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Grocery Welcome Page</title>
</head>

<body>
<h2>View existing grocery</h2>
<a class="btn btn-primary" href="read" role="button">View existing grocery</a>
<br>
<br>
<h2>Add new grocery</h2>
<p>Please enter the grocery detail</p>
<form action='add' method='get'>
	<table>
		<tr>
			<th>Name of the grocery</th>
			<td><input type='text' name='name'></input></td>
		</tr>
		<tr>
			<th>Category</th>
			<td><input type='text' name='category'></td>
		</tr>
	</table>
	<br>
	<p><input type='submit' name='AddGrocery'></input></p>
</form>
</body>
<br>

<h2>Delete grocery</h2>
<p>Please enter the id of the grocery you want to delete</p>
<form action='delete' method='get'>
The Id of the grocery you want to delete: <input type="text" name="deleteId"><br>
<input type="submit" value="DeleteGrocery">
</form>
<br>

<h2>Search</h2>
<form action='search' method='get'>
The category you want to search: <input type="text" name="category"><br>
<input type="submit" value="SearchGategory">
</form>
</html>


