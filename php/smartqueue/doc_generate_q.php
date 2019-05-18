<?php
include("connection.php");
$email=$_POST['d_email'];
$sql="select * from tbl_doc_reg where email='$email'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0) {
	$row=mysqli_fetch_assoc($res);
	$did=$row['id'];
	$qry="select * from tbl_seat where doc_id='$did'";
	$exe=mysqli_query($connect,$qry);
	if (mysqli_num_rows($exe)==1)
	{
		$row=mysqli_fetch_assoc($exe);
		echo $seatno=$row['seats'];
	}
	else
	{
		echo "failed";
	}
	}


?>