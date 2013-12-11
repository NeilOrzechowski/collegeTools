

<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "password";
$dbname = "collegetools";
	//Connect to MySQL Server
$con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
	//Select Database
mysqli_select_db($con,$dbname) or die(mysql_error());



$products = json_decode($_POST["products"], true);

foreach ($products as $product)
{
    echo "id: ".$product['id']."<br>";
    echo "col: ".$product['col']."<br>";
    echo "row: ".$product['row']."<br>";
    echo "size_x: ".$product['size_x']."<br>";
    echo "size_y: ".$product['size_y']."<br>";
    echo "<br>";
}

/*
	// Retrieve data from Query String
$name = $_GET['name'];
$password = $_GET['password'];
	// Escape User Input to help prevent SQL Injection
$name = mysqli_real_escape_string($con,$name);
$password = mysqli_real_escape_string($con,$password);

	//build query
$query = "SELECT * FROM user WHERE name = '$name'";
$query .= " AND password == $password";
/*if(is_numeric($age))
	$query .= " AND age <= $age";
if(is_numeric($wpm))
	$query .= " AND wpm <= $wpm";*/
	//Execute query
/*$qry_result = mysqli_query($con,$query) or die(mysql_error());

	//Build Result String
$display_string = "<table>";
$display_string .= "<tr>";
$display_string .= "<th>Name</th>";
$display_string .= "</tr>";

// Insert a new row in the table for each person returned
while($row = mysqli_fetch_array($qry_result)){
	$display_string .= "<tr>";
	$display_string .= "<td>" "username: " + $row[name]+" is loaded"</td>";
	$display_string .= "</tr>";
	
}
//echo "Query: " . $query . "<br />";
$display_string .= "</table>";
echo $display_string;*/
?>