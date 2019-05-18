<?php
include("connection.php");
$name=$_POST['name'];
$email=$_POST['email'];
$state=$_POST['state'];
$district=$_POST['district'];
$place=$_POST['place'];
$hos=$_POST['hos'];
$pass=$_POST['pass'];
$image=$_POST['image'];
$target_dir = "uploads/";
	$target_dir = $target_dir."/".$name.".JPEG";
    if(file_exists($target_dir)){
        unlink($target_dir);
    }
	$upload_image=$name.".JPEG";
    if(file_put_contents($target_dir, base64_decode($image))){
		$query="insert into tbl_doc_reg(name,email,state,district,place,hos,password,image,status)values('$name','$email','$state','$district','$place','$hos','$pass','$upload_image','0')";
		$result=mysqli_query($connect,$query);
	if($result)
	{
	echo "success";
	}
	else
	{
		"invalid";
	}
}
// ";

?>