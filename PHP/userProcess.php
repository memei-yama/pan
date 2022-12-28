<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>UserProcess</title>
</head>
<body>
<?php
//ユーザ新規登録
function creatUserAccount($user_name, $user_mail, $user_address, $user_passwd){
    $user_id = userDB.addUser($user_name, $user_mail, $user_address, $user_passwd);
    return $user_id;
}

//ユーザ削除
function deleteUserAccount($user_id){
    userDB.deleteUser($user_id);
}

//ユーザ情報取得
function returnUserInfo($user_id){
    list($user_name, $user_mail, $user_address, $user_passwd) = userDB.returnUser($user_id)
    return array($user_name, $user_mail, $user_address, $user_passwd);
}

//ユーザ情報更新
function updateUserInfo($user_id){

}

//パスワードを検索するメソッド
function searchPassword($user_id){
    $user_passwd = userDB.searchPasswordDB($user_id);
    return $user_passwd;
}

//ログインメソッド
function userLogin($user_id, $user_passwd){
    $password = searchPassword($user_id);
    if($user_id == $password){
        $result = true;
    }else{
        $result = false;
    }
    return $result;
}

//お知らせ取得メソッド
function getNews{
    list($serial_number, $date, $char_body) = userDB.getNews();
    return array($serial_number, $date, $char_body);
}
?>
</body>
</html>