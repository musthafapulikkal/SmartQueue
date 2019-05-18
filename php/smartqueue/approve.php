<?php
include("connection.php");
$id=$_POST['id'];
$sql="update tbl_doc_reg set status='1' where id='$id'";
$res=mysqli_query($connect,$sql);
if ($res) 
{
	echo "success";
}
?>