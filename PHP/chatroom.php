<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>chatroom</title>
</head>
<body>
<?php

//チャット内容取得
function getChat($room_id){
    list($serial_number, $date, $char_body, $user_id) = chatroomDB.getChat($room_id);
    return array($serial_number, $date, $char_body, $user_id);
}

//メッセージ保存
function addChat($room_id, $user_id, $char_body){
    list($serial_number, $date) = chatroomDB.addChat($room_id, $user_id, $char_body);
    return array($serial_number, $date);
}

//送信先ユーザ検索
function searchSendUser($room_id, $user_id){
    list($send_user) = chatroomDB.searchSendUser($room_id, $user_id);
    return $send_user;
}


?>
</body>
</html>