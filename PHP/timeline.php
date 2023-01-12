<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>timeline</title>
</head>
<body>
<?php
//タイムライン情報取得
function getTimeline($user_id){
    list(
        $timeline_id,
        $user_id,
        $food_id,
        $send_date,
        $char_body,
        $reaction_number,
        $image_rink
    ) = timelineDB.getTimeline($user_id);
    $image_data = file_get_contents($image_rink);
        //画像ファイルリンクより画像データと画像名を取得
    return array($timeline_id, $user_id, $food_id, $send_date, $char_body, $reaction_number, $image_data, $image_name);
}

//リアクション追加
function addReaction($timeline_id, $user_id){
    timelineDB.addReaction($timeline_id, $user_id);
}

/*送信先ユーザ検索
function searchSendUser($timeline_id, $user_id){
    list($user_id) = timelineDB.searchSendUser($timeline_id, $user_id);
    return $user_id;
}
*/

//リアクションユーザ一覧情報取得
function getReaction($timeline_id){
    list($user_id, $reaction_date) = timelineDB.getReaction($timeline_id);
    return array($user_id, $reaction_date);
}

?>
</body>
</html>