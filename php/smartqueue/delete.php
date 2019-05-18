<?php
include("connection.php");
$id=$_POST['id'];
$sql="delete from tbl_doc_reg where id='$id'";
$res=mysqli_query($connect,$sql);
if ($res) {
	echo "success";
}
?>