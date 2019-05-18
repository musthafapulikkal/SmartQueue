<?php
include("connection.php");
$demail=$_POST['demail'];
$sql="select * from tbl_doc_reg where email='$demail'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0)
 {
	$row=mysqli_fetch_assoc($res);
	$did=$row['id'];
	$q="select * from tbl_seat_details where doc_id='$did' and q_status='1'";
	$r=mysqli_query($connect,$q);
	if ($r) {
		while($row=mysqli_fetch_assoc($r))
		{

			$data[]=array("seat"=>$row['seatno'],"status"=>$row['q_status']);

		}
	echo json_encode($data);
	}
}
?>