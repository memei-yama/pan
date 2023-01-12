<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>familyProcess</title>
</head>
<body>
<?php

//新規家族追加
function makeFamilyGroup($family_name){
    $family_id = familyDB.familyadd();
    return $family_id;
}

//ユーザ検索
function searchUser($user_mail){
    list($user_id, $user_name) = familyDB.searchUser($user_mail);
    return array($user_id, $user_name);
}

//家族更新（家族名の更新）
function updateFamily($family_id, $family_name){
    familyDB.updateFamily($family_id, $family_name);
}


//家族登録請求（ユーザを家族に追加）
function familyAddRequest($family_id, $user_id){
    $request_id = familyProcess . familyAddRequest($family_id, $user_id);
    return $request_id;
}
//家族登録（ユーザを家族に追加）
function familyAdd($request_id){
    list($family_id, $user_id) = familyDB . getFamilyAddRequest($request_id);
    $group_id = familyDB.familyAdd($family_id, $user_id);
    familyDB . deleteFamilyAddRequest($request_id);
    return $group_id;
}
//フレンド登録請求
function friendAddRequest($friend_id1, $friend_id2){
    $request_id = familyDB.friendAddRequest($friend_id1, $friend_id2);
    return $request_id;
}

//フレンド登録
function friendAdd($request_id){
    list(friend_id1, friend_id2) = familyDB . getFriendAddRequest($request_id);
    $group_id = familyDB . friendAdd(Friend_id1, friend_id2);
    familyDB . deleteFriendAddRequest($request_id);
    return $group_id;
}

//フレンド削除
function deleteFriend($group_id){
    userDB.deleteFriend($group_id);
}

//家族情報取得
function searchFamily($user_id){
    list($group_id, $family_id) = familyDB.searchFamily($user_id);
    return array($group_id, $family_id);
}

//フレンド情報取得
function searchFriend($user_id){
    list($group_id, $frienduser_id, $frienduser_name) = familyDB.searchFriend($user_id);
    return array($group_id, $frienduser_id, $frienduser_name);
}



?>
</body>
</html>