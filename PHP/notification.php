<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>notification</title>
</head>
<body>
<?php
//通知モジュール
function updateCheckUser($user_id){
    list($ar_id, $user_id2, $family_id) = notificationDB.updateCheckUser($user_id)
    return array($ar_id, $user_id2, $family_id);
}

//更新確認モジュール（チャット）
function updateCheckChat($user_id){
    list($update_tf, $update_date) = notificationDB.updateCheckChat($user_id);
    return array($update_tf, $update_date);
}

//チャット更新
function getUpdateChat($user_id, $update_date){
    list($serial_number, $room_id, $send_date, $char_body, $user_id2) = notificationDB.getUpdateChat($user_id, $update_date);
    notificationDB.updateCheckTime();
    return array($serial_number, $room_id, $send_date, $char_body, $user_id2);
}

//更新確認モジュール（タイムライン）
function updateCheckTimeline($user_id){
    list($update_tf, $update_date) = updateCheckTimeline($user_id);
    return array($update_tf, $update_date);
}

//タイムライン更新
function getUpdateTimeline($user_id, $update_date){
    list($timeline_id, $user_id2, $food_id, $send_date, $char_body, $reaction_number, $image_rink) = notificationDB.getUpdatechat($user_id, $update_date);
    //画像ファイルリンクより画像データと画像名を取得
    notificationDB.updateCheckTime();
    return array($timeline_id, $user_id2, $food_id, $send_date, $char_body, $reaction_number, $image_data, $image_name);
}
?>
</body>
</html>