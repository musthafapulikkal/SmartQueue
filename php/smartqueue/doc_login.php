<?php
include("connection.php");
$email=$_POST['email'];
$pass=$_POST['password'];
$sql="select * from tbl_doc_reg where email='$email' and password='$pass'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0) {
	echo $email;
}
else
{
echo "failed";
}
?>