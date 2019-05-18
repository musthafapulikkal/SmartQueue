<?php
include("connection.php");
$doc_id=$_POST['docid'];
$patient=$_POST['patient'];
$phone=$_POST['phone'];
$age=$_POST['age'];
$token=$_POST['token'];
$sql="update tbl_seat_details set status='1',patient='$patient',age='$age',phone='$phone' where seatno='$token' and doc_id='$doc_id'";
$res=mysqli_query($connect,$sql);
if ($res) {
	echo "success";
}
?>