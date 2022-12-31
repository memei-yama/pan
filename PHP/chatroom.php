<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>chatroom</title>
</head>
<body>
<?php

//新規家族追加
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
    list($user_ids) = chatroomDB.searchSendUser($room_id, $user_id);
    return $user_ids;
}


?>
</body>
</html>