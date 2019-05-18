<?php
include("connection.php");
$not=$_POST['notification'];
$sql="insert into tbl_notification(notification)values('$not')";
$res=mysqli_query($connect,$sql);
if ($res) {
	echo "success";
}
else
{
	echo "failed";
}
?>