<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>お知らせ</title>
    </head>
    <body>
        <form action="SendAnnounce.php" method="post">
            お知らせ件名：<br />
            <input type="text" name="name" size="50" value="" /><br />

 
            お知らせ内容：<br />
            <textarea name="inquiry" cols="50" rows="5"></textarea><br />
            <br />
 
            <input type="button" onclick="history.back()" value="戻る" style="width:100px;height:50px">
            <input type="submit" value="確認" style="width:100px;height:50px" />
        </form>
    </body>
</html>