<?php
include("connection.php");
$email=$_POST['d_email'];
$seat=$_POST['seat'];
$sql="select * from tbl_doc_reg where email='$email'";
$res=mysqli_query($connect,$sql);
if (mysqli_num_rows($res)>0) {
	$row=mysqli_fetch_assoc($res);
	$did=$row['id'];

     $s="select * from tbl_seat where doc_id='$did'";
     $r=mysqli_query($connect,$s);
     if (mysqli_num_rows($r)>0) {
     	echo "exist";
     }
     else
     {
     	$qry="insert into tbl_seat(doc_id,seats)values('$did','$seat')";
	$exe=mysqli_query($connect,$qry);
	if ($exe) {
		switch ($seat) {
			case '10':
				for ($i=1; $i <= $seat; $i++) { 
					$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
					$r=mysqli_query($connect,$q);
				}
				break;
				case '11':
					for ($i=1; $i <= $seat; $i++) { 
					$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
					$r=mysqli_query($connect,$q);
				}
					break;
					case '12':
						for ($i=1; $i <= $seat; $i++) { 
					$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
					$r=mysqli_query($connect,$q);
				}
						break;
						case '13':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '14':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '15':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '16':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '17':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '18':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '19':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
						case '20':
							for ($i=1; $i <= $seat; $i++) 
							{ 
							$q="insert into tbl_seat_details(doc_id,seatno,patient,age,phone)values('$did','$i','null','null','null')";
							$r=mysqli_query($connect,$q);
							}
						break;
			
			default:
				echo "failed";
				break;
		}
		echo "success";
	}
	else
	{
		echo "failed";
	}
     }

	
	}

?>