<?php 
// Start session 
session_start(); 
  
// Include required functions file 
require_once('includes/functions.inc.php'); 
  
// Check login status... if not logged in, redirect to login screen 
if (check_login_status() == false) { 
              redirect('login.php'); 
} 
?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"> 
<head> 
              <meta http-equiv="Content-type" content="text/html;charset=utf-8" /> 
              <title>Creating a Simple PHP and MySQL-Based Login System - dev.thatspoppycock.com</title> 
</head> 
<body> 
              <h1>Administration Panel</h1> 
              <p>You are currently logged in. You may log out using the button below.</p> 
              <p><a href="includes/logout.inc.php">Log Out</a></p> 
              <p>Click below to return to main page</p> 
              <p><a href="../main.html">main</a></p> 
</body> 
</html> 
  
