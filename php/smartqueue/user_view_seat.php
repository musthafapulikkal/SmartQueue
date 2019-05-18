<?php
include("connection.php");
$docid=$_POST['did'];
$sql="select * from tbl_seat where doc_id='$docid'";
$res=mysqli_query($connect,$sql);
	if (mysqli_num_rows($res)==1)
	{
		$row=mysqli_fetch_assoc($res);
		echo $seatno=$row['seats'];
	}
	else
	{
		echo "failed";
	}
?>