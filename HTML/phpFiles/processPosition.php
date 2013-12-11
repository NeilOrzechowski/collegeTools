

<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "password";
$dbname = "collegetools";
$tableName = "users";
	//Connect to MySQL Server




$info = json_decode($_POST["info"], true);


$columns = implode(", ",array_keys($info));
$escaped_values = array_map('mysql_real_escape_string', array_values($info));
$values  = implode(", ", $escaped_values);
$sql = "INSERT INTO $tableName($columns) VALUES ($values)";


$con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
	//Select Database
mysqli_select_db($con,$dbname) or die(mysql_error());
mysqli_query($con,$sql) or die(mysql_error());


/*foreach ($info as $inf)
{
    echo "id: ".$inf['id']."<br>";
    echo "col: ".$inf['col']."<br>";
    echo "row: ".$inf['row']."<br>";
    echo "size_x: ".$inf['size_x']."<br>";
    echo "size_y: ".$inf['size_y']."<br>";
    echo "<br>";
}*/
?>