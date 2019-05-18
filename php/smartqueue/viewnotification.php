<?php
include("connection.php");
$sql="select * from tbl_notification";
$res=mysqli_query($connect,$sql);
if ($res) {
while($row=mysqli_fetch_assoc($res))
{
$data[]=array("notification"=>$row['notification']);

}
echo json_encode($data);
}
?>