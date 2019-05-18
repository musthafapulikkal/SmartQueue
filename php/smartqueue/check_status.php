<?php
include("connection.php");
$sql="select * from tbl_seat_details where status='1'";
$res=mysqli_query($connect,$sql);
if ($res) {
	while($row=mysqli_fetch_assoc($res))
{

$data[]=array("seatno"=>$row['seatno'],"status"=>$row['status']);

}
echo json_encode($data);
}
?>