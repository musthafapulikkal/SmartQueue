<?php
include("connection.php");
$demail="dheeraj@gmail.com";
$s="select * from tbl_doc_reg where email='$email'";
$re=mysqli_query($connect,$s);
if (mysqli_num_rows($re)>0) {
	$row=mysqli_fetch_assoc($re);
	$did=$row['id'];
	$sql="select * from tbl_seat_details where doc_id='$did' status='1'";
	$res=mysqli_query($connect,$sql);
	if ($res) {
	while($row=mysqli_fetch_assoc($res))
	{

	$data[]=array("bseat"=>$row['seatno']);

	}
	echo json_encode($data);
	}
	}

?>