<?php
include("connection.php");
$sql="select * from tbl_doc_reg where status='0'";
$res=mysqli_query($connect,$sql);
if ($res) {
while($row=mysqli_fetch_assoc($res))
{
$image="uploads/". $row['image'];
$data[]=array("id"=>$row['id'],"name"=>$row['name'],"clinick"=>$row['hos'],"image"=>$image);

}
echo json_encode($data);
}
?>
