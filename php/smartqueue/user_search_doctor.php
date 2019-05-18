<?php
include("connection.php");
$state=$_POST['state'];
$dist=$_POST['district'];
$city=$_POST['city'];
$sql="select * from tbl_doc_reg where state='$state' and district='$dist' and place='$city'";
$res=mysqli_query($connect,$sql);
while($row=mysqli_fetch_assoc($res))
{
$image="uploads/". $row['image'];
$data[]=array("id"=>$row['id'],"name"=>$row['name'],"clinick"=>$row['hos'],"image"=>$image);

}
echo json_encode($data);
?>