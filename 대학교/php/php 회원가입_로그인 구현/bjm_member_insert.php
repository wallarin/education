<?php
$id = $_POST["id"];
$pass = $_POST["pass"];
$name = $_POST["name"];
$gender = $_POST["gender"];

$con = mysqli_connect("localhost", "root", "", "sample");

$sql = "insert into bjm_member(id, pass, name, gender) ";
$sql .= "values('$id', '$pass', '$name', '$gender')";

mysqli_query($con, $sql);
mysqli_close($con);
?>