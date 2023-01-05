<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>確認</title>
</head>
 
<body>
 
<h2>お知らせ内容</h2>    
 
<form action="mailto.php" method="post">
 
<table border="1">
<tr>
<td>お知らせ件名</td>
<td><?php echo $_POST["announce"]; ?></td>
</tr>
<tr>
<td>お知らせ内容</td>
<td><?php echo $_POST["detail"]; ?></td>
</tr>
</table>
 
<input type="submit" value="戻る" />
<input type="submit" value="送信" />
</form>
 
</body>
    
</html>