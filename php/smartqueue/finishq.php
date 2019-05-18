<?php
include("connection.php");
$docmail=$_POST['demail'];
$sql="select * from tbl_doc_reg where email='$docmail'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0)
 {
	$row=mysqli_fetch_assoc($res);
	$did=$row['id'];
	$sq="delete from tbl_seat where doc_id='$did'";
	$re=mysqli_query($connect,$sq);
	if ($re) {
		$qry="delete from tbl_seat_details where doc_id='$did'";
	    $result=mysqli_query($connect,$qry);
	    if ($result) {
	    	echo "success";
	    }
	}
 }
?>