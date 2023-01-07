<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>確認</title>
</head>
 
<body>
 
<h2>お知らせ内容</h2>    
 
<form action="FinAnnounce.php" method="post">
 
<table border="1">
<tr>
<td>お知らせ件名</td>
<td><?php echo $_POST["announce"]; ?></td>
</tr>
<tr>
<td>お知らせ内容</td>
<td><?php echo $_POST["announce_detail"]; ?></td>
</tr>
</table>
 
<input type="button" onclick="history.back()" value="戻る" style="width:100px;height:50px">
<input type="submit" value="送信" style="width:100px;height:50px" />
</form>
 
</body>
    
</html>