<?php
$servername = "localhost:3306";
$username = "root"; 
$password = ""; 
$dbname = "phpbanco"; // O nome do seu banco de dados

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>