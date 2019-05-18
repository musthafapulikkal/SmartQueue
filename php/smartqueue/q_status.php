<?php
include("connection.php");
$did=$_POST['did'];
$q="select * from tbl_seat_details where doc_id='$did' and q_status='1'";
	$r=mysqli_query($connect,$q);
	if ($r) {
		while($row=mysqli_fetch_assoc($r))
		{

			$data[]=array("seat"=>$row['seatno'],"status"=>$row['q_status']);

		}
	echo json_encode($data);
	}
?>