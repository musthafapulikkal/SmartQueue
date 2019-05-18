<?php
include("connection.php");
$sql="select * from tbl_doc_reg";
$res=mysqli_query($connect,$sql);
while($row=mysqli_fetch_assoc($res))
{

$data[]=array("id"=>$row['id'],"city"=>$row['place']);

}
echo json_encode($data);
?>