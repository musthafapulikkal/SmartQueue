<?php
include("connection.php");
$docmail=$_POST['doc_email'];
$qseat=$_POST['qseatno'];
$sql="select * from tbl_doc_reg where email='$docmail'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0)
 {
	$row=mysqli_fetch_assoc($res);
	$did=$row['id'];
	$q="update tbl_seat_details set q_status='1' where doc_id='$did' and seatno='$qseat'";
	$r=mysqli_query($connect,$q);
	if ($r) {
		echo "success";
	}
 }
?>