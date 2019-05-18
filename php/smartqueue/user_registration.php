<?php
include("connection.php");
$email=$_POST['email'];
$name=$_POST['name'];
$contact=$_POST['contact'];
$password=$_POST['password'];
$sql="insert into tbl_user_reg(email,name,contact,password)values('$email','$name','$contact','$password')";
$res=mysqli_query($connect,$sql);
if ($res) {
	echo "success";
}
else
{
	echo "failed";
}
?>